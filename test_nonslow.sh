#!/usr/bin/env bash

sbt "testOnly -- -l org.scalatest.tags.Slow"
