import sbt._
import Keys._
import sbt.Reference._

object build extends Build {

  import DependencyManagement._

  // Settings shared by all sub-projects.
  val standardSettings: Seq[Project.Setting[_]] =
    Seq[Project.Setting[_]](
      ivyXML := DependencyManagement.ivyExclusionsAndOverrides,
      scalaVersion := "2.10.2",
      resolvers ++= Seq("snapshots" at "http://scala-tools.org/repo-snapshots",
        "releases" at "http://scala-tools.org/repo-releases")
    )

  //
  // PROJECTS
  //

  // Parent Project, it aggregates all others.
  lazy val root = Project(
    id = "specs2-example",
    base = file("."),
    settings = Defaults.defaultSettings ++ standardSettings,
    aggregate = Seq[ProjectReference](example)
  )

  lazy val example = Project(
    id = "examples",
    base = file("examples"),
    settings = Defaults.defaultSettings ++ standardSettings ++ Seq(
      libraryDependencies ++= Seq(Specs) ++ SpecsDeps
    )
  )
}
