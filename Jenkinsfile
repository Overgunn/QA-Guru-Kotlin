pipeline {
    agent any
    stages {
        stage('Checkout') { steps { checkout scm } }
        stage('Build') {
            steps {
                sh './gradlew clean build' // Сборка Kotlin проекта
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test' // Запуск тестов
            }
        }
    }
}