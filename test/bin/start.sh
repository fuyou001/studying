#!/bin/sh

cd `dirname $0`/..
BASEDIR=`pwd`
if [  -z $1 ];then
  echo "fileNames is null...."
  exit 1
 fi
fileNames=$1
nohup java -server -cp $BASEDIR/lib/*:. notify.Main $fileNames > $2  2>&1 &