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
                script {
                    for (int i = 0; i < 5; i++) {
                        def response = sh(script: "curl -s --head --request GET localhost:8000/actuator/health | grep HTTP | awk '{ print $2 }'", returnStdout: true).trim()
                        if (response == '200') {
                            println('Server is up and running');
                            break;
                        } else {
                            if (i < 4) {
                                sleep 5; // wait for 5 seconds before the next attempt
                            } else {
                                error('Server is not running');
                            }
                        }
                    }
                }
            }
        }
    }
}