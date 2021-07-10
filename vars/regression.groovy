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
    stage("Build") {
        sh "cd /tmp; ls -lrt ; date"
        checkout scm
       }  
    stage("approve deploy"){
      node('paused'){
        try{
          abortPreviousBuilds(stage: "approve deploy" ) 
          timeout(time: 20 , unit: 'MINUTES' )
           input message:'approve this build'
           milestone()   
        } catch (err) {
          println err
        }
      }
    }
  }
}
