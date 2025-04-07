#!/bin/bash

rm -rf build
mvn clean package

export UID=$(id -u)

browseDoc(){
  # only start firefox if it is available.
  if [ -x "$(command -v firefox)" ]; then
    while [ -z "${started}" ]
    do
      sleep 1
      echo "[browser] waiting for HTTP service"
      started=$(docker compose logs --since 1m | grep "HTML pages")
    done
    firefox http://localhost:8000 &
  fi
}

browseDoc & 

docker compose up
