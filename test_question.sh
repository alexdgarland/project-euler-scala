#!/usr/bin/env bash

question_number=$1
sbt "testOnly *Question${question_number}Spec*"
