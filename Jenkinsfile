pipeline {
    
    agent any
    
    tools{
        nodejs 'node'
    }

    stages {
        stage('clone repository') {
            steps {
                git 'https://github.com/kadimasum/gallery.git'
            }
        }
        
        stage('install project dependencies') {
            steps {
               sh 'npm install'
            }
        }
        
        stage('test') {
            steps {
               sh 'npm test'
            }
        }
        
        stage('deploy to heroku') {
            steps {
               withCredentials([usernameColonPassword(credentialsId: 'heroku', variable: 'HEROKU_CREDENTIALS' )]){
                  sh 'git push https://${HEROKU_CREDENTIALS}@git.heroku.com/radiant-bayou-11364.git master'
                }
            }
        }
        
        
        stage('Send slack message'){
            steps {
                slackSend channel: '#devops-notification', 
                          message: 'Gallery app,  Build id: ${env.BUILD_NUMBER}, deployed successfully at: ${env.BUILD_URL}.'
            }
        }

    }
}
