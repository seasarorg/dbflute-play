name := "example-play-extension"

version := "1.0-SNAPSHOT"

organization := "com.example.dbflute"

libraryDependencies += "com.typesafe.play" %% "play-java" % "2.2.2"

publishTo := Some(Resolver.file("project-repository", new File("../m2repo")))
