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
. env.sh
cd ~
$PROJECT_HOME/src/main/script/enriched2json_submit-watchdog.sh
```

## Hardcoded Kafka values

Source topic: snowplow-enriched-good

Target topic: snowplow-enriched-good-json

Bootstrap Servers: localhost:9092

Zookeeper: localhost:2181

Group ID: flinktest

## Crontab Example

```
* * * * * . /root/snowplow-flink-enriched2json/env.sh&&$PROJECT_HOME/src/main/script/enriched2json_submit-watchdog.sh > root/enriched2json_submit-watchdog.log &2>1
```
