#!/usr/bin/env groovy

def call(){
  def=config.get(name, false)
  echo "Hey ${name}, How are you??"
}
