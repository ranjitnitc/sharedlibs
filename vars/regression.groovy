#!/usr/bin/env groovy

def call(){
  def name =config.get('name', false)
  echo "Hey ${name}, How are you??"
}
