name := "simple-messaging"

version := "1.0"

organization := "com.palacios"

scalaVersion := "2.12.2"

//resolvers += Resolver.url("repo",url("http://repo.typesafe.com/typesafe/releases/"))
//resolvers += "spray repo" at "http://repo.spray.io"

resolvers +=Resolver.url("repo",url("http://repo.typesafe.com/typesafe/releases/"));




libraryDependencies ++= {
	val akkaVersion = "2.5.2"
	//val sprayVersion = "1.3.1"
	Seq(
		"com.typesafe.akka" %% "akka-actor" % akkaVersion,
		//"io.spray" %% "spray-can" % sprayVersion,
		//"io.spray" %% "spray-routing" % sprayVersion,
		//"io.spray" %% "spray-json" % "1.2.6",
		"com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
		//"ch.qos.logback" % "logback-classic" % "1.1.2",
		"com.typesafe.akka" %% "akka-testkit" % akkaVersion,
		"org.scalatest" %% "scalatest" % "3.0.1" % "test"
	)
}
	
