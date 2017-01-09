package com.rbox24

import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer082
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer
import org.apache.flink.streaming.util.serialization.{DeserializationSchema, SerializationSchema}
import org.apache.flink.streaming.util.serialization.SimpleStringSchema
import java.util.Properties
import com.snowplowanalytics.snowplow.analytics.scalasdk.json.EventTransformer

object Enriched2JSON {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val properties = new Properties()
    properties.setProperty("bootstrap.servers", "localhost:9092")
    properties.setProperty("zookeeper.connect", "localhost:2181")
    properties.setProperty("group.id", "flinktest")

    val kafkaConsumer = new FlinkKafkaConsumer082[String](
      "snowplow-enriched-good",
      new SimpleStringSchema,
      properties
    )

    val kafkaProducer = new FlinkKafkaProducer[String](
      "localhost:9092",
      "snowplow-enriched-good-json",
      new SimpleStringSchema
    )

    val lines = env.addSource(kafkaConsumer)
    lines.rebalance.map(x=> EventTransformer.transform(x)).filter(_.isSuccess).flatMap(_.toOption).addSink(kafkaProducer)

    env.execute()
  }

}
