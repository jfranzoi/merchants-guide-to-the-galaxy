#!/usr/bin/env bash

mvn -q clean package -DskipTests exec:java -Dexec.arguments=$@