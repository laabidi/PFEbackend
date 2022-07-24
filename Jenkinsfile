pipeline{
	environment{
		registry = 'laabidimohamed/laabidimohamed'
		registryCredential= 'dockerHub'
		dockerImage = ''
		
		
	}
	
	agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'main',
					url : 'https://github.com/laabidi/PFEbackend.git';
			}
		}

		stage ("Verification du  version Maven..."){
			steps{
				bat """mvn -version"""
			}
		}

		stage ("Clean..."){
			steps{
				bat """mvn clean"""
			}
			
		}

		stage ("Creation du livrable..."){
			steps{
				bat """mvn package -Dmaven.test.skip=true"""
			}
		}

		
 	 stage('Building our image') {
    steps {
       script {
          dockerImage= docker.build registry + ":$BUILD_NUMBER" 
       }
    }
  }

 // stage('Deploy our image') {
   // steps {
      // script {
      //   docker.withRegistry( '', registryCredential) {
      //      dockerImage.push() 
      //   }
     //  } 
   // }
  //}

  stage('Cleaning up') {
    steps { 
      bat "docker rmi $registry:$BUILD_NUMBER" 
    }
  }

  stage('Email Notification') {
	steps { 
	    mail bcc: '', body: '''Hello Mohamed, this is a Jenkins Pipeline alert for launching Cycle

            Thank you''', cc: '', from: '', replyTo: '', subject: 'Jenking Job Launched', to: 'mohamed.laabidi@esprit.tn'
    }
}
}
 }
