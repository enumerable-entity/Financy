#!/bin/bash

appToRUn=$SPRING_APP_TO_RUN
artifactNameToRun="$(ls | grep "$appToRUn" | tail -1)"
java -jar "$artifactNameToRun"
