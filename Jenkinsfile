pipeline{
    agent any
    stages{
        stage("Clone Repo"){
            steps{
                git branch: 'master', url: 'https://github.com/lenox-isindu/java-todo'
            }
        }
        stage("Build Repo"){
            steps{
                sh "./gradlew clean build "
            }
        }
        
        stage("Test Code"){
            steps{
                sh "./gradlew test"
            }
        }
        
    }
}