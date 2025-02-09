pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // If you're not using SCM, comment out or remove this line
                // checkout scm
                script {
                    sh 'echo Building project...'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh 'echo Running tests...'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    sh 'echo Deploying project...'
                }
            }
        }
    }
}

