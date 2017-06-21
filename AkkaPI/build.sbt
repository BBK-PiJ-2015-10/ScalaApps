name := "Akka PI Example"

version := "1.0"

organization := "com.palacios"

scalaVersion := "2.12.2"

resolvers += Resolver.url("repo",url("http://repo.typesafe.com/typesafe/releases/"))
	
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.2"