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


        stage('Deploy') {
            steps {
                echo 'Deploy start..'
                script {
                    if (isUnix()) {
                        sh 'java -jar target/helloworld-0.0.1-SNAPSHOT.jar &'
                    } else {
                        echo 'bat..'
                        bat 'java -jar target/helloworld-0.0.1-SNAPSHOT.jar'
                    }
                }
                echo 'Deploy end..'
            }
        }
    }
}