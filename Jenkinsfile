pipeline {
    agent any
    environment{
        DOCKERHUB_CREDENTIALS = credentials('kayrxa-docker')
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        jdk 'jdk17'
        maven "maven3"
    }

    stages {
        
        stage('Git Checkout'){
            steps{
                 git branch: 'main', credentialsId: 'fd074f97-7b04-4513-8996-bf3ffcb7edd8', url: 'https://github.com/KayrXa/Capstone-Backend-Java.git' 
            }
        }
        
        stage('COMPILE'){
            steps{
                 sh "mvn clean compile -DskipTests=true" 
            }
        }
        
   
        
        stage('Build'){
            steps{
             
                    sh "docker build -t kayrxa/movieplan:$BUILD_NUMBER ."
            }
        }
        
        stage('login to dockerhub') {
            steps{
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        
        stage('Push'){
            steps{
                   sh "docker push kayrxa/movieplan:$BUILD_NUMBER"
            }
        }

        stage('Deploy') {
            steps{
                script{
                     sh "docker run -d --name movieplan -p 8100:8100 kayrxa/movieplan:$BUILD_NUMBER"
                }
            }
                
        }
        
    }
}

