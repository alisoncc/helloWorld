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
                        // 将日志输出到文件，并在后台运行
                        sh 'nohup java -jar target/helloworld-0.0.1-SNAPSHOT.jar > app.log 2>&1 &'
                        // 等待 Spring Boot 启动完成（例如等待 10 秒）
                        sh 'sleep 10'
                    } else {
                        echo 'bat..'
                        // Windows 下直接运行，日志输出到文件
                        bat 'start /B java -jar target/helloworld-0.0.1-SNAPSHOT.jar > app.log 2>&1'
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