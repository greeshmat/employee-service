#!/bin/bash

JAVA_HOME=$JAVA_HOME
APP_HOME=..


echo Running employee-service
export CLASSPATH=$CLASSPATH:.:$APP_HOME/build/lib/employee-service.jar

$JAVA_HOME/bin/java -cp $CLASSPATH com.gr.emp.main.EmployeeClient
 
