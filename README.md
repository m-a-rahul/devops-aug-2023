## Check your RPS Cloud Lab access
<pre>
- Kindly check if you are able to access the RPS Cloud machine
- You can start your DevOps pre-test from the RPS cloud machine
- While registering for pre-test, you may use your personal-email id and avoid using BOFA
- At any point, in case you have any lab access issue, please feel free to reach out to RPS team connected via WebEx chat 
- You may also call Hari from RPS for any lab access issues @ +91 984-618-6667
</pre>

## Pre-test URL
Kindly start your pre-test at the below link
```
https://app.mymapit.in/code4/tiny/i6NpLu
```
Once you are done with the pre-test, please leave a message via WebEx chat.  In case your chat doesn't work, you can confirm me orally and I'll make a note that you have completed the test. Once everyone completes the test, we can start the training.

## Maven
- it is an opensource build tool, predominantly used by Java project but it is language agnostic build tool
- developed and maitained by Apache foundation
- Ant build tool is also developed and maitained by Apache Foundation as an open-source project
- Maven solves all the Ant build tool issues
  - Maven has built-in dependency management capabilities unlike Ant
  - Maven hs conventions for naming the project, project directory structure
  - Maven co-ordinates ( similar to GPS co-ordinates )
    - groupId ( - reverse doman of any organization. Ex: tektutor.org is the domain, groupId will be org.tektutor )
    - artifactId - it is the name of the artifactId 
    - version ( 1.2.3 )
    - the combination of Maven co-ordinates should/will always lead to unique application artifacts (jar,war,ear,zip, etc.,)
    - pom.xml  (Project Object Model )
      - will have the project name defined in terms of Maven co-ordinates
      - will have maintain the project dependencies and their maven-cordinates
     
    - Maven repositories
      - Local repository ( is a folder in your user home directory called .m2 )
      - Private repository ( optional - you can setup with JFrog Artifactory or Sonatype Nexus )
      - Central repository ( search.maven.org website which has all opensource project dependency jars etc.,)

# Maven commands

## Finding your maven version
```
mvn --version
```

Expected output
<pre>
jegan@tektutor.org:~$ <b>mvn --version</b>
Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: 18.0.2-ea, vendor: Private Build, runtime: /usr/lib/jvm/java-18-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.19.0-50-generic", arch: "amd64", family: "unix"

</pre>
