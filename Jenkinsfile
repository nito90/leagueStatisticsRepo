pipeline {
  agent any
  stages {
    stage('Get the code') {
      steps {
        git(url: 'https://github.com/nito90/leagueStatisticsRepo.git', branch: 'master')
      }
    }
    stage('maven ') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }
  }
}