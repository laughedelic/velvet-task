package ohnosequences.statika

import ohnosequences.statika._
import sys.process._

case object SpecialVelvet extends VelvetOpts(
	categories = 5
  , maxKmerLength = 99
  ) {
  val metadata = generated.metadata.SpecialVelvet
}

case object VelvetTask extends Bundle(SpecialVelvet :: S3cmd :: HNil) {

  val metadata = generated.metadata.VelvetTask

  // Adding method to run commands from a given path
  implicit class PBAt(cmd: Seq[String]) {
    implicit def @@(path: String): ProcessBuilder =
      Process(cmd, new java.io.File(path), "" -> "")
  }

  def install[D <: DistributionAux](distribution: D): InstallResults = {

    val trace = List[ProcessBuilder](
      Seq("mkdir", "task")
    , Seq("s3cmd", "get", "s3://team3-resources/reads.tgz") @@ "task"
    , Seq("tar", "-xvf", "./reads.tgz") @@ "task"
    , Seq("velveth", "./assembly-folder", "99", "-short", "-fastq", "reads.fastq") @@ "task"
    , Seq("velvetg", "./assembly-folder", "-exp_cov", "auto", "-read_trkg", "yes") @@ "task"
    , Seq("s3cmd", "put", "--recursive", "assembly-folder/", 
    		"s3://team3-results/alexey/assembly/") @@ "task"
    ).foldLeft(List[InstallResult]()){ (acc, cmd) =>
      if (acc exists (_.isLeft)) acc
      else if (cmd.! != 0) acc ::: failure(cmd.toString)
      else acc ::: success(cmd.toString)
    }

    if (trace exists (_.isLeft)) trace
    else success("%s is installed" format metadata)
  }

}
