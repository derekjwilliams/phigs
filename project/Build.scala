import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName          = "phigs"
  val appVersion       = "1.0-SNAPSHOT"
  val orientDBVersion  = "1.3.0"
  val tinkerpopVersion = "2.3.0" 

  val appDependencies = Seq(
    "com.wingnest.play2" % "play21-frames-orientdb-plugin_2.10" % "1.0-SNAPSHOT",
    "com.orientechnologies" % "orientdb-core" % {orientDBVersion},
    "com.orientechnologies" % "orient-commons" % {orientDBVersion},
    "com.orientechnologies" % "orientdb-client" % {orientDBVersion},
    "com.orientechnologies" % "orientdb-nativeos" % {orientDBVersion},
    "com.orientechnologies" % "orientdb-server" % {orientDBVersion},
    "com.orientechnologies" % "orientdb-object" % {orientDBVersion},
    "com.orientechnologies" % "orientdb-enterprise" % {orientDBVersion},
    "com.orientechnologies" % "orientdb-distributed" % {orientDBVersion},
    "com.tinkerpop.blueprints" % "blueprints-core" % {tinkerpopVersion},
    "com.tinkerpop.blueprints" % "blueprints-test" % {tinkerpopVersion},
    "com.tinkerpop" % "frames" % {tinkerpopVersion},          
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean
  )

  import com.typesafe.sbteclipse.core._
  import com.typesafe.sbteclipse.core.EclipsePlugin._
  import scala.xml.transform.RewriteRule

  val main = play.Project(appName, appVersion, appDependencies).settings(
    EclipseKeys.projectFlavor := EclipseProjectFlavor.Scala,
    EclipseKeys.projectTransformerFactories := Seq[EclipseTransformerFactory[RewriteRule]]()     
  )

}
