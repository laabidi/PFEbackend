pipeline{
	environment{
		registry = 'laabidimohamed/laabidi'
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

		

		stage("Test,Build"){
   			 steps{
     				 bat """mvn clean package"""
   			 }
   		  }


 		 stage("Sonar"){
  			  steps{
    				  bat """mvn sonar:sonar"""
   			 }
   		  }

		stage ("Deploiement dans Nexus..."){
			steps{
				bat """mvn clean package -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=smartup.microservices -DartifactId=portailRH -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/portailRH-1.0.jar"""
			}
		}
stage('Building our image') {
    steps {
       script {
          dockerImage= docker.build registry + ":$BUILD_NUMBER" 
       }
    }
  }

  stage('Deploy our image') {
    steps {
       script {
         docker.withRegistry( '', registryCredential) {
            dockerImage.push() 
         }
       } 
    }
  }

  stage('Cleaning up') {
    steps { 
      bat "docker rmi $registry:$BUILD_NUMBER" 
    }
  }
}

}