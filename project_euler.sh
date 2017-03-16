#!/usr/bin/env bash

scopt_location=~/.ivy2/cache/com.github.scopt/scopt_2.12/jars/*.jar
target_jar=$( dirname "${BASH_SOURCE[0]}" )/target/scala-2.12/project-euler_2.12-0.1.0-SNAPSHOT.jar

scala -classpath ${scopt_location} ${target_jar} $@
