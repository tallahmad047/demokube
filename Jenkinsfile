pipeline{
   agent any
   tools{
       maven '3.8.6'
   }
   stages{
      stage("source"){
          steps{
             git branch: 'dev' ,url:'https://github.com/tallahmad047/inventory.git'
        }
      }
       stage ('Build') {
                  steps{

                      bat 'mvn package -DskipTests'
                  }
              }



       stage ('Approve Deployment') {
                  input {
                      message 'Do you want to proceed for deployment?'
                  }
                  steps{
                      bat 'echo "Deploying into Server dev."'
                  }
        }
         stage('Builddocker') {
                steps {
                              // Build the Docker image
                             bat 'docker build -t tall/demokube  .'
                   }
                      }
                  stage('dockertag') {
                           steps {
                                                     // Build the Docker image
                             bat 'docker tag tallahmad/nguith2022  tall/demokube:groupe1'
                                    }
                                  }


                      stage('Push') {

                            steps {
                              withDockerRegistry([credentialsId: "groupe3aws" ,url:"" ]){
                              bat 'docker push tall/demokube:groupe1'
                              }
                            }
                          }
                      stage ('deployment kub'){
                        steps{
                          script{
                               withDockerRegistry([credentialsId: "groupe3aws" ,url:"" ]) {
                                                     // Récupérer l'image depuis Docker Hub
                                                     dockerImage = docker.image('tall/demokube:groupe1')
                                                     dockerImage.pull()

                                                     // Déployer l'image sur Kubernetes
                                                    //bat "kubectl apply -f deployment.yml"
                                                 }
                          }
                        }

                      }

          } // stages

          post {
              aborted {
                  echo "Sending message to Agent"
              } // aborted

              failure {
                  echo "Sending message to Agent"
              } // failure

              success {
                  echo "Sending message to Agent"
              } // success
          } // post
   }
