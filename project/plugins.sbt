resolvers ++= Seq(
  "sbt-idea-repo" at "http://mpeltonen.github.com/maven/",
  ScalaToolsSnapshots
)

//libraryDependencies <+= (sbtVersion).apply { sv =>
//  "com.github.mpeltonen" %% "sbt-idea" % sv
//}

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.4.0")
