pipeline{
    agent any
        tools{
        maven 'maven-3.8.6'
        }
        stages{
            stage('Source'){
                steps{
                    git branch: 'main', url: 'https://github.com/Mamekhady/groupe1.git'
                }
            }
            stage('Build '){
                steps{
                    sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
                }
            }
            stage('SonarQube Analyst '){
                sh 'mvn sonar:sonar'
            }
            stage('Approve Deployment'){
                 input{
                        message 'Do you wanted to proceed for Deployement'
                 }
                 steps{
                    sh 'echo "Deploying into Server"'
                 }
            }
        }
         post{
              aborted{
                   echo 'Sending message to to Agent'
              }
              failure{
                   echo 'Sending message to to Agent'
              }
               success{
                  echo 'Sending message to to Agent'
               }
         }
    }