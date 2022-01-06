@Library('ceiba-jenkins-library')
pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK11_Centos' //Verisión preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
        stage('Checkout') {
            steps{
            echo "------------>Checkout<------------"
            checkout([
                $class: 'GitSCM',
                branches: [[name: '*/master']],
                doGenerateSubmoduleConfigurations: false,
                extensions: [],
                gitTool: 'Default',
                submoduleCfg: [],
                userRemoteConfigs: [[
                credentialsId: 'GitHub_luisjosetorres12',
                url:'https://github.com/luisjosetorres12/parking-java'
                ]]
            ])

            }
        }

    stage('Compile & Unit Tests') {
      steps{
        echo "------------>compile & Unit Tests<------------"
        sh 'chmod +x gradlew'
        sh './gradlew --b ./microservicio-mantenimiento/build.gradle test'

      }
    }

        stage('Static Code Analysis') {
            steps{
            echo '------------>Análisis de código estático<------------'
            withSonarQubeEnv('Sonar') {
                sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
            }
            }
        }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
         sh './gradlew --b ./microservicio-mantenimiento/build.gradle clean'
         sh './gradlew --b ./microservicio-mantenimiento/build.gradle build'
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'build/test-results/test/*.xml' //RUTA RELATIVA DE LOS ARCHIVOS .XML
    }
    failure {
      mail (to: 'jose.torres@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
