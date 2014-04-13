name := "dbflute-play-java-example"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  //javaJdbc,
  //javaEbean,
  cache,
  "org.seasar.dbflute" % "dbflute-runtime" % "1.0.5C",
  "org.seasar.container" % "s2-tiger" % "2.4.44",
  "com.h2database" % "h2" % "1.3.172",
  "com.example.dbflute" %% "example-play-extension" % "1.0-SNAPSHOT"
)

play.Project.playJavaSettings

resolvers += "The Seasar Foundation Maven2 Repository" at "http://maven.seasar.org/maven2"

resolvers += "Project Local Repository" at new File("../m2repo").getCanonicalFile().toURI().toString()

