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
                script {
                    if (isUnix()) {
                        sh 'mvn clean package'
                    } else {
                        echo 'bat..'
                        bat 'mvn clean package'
                    }
                }
                echo 'Build end..'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy start..'
                script {
                    if (isUnix()) {
                        sh 'nohup java -jar target/helloworld-0.0.1-SNAPSHOT.jar > app.log 2>&1 &'
                        // 检查端口是否启动
                        sh '''
                    while ! nc -z localhost 8080; do
                        sleep 1
                    done
                '''
                    } else {
                        echo 'bat..'
                        bat 'start /B java -jar target/helloworld-0.0.1-SNAPSHOT.jar > app.log 2>&1'
                        // Windows 下可以使用 PowerShell 检查端口
                        bat '''
                    powershell -Command "while (!(Test-NetConnection -ComputerName localhost -Port 8080).TcpTestSucceeded) { Start-Sleep -Seconds 1 }"
                '''
                    }
                }
                echo 'Deploy end..'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}