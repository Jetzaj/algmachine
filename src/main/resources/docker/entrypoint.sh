#! /bash/bin -e

env
cmd="java -DAppAddress=$AppAddress -DAppPort=$AppPort $JAVA_OPTS -jar ./*.jar"
echo $cmd
eval $cmd