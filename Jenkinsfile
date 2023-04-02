pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh for Mac
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t=kovalauskis/selenium-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push kovalauskis/selenium-docker:latest"
			    }                           
            }
        }
    }
}