name := "dbflute-play-java-example"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.seasar.dbflute" % "dbflute-runtime" % "1.0.5A",
  "org.seasar.container" % "s2-tiger" % "2.4.44"
)

play.Project.playJavaSettings

resolvers += "The Seasar Foundation Maven2 Repository" at "http://maven.seasar.org/maven2"
