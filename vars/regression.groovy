#!/usr/bin/env groovy

def call(body) {
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()
  
  def name = config.get('name', false)
  def state = config.get('state', false)
  echo "Hey ${name}, How are you??"
  echo "i live in ${state}"
  node('master'){
    stage("approve deploy"){
                   
          input "Deploy to prod?"
          sh " date" 
         } 
    
    stage("Build") {
        sh "cd /tmp; ls -lrt ; date"
        checkout scm
       }  
    
      
    }
  
}
