  libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "1.14" % "test"
        
    // with Scala 2.9.2 (specs2 1.12.3 is the latest version for scala 2.9.2)
    // "org.specs2" %% "specs2" % "1.12.3" % "test",
  )
  
  // Read here for optional dependencies: 
  // http://etorreborre.github.com/specs2/guide/org.specs2.guide.Runners.html#Dependencies

  resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                    "releases"  at "http://oss.sonatype.org/content/repositories/releases")
