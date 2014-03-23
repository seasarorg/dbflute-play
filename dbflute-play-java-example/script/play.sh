#!/bin/bash

cd `dirname $0`

cd ../
./etc/tools/play/play "$@"

sh dbflute_exampledb/manage.sh refresh
