#!/bin/bash
set -e

newVersion=${1}
property=ivy-version

mvn --batch-mode versions:set-property versions:commit -Dproperty=${property} -DnewVersion=${newVersion}
