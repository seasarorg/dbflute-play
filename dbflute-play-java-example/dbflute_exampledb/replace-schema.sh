#!/bin/bash

cd `dirname $0`
. _project.sh

echo "/nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
echo "...Calling the ReplaceSchema task"
echo "nnnnnnnnnn/"
sh $DBFLUTE_HOME/etc/cmd/_df-replace-schema.sh $MY_PROPERTIES_PATH
taskReturnCode=$?

if [ $taskReturnCode -ne 0 ];then
  exit $taskReturnCode;
fi

# for (dummy) replication
EXAMPLEDB_DIR=../src/main/resources/exampledb
rm -f $EXAMPLEDB_DIR/exampledb_slave.h2.db
cp -f $EXAMPLEDB_DIR/exampledb_master.h2.db $EXAMPLEDB_DIR/exampledb_slave.h2.db
