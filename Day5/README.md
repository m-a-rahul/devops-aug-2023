## Starting SonarQube Server as a Docker container
```
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
docker ps
```

Expected output
<pre>
jegan@tektutor.org:~$ <b>docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest</b>
Unable to find image 'sonarqube:latest' locally
latest: Pulling from library/sonarqube
9d19ee268e0d: Pull complete 
f2b566cb887b: Pull complete 
2eb275343c46: Pull complete 
d6398d1ffae6: Pull complete 
f24741b8b590: Pull complete 
e8c0ed258a35: Pull complete 
Digest: sha256:b6c6380a8f507913caeea2da1758fdad88a4bf8c81f7d1e2be51b035a4f87722
Status: Downloaded newer image for sonarqube:latest
9ed3115075ca7a00bc3772a758d3658e33363c3c7846368efbe731766d1a9486
  
jegan@tektutor.org:~$ <b>docker ps</b>
CONTAINER ID   IMAGE              COMMAND                  CREATED              STATUS              PORTS                                       NAMES
9ed3115075ca   sonarqube:latest   "/opt/sonarqube/dock…"   About a minute ago   Up About a minute   0.0.0.0:9000->9000/tcp, :::9000->9000/tcp   sonarqube
</pre>
