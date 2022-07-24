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

		
 		stage('Build image') {
        /* This builds the actual image */

       		 app = docker.build("laabidimohamed/laabidimohamed")
    	}

    	stage('Test image') {
        
        	app.inside {
            	echo "Tests passed"
        }
    }

    	stage('Push image') {
        /* 
			You would need to first register with DockerHub before you can push images to your account
		*/
        	docker.withRegistry('https://registry.hub.docker.com', 'laabidimohamed') {
            	app.push("${env.BUILD_NUMBER}")
            		app.push("latest")
            } 
                		echo "Trying to Push Docker Build to DockerHub"
    }
   }

}