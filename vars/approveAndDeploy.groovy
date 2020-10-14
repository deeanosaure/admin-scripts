#!/usr/bin/env groovy

def call(String dockerImageToDeploy) {
  stage('Waiting Approval') {
    timeout(time:1, unit:'DAYS') {
      input message: "Is it ok to deploy ${dockerImageToDeploy}?",
        ok: 'Deploy'
      }
    }
  stage('Deploy') {
    build job: 'demoapp-staging-deployer',
      parameters: [string(name: 'DOCKER_IMAGE',
      value: "${dockerImageToDeploy}")]
      }
    }
