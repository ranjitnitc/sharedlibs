#!/usr/bin/env groovy

def call(body) {
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()
  
  def name =config.get('name', false)
  echo "Hey ${name}, How are you??"
}
