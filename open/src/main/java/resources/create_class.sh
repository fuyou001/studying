#!/bin/sh

cd ..
SRC_DIR=`pwd`    ;
echo  $SRC_DIR/java
DST_DIR=$SRC_DIR;

protoc -I=$SRC_DIR/resources --java_out=$DST_DIR/java $SRC_DIR/resources/addressbook.proto

