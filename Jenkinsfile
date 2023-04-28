pipeline {
    agent any
    tools{
        maven 'MAVEN_HOME'
    }
    stages{
        stage("Build Maven"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '9a414cee-8fe5-44e9-8b48-8e3ac56a7eea', url: 'git@github.com:theSuraj37/pactice_jenkins.git']])
                bat 'mvn clean install'
            }
        }
        stage("Build Docker Image"){
            steps{
                script{
                    bat 'docker build -t surajkpvd/demo-project .'
                }
            }
        }
        stage("Push Image to Hub"){
            steps{
                script{
                    withCredentials([string(credentialsId: 'surajdockerhub', variable: 'dockerhubpwd')]) {
                        bat 'docker login -u surajkpvd -p %dockerhubpwd%'
                    }
                    bat 'docker push surajkpvd/demo-project'
                }
            }
        }
        stage("Deploy App"){
            steps{
                script{
                    kubernetesDeploy configs: 'deploymentservice.yaml', kubeconfigId: 'k8sconfigpwd'
                }
            }
        }
    }
}
