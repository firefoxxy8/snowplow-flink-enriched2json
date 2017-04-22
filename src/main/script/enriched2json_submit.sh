#!/bin/sh

# Copyright (C) KOLIBERO Piotr Goliasz - All Rights Reserved
# Unauthorized copying of this file, via any medium is strictly prohibited
# Proprietary and confidential
# Written by Piotr Goliasz <piotr.goliasz@kolibero.eu>, December 2015

$FLINK_HOME/bin/flink run -c com.rbox24.Enriched2JSON $PROJECT_HOME/target/scala-2.10/snowplow-flink-assembly-1.0.jar
