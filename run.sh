#! /bin/sh

# 

if [ -z "$JAVA_HOME" ] ; then
  JAVA=`which java`
  if [ -z "$JAVA" ] ; then
    echo "Cannot find JAVA. Please set your PATH."
    exit 1
  fi
  JAVA_BIN=`dirname $JAVA`
  JAVA_HOME=$JAVA_BIN/..
fi

JAVA=$JAVA_HOME/bin/java

CLASSPATH=`echo ../dom4j/lib/*.jar | tr ' ' ':'`:$CLASSPATH
CLASSPATH=`echo lib/*.jar | tr ' ' ':'`:$CLASSPATH
CLASSPATH=build/classes:../dom4j/build/classes:$CLASSPATH:$JAVA_HOME/lib/tools.jar


$JAVA -classpath $CLASSPATH "$@"
