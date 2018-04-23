name := "Candles"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

parallelExecution in Test := false

definedTests in Test ~= { _.sortBy(_.name) }

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.1" % "test"

libraryDependencies += "io.gatling" % "gatling-test-framework" % "2.3.1" % "test"

enablePlugins(GatlingPlugin)