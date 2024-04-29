pipeline {
	agent any

	stages {
        stage('Build') {
            steps {
                sh './mvnw -B -DskipTests clean package'
            }
        }
		stage('Test'){
			steps{
				sh './mvnw test'
			}
		}
		stage('Deploy') {
			steps {
			     sh './mvnw jar:jar deploy:deploy'
			}
		}
	}
}