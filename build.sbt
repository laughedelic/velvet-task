name := "velvet-task"

description := "A bundle for velvet-task tool"

homepage := Some(url("https://github.com/ohnosequences/velvet-task"))

licenses := Seq("AGPLv3" -> url("http://www.gnu.org/licenses/agpl-3.0.txt"))

bundleObjects := Seq(
  "ohnosequences.statika.VelvetTask"
, "ohnosequences.statika.SpecialVelvet"
)

libraryDependencies ++= Seq(
  "ohnosequences" %% "velvet" % "0.1.1"
, "ohnosequences" %% "s3cmd" % "0.1.0"
) 
