def gitUrl='https://github.com/drmaxgit/drmax-dwh.git'
def githubCredentialsId='drmaxGithub'
def nexusCredentialsId='drmaxNexus'

 pipeline {
     agent {
         label 'jenkins-slave-base'
     }
     stages {
         stage('Upload archives') {
             steps {
                  withCredentials([usernamePassword(credentialsId: nexusCredentialsId, usernameVariable: 'username', passwordVariable: 'password')]){
                    sh './gradlew uploadArchives -PdrmaxNexusUser=${username} -PdrmaxNexusPassword=${password}'
                 }
             }
         }
     }
 }