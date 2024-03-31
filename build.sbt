import scala.collection.Seq

name := """play-akka-2.6-v1"""
organization := "com.supriyo"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.8"

libraryDependencies += guice

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.49"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.0",
//  "com.typesafe.akka" %% "akka-slf4j" % "2.4.0",
 // "ch.qos.logback" % "logback-classic" % "1.2.3"
)
//for lombok
libraryDependencies += "org.projectlombok" % "lombok" % "1.18.20" % Provided