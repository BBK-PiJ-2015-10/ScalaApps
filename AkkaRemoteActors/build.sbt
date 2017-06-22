name := "remote-actors"

version := "1.0"

organization := "com.palacios"

scalaVersion := "2.12.2"

resolvers += Resolver.url("repo",url("http://repo.typesafe.com/typesafe/releases/"))

lazy val akkaVersion = "2.5.2"

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor" % akkaVersion,
	"com.typesafe.akka" %% "akka-testkit" % akkaVersion,
	"com.typesafe.akka" %% "akka-remote" % akkaVersion,
	"org.scalatest" %% "scalatest" % "3.0.1" % "test",
	"jline" % "jline" % "2.13",
	"joda-time" % "joda-time" % "2.9.2"
)
	
