def call(){
    
   if(util.validateStage('Downloadnexus')){
      stage('Downloadnexus') {
       env.STAGE = 'Downloadnexus'
       fliget env.STAGE
       sh 'curl http://35.199.77.109:8081/repository/realese-v0.1.0/com/devopusach2020/DevOpsUsach2020/1.0.0/DevOpsUsach2020-1.0.0.jar --output DevOpsUsach2020-1.0.0.jar'
      }
   }

    if(util.validateStage('runDownloadjar')){
     stage('runDownloadjar') {
    env.STAGE = 'runDownloadjar'
    fliget env.STAGE
    echo 'Esperando a que termine la descarga'
	sleep(time: 10, unit: "SECONDS")
    sh 'java -jar DevOpsUsach2020-1.0.0.jar'
   }
   }
   
    if(util.validateStage('rest'))
    {
        stage('rest') {
            env.STAGE = 'rest'
                fliget env.STAGE
            bat 'curl -X GET "http://localhost:8081/rest/mscovid/test?msg=testing"'
        }
    }
  

}

return this;