#!/usr/bin/env bash

sbt "test-only -- -l org.scalatest.tags.Slow"
