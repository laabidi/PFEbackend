pipeline{
	
	agent any 
	stages{
		stage ('Checkout GIT'){
			steps{
				echo 'Pulling...';
					git branch: 'main',
					url : 'https://github.com/laabidi/Smart-RH.git';
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

		stage ("Lancement des Tests Unitaires..."){
			steps{
				bat """mvn test"""
			}
		}

		stage ("Analyse avec Sonar..."){
			steps{
				bat """mvn sonar:sonar"""
			}
		}

		stage ("Deploiement dans Nexux..."){
			steps{
				bat """mvn clean package -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=smartup.microservices -DartifactId=portailRH -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/portailRH-1.0.jar"""
			}
		}

	post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'mohamed.laabidi@esprit.tn'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'mohamed.laabidi@esprit.tn'
		}
	}
}