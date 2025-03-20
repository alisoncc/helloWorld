#!/usr/bin/env groovy
pipeline {
    agent any
    env.UNIX = isUnix()

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
                if (Boolean.valueOf(env.UNIX)) {
                    sh 'mvn clean package'
                }
                else {
                    echo 'bat..'
                    bat 'mvn clean package'
                }

                echo 'Build end..'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy start..'
                if (Boolean.valueOf(env.UNIX)) {
                    sh 'java -jar target/helloworld-0.0.1-SNAPSHOT.jar &'
                }
                else {
                    echo 'bat..'
                    bat 'java -jar target/helloworld-0.0.1-SNAPSHOT.jar '
                }
                echo 'Deploy end..'
            }
        }
    }
}