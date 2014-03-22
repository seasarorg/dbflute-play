#!/bin/bash

cd `dirname $0`
cd ..

java -Xmx512M -XX:MaxPermSize=256M -jar ./etc/sbt/sbt-launch.jar "$@"
