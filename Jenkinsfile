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
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deploy Development') {
            steps {
                sh 'docker container rm spring-boot'
                sh 'mvn clean package -DskipTests'
                sh 'docker build -t spring-boot:0.0.1 .'
                sh 'docker run -p 8080:8080 spring-boot:0.0.1'
            }
        }
    }
}