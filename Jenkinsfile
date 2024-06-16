pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Integration Tests') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Jacoco Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }
        stage('Deploy Development') {
            steps {
                sh 'docker stop spring-boot'
                sh 'docker rm spring-boot'
                sh 'mvn clean package -DskipTests'
                sh 'docker build -t spring-boot:0.0.1 .'
                sh 'docker run -d --name spring-boot -p 8000:8000 spring-boot:0.0.1'
            }
        }
        stage('Check Availability') {
            steps {
                sleep 20
                waitUntil {
                    script {
                        def response = sh(script: "curl -s --head  --request GET  localhost:8000/actuator/health | grep '200'", returnStdout: true).trim()
                        return response == '200'
                    }
                }
            }
        }
    }
}