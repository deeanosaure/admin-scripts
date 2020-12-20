#!/usr/bin/env groovy

def call(String dockerImageToDeploy) {
  stage('Deploy') {
    build job: 'demoapp-staging-deployer',
      parameters: [string(name: 'DOCKER_IMAGE',
      value: "${dockerImageToDeploy}")]
      }
    }
