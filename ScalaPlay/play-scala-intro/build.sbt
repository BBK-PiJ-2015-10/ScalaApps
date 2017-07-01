name := """play-scala-intro"""
organization := "com.palaciosalejandro"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test
libraryDependencies += "org.sorm-framework" % "sorm" % "0.3.21"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.palaciosalejandro.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.palaciosalejandro.binders._"
