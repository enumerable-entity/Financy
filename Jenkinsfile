//file:noinspection GroovyAssignabilityCheck
pipeline {

    agent { label 'RaspberryPi_MasterNode' }
    tools
            {
                maven 'Maven 3.6.3 Rasp'
                jdk 'Java11 (openjdk) ARM'
            }

    options { buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '3')) }

    stages {

        stage("MVN Clean"){
            steps{
                withMaven{
                    sh "mvn clean"
                }
            }
        }
        stage("Testing") {
            steps {
                sh 'mvn test'
            }
        }

        stage("Compiling&Packaging") {
            steps {
                sh 'mvn package -Dmaven.test.skip=true'
            }
        }

    }
}