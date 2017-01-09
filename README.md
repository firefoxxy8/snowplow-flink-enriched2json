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

