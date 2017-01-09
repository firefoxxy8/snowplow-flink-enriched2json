# Snowplow Flink Enriched Event 2 JSON

Example of Flink program translating enriched Snowplow events to JSON format. Flink job is reading messages from snowplow-enriched-good Kafka topic. Translates to JSON format and writes messages to snowplow-enriched-good-json topic.

## Building JAR

Lightweigh JAR.

```
$ sbt package
```

Fat JAR containing dependent libraries

```
$ sbt assembly
```

## Flink Job Submission

```
~/flink-1.1.3/bin/flink run -d -c com.rbox24.Enriched2JSON target/scala-2.10/snowplow-flink-assembly-1.0.jar
```

## Hardcoded Kafka values
Source topic: snowplow-enriched-good
Target topic: snowplow-enriched-good-json

Bootstrap Servers: localhost:9092
Zookeeper: localhost:2181
Group ID: flinktest

