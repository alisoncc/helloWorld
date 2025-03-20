#!/usr/bin/env groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout start..'
                script {
                    git branch: 'main',
                        url: 'https://github.com/alisoncc/helloWorld.git'
                }
                echo 'Checkout end..'
            }
        }

        stage('Build') {
            steps {
                echo 'Build start..'
                echo 'Build..'
                sh 'mvn clean package'
                echo 'Build end..'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy start..'
                echo 'Deploy..'
                sh 'java -jar target/helloworld-0.0.1-SNAPSHOT.jar &'
                echo 'Deploy end..'
            }
        }
    }
}