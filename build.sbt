lazy val commonSettings = Seq(
  organization := "com.metreta",
  version := "1.4-alpha-1",
  scalaVersion := "2.10.6",
  libraryDependencies ++= Seq(
    "com.orientechnologies" % "orientdb-core" % "2.0.15",
    "com.orientechnologies" % "orientdb-client" % "2.0.15",
    "com.orientechnologies" % "orientdb-jdbc" % "2.0.15",
    "com.orientechnologies" % "orientdb-graphdb" % "2.0.15",
    "com.orientechnologies" % "orientdb-distributed" % "2.0.15",
    "org.scalatest" %% "scalatest" % "2.2.4",
    "org.apache.spark" %% "spark-core" % "1.4.0",
    "org.apache.spark" %% "spark-graphx" % "1.4.0",
    "org.apache.spark" %% "spark-unsafe" % "1.4.0",
    "org.apache.spark" %% "spark-network-common" % "1.4.0",
    "org.apache.spark" %% "spark-network-shuffle" % "1.4.0",
    "org.apache.spark" %% "spark-launcher" % "1.4.0",
    "com.tinkerpop.blueprints" % "blueprints-core" % "2.6.0"
    ),
    externalResolvers := Seq(DefaultMavenRepository),
    parallelExecution in Test := false
)

lazy val connector = (project in file("./spark-orientdb-connector")).
  settings(commonSettings: _*).
  settings(
    name := "spark-orientdb-connector"
    )

lazy val demos = (project in file("./spark-orientdb-connector-demos")).
  settings(commonSettings: _*).
  settings(
    name := "spark-orientdb-connector-demos"
    ).
   dependsOn(connector)