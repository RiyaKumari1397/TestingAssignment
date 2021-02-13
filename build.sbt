name := "UT_IT"

version := "0.1"

scalaVersion := "2.13.4"


lazy val Assignment_1_2 = project.in(file("Assignment_1_2"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )


lazy val Assignment_3 = project.in(file("UT-IT"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
      "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
  )

lazy val root = project.in(file(".")).aggregate(Assignment_1_2, Assignment_3)