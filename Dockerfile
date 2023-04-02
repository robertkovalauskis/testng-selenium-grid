FROM openjdk:8u191-jre-alpine3.8

# Install curl and jq utilities
# It's needed to execute healthcheck.sh
# and verify that the hub is ready and has registered nodes
RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar 		selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs					libs

# in case of any other dependency like .csv/.json/xls
# please ADD them as well

# ADD suite files
ADD book-flight-module.xml 			book-flight-module.xml
ADD search-module.xml 				search-module.xml

# ADD health check script
ADD healthcheck.sh                  healthcheck.sh
# Convert the file from Windows to Unix format
RUN dos2unix healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE (suite)

# Execute the healthcheck script
# It includes a command to trigger the tests
# after the hub is registered and nodes are registered
ENTRYPOINT sh healthcheck.sh