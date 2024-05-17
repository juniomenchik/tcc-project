pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy Development') {
            steps {
                sh 'mvn clean package -DskipTests'
                sh 'docker build -t spring-boot:0.0.1 .'
                sh 'docker run -p 8000:8000 spring-boot:0.0.1'
            }
        }
    }
}