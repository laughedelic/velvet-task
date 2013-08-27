package ohnosequences.statika

import ohnosequences.statika._

case object VelvetTask extends Bundle(Velvet :: S3cmd :: HNil) {

  val metadata = generated.metadata.VelvetTask

  def install[D <: DistributionAux](distribution: D): InstallResults = {
    // do someting here
    success("%s is installed" format metadata)
  }

}
