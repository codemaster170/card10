pipeline {
    agent any  // This allows Jenkins to run on any available agent

    environment {
        // Define environment variables here if needed
        MAVEN_HOME = '/usr/local/apache-maven'  // Set Maven installation path (adjust as needed)
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from Git repository
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                script {
                    // Run the Maven build command
                    echo 'Building the project...'
                    sh "'${MAVEN_HOME}/bin/mvn' clean install"  // Adjust Maven command as needed
                }
            }
        }
        
        stage('Test') {
            steps {
                script {
                    // Run tests after building
                    echo 'Running tests...'
                    sh "'${MAVEN_HOME}/bin/mvn' test"  // Adjust Maven test command as needed
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Add deployment steps (e.g., copy files, trigger remote deployment, etc.)
                    echo 'Deploying application...'
                    // Example: sh 'deploy-scripts/deploy.sh'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and deployment succeeded!'
        }
        failure {
            echo 'Build or deployment failed!'
        }
        always {
            echo 'Pipeline execution completed!'
        }
    }
}
