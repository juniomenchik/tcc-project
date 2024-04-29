pipeline {
	agent any

	stages {
        stage('Build') {
            steps {
                sh 'chmod +x ./mvnw -B -DskipTests clean package'
            }
        }
		stage('Test'){
			steps{
				sh 'chmod +x ./mvnw test'
			}
		}
		stage('Deploy') {
			steps {
			     sh 'chmod +x ./mvnw jar:jar deploy:deploy'
			}
		}
	}
}