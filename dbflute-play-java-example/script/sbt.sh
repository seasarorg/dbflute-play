#!/bin/bash

cd `dirname $0`
cd ..

java -Xmx512M -XX:MaxPermSize=256M -jar ./etc/tools/sbt/sbt-launch.jar "$@"

sh dbflute_exampledb/manage.sh refresh
