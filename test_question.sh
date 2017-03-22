#!/usr/bin/env bash

question_number=$1
sbt "test-only *Question${question_number}Spec*"
