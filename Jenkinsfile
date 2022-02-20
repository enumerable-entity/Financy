//file:noinspection GroovyAssignabilityCheck
        pipeline {

            agent { label 'RaspberryPi_MasterNode' }
            tools {
                maven 'Maven 3.6.3 Rasp'
                jdk 'Java11 (openjdk) ARM'
            }

            options { buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '1')) }


            stages {

                stage("MVN Clean") {
                    steps {
                        withMaven {
                            sh "mvn clean"
                        }
                    }
                }
                stage("Compile source code") {
                    steps {
                        withMaven {
                            sh "mvn compile -P prod"
                        }
                    }
                }
                stage('Unit Tests') {
                    steps {
                        withMaven {
                            sh 'mvn resources:testResources compiler:testCompile surefire:test'
                        }
                    }
                }

                stage("Packaging SpringBoot artifact") {
                    steps {
                        withMaven {
                            sh 'mvn jar:jar spring-boot:repackage -P prod'
                        }
                    }
                }
                stage("Delivering artifact to AWS") {
                    steps {
                        echo 'Delivering artifact to remote server...'
                        sshagent(['jenkinsAWSssh']) {
                            sh 'scp ./target/*.jar ubuntu@enumerable-entity.link:/home/ubuntu/app/financy'
                        }
                    }
                }
                stage("SpringBoot runner restarting") {
                    steps {
                        script {
                            echo 'Deploying...'
                            sshagent(credentials: ['jenkinsAWSssh']) {
                                sh """ ssh ubuntu@enumerable-entity.link << EOF
                                          docker restart SpringAppFinancy
                                          exit
                                          EOF
                            """
                            }
                        }
                    }
                }
            }
        }
