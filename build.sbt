name := "cardano-scala-client-test"

organization in ThisBuild := "com.github.speedwing"
scalaVersion in ThisBuild := "2.13.3"

lazy val root = project
  .in(file("."))
  .settings(
    libraryDependencies ++= Seq(
      "solutions.iog" %% "psg-cardano-wallet-api" % "0.2.3"
    ))
