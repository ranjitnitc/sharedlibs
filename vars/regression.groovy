#!/usr/bin/env groovy

def call(body) {
  def name =config.get('name', false)
  echo "Hey ${name}, How are you??"
}
