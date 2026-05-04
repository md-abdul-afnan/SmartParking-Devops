pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                bat 'docker build -t smart-parking-slot-booking-system:latest .'
            }
        }
        stage('Docker Run') {
            steps {
                bat 'docker rm -f smart-parking-app || exit 0'
                bat 'docker run -d --name smart-parking-app smart-parking-slot-booking-system:latest'
            }
        }
    }
}
