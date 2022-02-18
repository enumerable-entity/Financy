#!/bin/bash

appToRUn=$SPRING_APP_TO_RUN
artifactNameToRun="$(ls | grep "$appToRUn")"
java -jar "$artifactNameToRun"
