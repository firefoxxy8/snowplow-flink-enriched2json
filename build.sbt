name := "snowplow-flink-et"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies ++= Seq(
  "org.apache.flink" % "flink-core" % "1.1.3",
  "org.apache.flink" %% "flink-scala" % "1.1.3",
  "org.apache.flink" %% "flink-streaming-scala" % "1.1.3",
  "org.apache.flink" %  "flink-connector-kafka-0.8_2.10" % "1.1.3-hadoop1", 
  "com.snowplowanalytics" %% "snowplow-scala-analytics-sdk" % "0.1.0"
)

resolvers += "Snowplow Analytics" at "http://maven.snplow.com/releases/"

