pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/alisoncc/helloWorld.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy') {
            steps {
                sh 'java -jar target/helloworld-0.0.1-SNAPSHOT.jar &'
            }
        }
    }
}