
pipeline {
    triggers {
  pollSCM('* * * * *')
    }
   agent any
    tools {
  maven 'M2_HOME'
}
// environment {
//     registry = '076892551558.dkr.ecr.us-east-1.amazonaws.com/jenkins'
//     registryCredential = 'aws_ecr_id'
//     dockerimage = ''
// }

    stages {

        stage("build & SonarQube analysis") {
//             agent {
//         docker { image 'maven:3.8.6-openjdk-11-slim' }
//    }
            
            
            steps {
                dir('./fastfood_BackEnd/'){
                    withSonarQubeEnv('SonarServer') {
                        sh 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=Hermann90_fastfoodtest'
                        }
                }
              
            }
          }
        stage('Check Quality Gate') {
            steps {
                echo 'Checking quality gate...'
                dir('./fastfood_BackEnd/'){ 
                    script {
                    timeout(time: 20, unit: 'MINUTES') {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline stopped because of quality gate status: ${qg.status}"
                        }
                    }
                }
                }
                
            }
        }
        
         
        // stage('maven package') {
        //     steps {
        //         sh 'mvn clean'
        //         sh 'mvn install -DskipTests'
        //         sh 'mvn package -DskipTests'
        //     }
        // }
        // stage('Build Image') {
            
        //     steps {
        //         script{
        //           def mavenPom = readMavenPom file: 'pom.xml'
        //             dockerImage = docker.build registry + ":${mavenPom.version}"
        //         } 
        //     }
        // }
        // stage('Deploy image') {
           
            
        //     steps{
        //         script{ 
        //             docker.withRegistry("https://"+registry,"ecr:us-east-1:"+registryCredential) {
        //                 dockerImage.push()
        //             }
        //         }
        //     }
        // }    
         
         
    }
}