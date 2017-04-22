#!/bin/bash

# Copyright (C) KOLIBERO Piotr Goliasz - All Rights Reserved
# Unauthorized copying of this file, via any medium is strictly prohibited
# Proprietary and confidential
# Written by Piotr Goliasz <piotr.goliasz@kolibero.eu>, December 2015

base=$PROJECT_HOME
prog=$PROJECT_HOME'/src/main/script/enriched2json_submit.sh'

if [[ $(pgrep -f $prog) ]]; then
   echo $prog+" is running";
else
   echo $prog+" not running, so I must do something";
   # Make live again
   $prog &
fi
