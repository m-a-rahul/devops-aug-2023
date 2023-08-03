## My medium blogs
<pre>
https://medium.com/tektutor/ci-cd-with-maven-github-docker-jenkins-aca28c252fec  
</pre>

## What is DevOps?
- Developers
  - TDD (Test Driven Development) 
  - automate their testing activity using JUnit/CppUnit/TestNg/MSTest,PyUnit Test Frameworks
  - Provisioning Tool
    - to automate Dev Infrastructure (OS Installation, Creating VM on OnPrem/Cloud)
    - to automate Kubernetes/OpenShift onPrem/Cloud
 
  - Configuration management tools
    - Using Ansible,Puppet, Chef, Salt to automate dev environment setup
- QA
  - BDD (Behavior Driven Development) to automate test cases
  - Cucumber,JBehave, Specflow, Jasmin, Karma, etc.,
  - BDD + Selenium + Webdriver
  - Provisioning Tool
    - to automate QA Infrastructure (OS Installation, Creating VM on OnPrem/Cloud)
    - to automate Kubernetes/OpenShift onPrem/Cloud

  - Configuration Management tools
    - Using these tools they can automate the QA setup
- System Administration ( Infra Engineer, IT Engineer, Operations Team, DBA, etc.,)
  - Provisioning tools
    - to automate Prod, Staging environment
    - to automate Kubernetes/OpenShift onPrem/Cloud
  - Configuration Management tools
    - to setup/configure staging, prod environment

## What is Continuous Integration (CI)?
- Dev/QA/System Administration team continuously integrate their code change into version control
- helps in detecting code defects early during the development cycle itself
- the more early the defects are detected it is more easy to fix and less expensive

## What is Continuous Deployment (CD)?
- the development tested binaries will be automatically deployed on the QA environment
  for further automated testing added by QA team

## What is Continuous Delivery (CD)?
- the QA test binaries will be automatically delivered to customer's environment or
- can be made live

## Jenkins Overview
- CI/CD Build Automation Server
- is an opensource build server developed Kohsuke Kawaguchi 
- initially this product was called Hudson
- after Oracle acquired Sun Microsystem's the founding members of Hudson they make a fork/branch
  of Hudson with the name jenkins
- the founding members came out of Oracle and continued to develop Jenkins as an opensource
  build automation server
- Oracle still continues to develop the Hudson project
- enterprise variant of Jenkins is called Cloudbees
  
## Jenkins Alternatives
- TeamCity
- Bamboo
- Microsoft Team Foundation Server (TFS)
- etc

## Starting Jenkins from Command line
```
cd ~/Downloads
java -jar ./jenkins.war
```

In case you get the below error
<pre>
Running with Java 18 from /usr/lib/jvm/java-18-openjdk-amd64, which is not yet fully supported.
Run the command again with the --enable-future-java flag to enable preview support for future Java versions.
Supported Java versions are: [11, 17]
See https://jenkins.io/redirect/java-support/ for more information.
</pre>

Then try the below command to launch jenkins
```
cd ~/Downloads
java -jar ./jenkins.war --enable-future-java
```

Expected output
<pre>
jegan@tektutor.org:~/Downloads$ <b>java -jar ./jenkins.war</b>
Running with Java 18 from /usr/lib/jvm/java-18-openjdk-amd64, which is not yet fully supported.
Run the command again with the --enable-future-java flag to enable preview support for future Java versions.
Supported Java versions are: [11, 17]
See https://jenkins.io/redirect/java-support/ for more information.
  
jegan@tektutor.org:~/Downloads$ <b>java -jar ./jenkins.war --enable-future-java</b>
Running with Java 18 from /usr/lib/jvm/java-18-openjdk-amd64, which is not fully supported. Continuing because --enable-future-java is set. Supported Java versions are: [11, 17]. See https://jenkins.io/redirect/java-support/ for more information.
Running from: /home/jegan/Downloads/jenkins.war
webroot: /home/jegan/.jenkins/war
2023-08-03 06:24:08.658+0000 [id=1]	INFO	winstone.Logger#logInternal: Beginning extraction from war file
2023-08-03 06:24:08.696+0000 [id=1]	WARNING	o.e.j.s.handler.ContextHandler#setContextPath: Empty contextPath
2023-08-03 06:24:08.751+0000 [id=1]	INFO	org.eclipse.jetty.server.Server#doStart: jetty-10.0.13; built: 2022-12-07T20:13:20.134Z; git: 1c2636ea05c0ca8de1ffd6ca7f3a98ac084c766d; jvm 18.0.2-ea+9-Ubuntu-222.04
2023-08-03 06:24:09.022+0000 [id=1]	INFO	o.e.j.w.StandardDescriptorProcessor#visitServlet: NO JSP Support for /, did not find org.eclipse.jetty.jsp.JettyJspServlet
2023-08-03 06:24:09.073+0000 [id=1]	INFO	o.e.j.s.s.DefaultSessionIdManager#doStart: Session workerName=node0
2023-08-03 06:24:09.475+0000 [id=1]	INFO	hudson.WebAppMain#contextInitialized: Jenkins home directory: /home/jegan/.jenkins found at: $user.home/.jenkins
2023-08-03 06:24:09.638+0000 [id=1]	INFO	o.e.j.s.handler.ContextHandler#doStart: Started w.@bc57b40{Jenkins v2.401.1,/,file:///home/jegan/.jenkins/war/,AVAILABLE}{/home/jegan/.jenkins/war}
2023-08-03 06:24:09.651+0000 [id=1]	INFO	o.e.j.server.AbstractConnector#doStart: Started ServerConnector@543e710e{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
2023-08-03 06:24:09.662+0000 [id=1]	INFO	org.eclipse.jetty.server.Server#doStart: Started Server@120d6fe6{STARTING}[10.0.13,sto=0] @1409ms
2023-08-03 06:24:09.663+0000 [id=46]	INFO	winstone.Logger#logInternal: Winstone Servlet Engine running: controlPort=disabled
2023-08-03 06:24:09.867+0000 [id=52]	INFO	jenkins.InitReactorRunner$1#onAttained: Started initialization
2023-08-03 06:24:10.218+0000 [id=67]	INFO	jenkins.InitReactorRunner$1#onAttained: Listed all plugins
2023-08-03 06:24:13.219+0000 [id=123]	INFO	jenkins.InitReactorRunner$1#onAttained: Prepared all plugins
2023-08-03 06:24:13.234+0000 [id=104]	INFO	jenkins.InitReactorRunner$1#onAttained: Started all plugins
2023-08-03 06:24:13.240+0000 [id=119]	INFO	jenkins.InitReactorRunner$1#onAttained: Augmented all extensions
2023-08-03 06:24:13.739+0000 [id=104]	INFO	h.p.b.g.GlobalTimeOutConfiguration#load: global timeout not set
2023-08-03 06:24:13.942+0000 [id=135]	INFO	jenkins.InitReactorRunner$1#onAttained: System config loaded
2023-08-03 06:24:13.944+0000 [id=140]	INFO	jenkins.InitReactorRunner$1#onAttained: System config adapted
2023-08-03 06:24:14.282+0000 [id=143]	INFO	jenkins.InitReactorRunner$1#onAttained: Loaded all jobs
2023-08-03 06:24:14.297+0000 [id=93]	INFO	jenkins.InitReactorRunner$1#onAttained: Configuration for all jobs updated
2023-08-03 06:24:14.322+0000 [id=159]	INFO	hudson.util.Retrier#start: Attempt #1 to do the action check updates server
2023-08-03 06:24:14.346+0000 [id=100]	INFO	jenkins.InitReactorRunner$1#onAttained: Completed initialization
2023-08-03 06:24:14.398+0000 [id=37]	WARNING	o.j.p.w.flow.FlowExecutionList$1#computeNext: Failed to load Owner[DBChangePipeline/3:null]. Unregistering
2023-08-03 06:24:14.400+0000 [id=37]	INFO	hudson.lifecycle.Lifecycle#onReady: <b>Jenkins is fully up and running</b>
2023-08-03 06:24:28.283+0000 [id=159]	INFO	h.m.DownloadService$Downloadable#load: Obtained the updated data file for hudson.tasks.Maven.MavenInstaller
2023-08-03 06:24:29.435+0000 [id=159]	INFO	h.m.DownloadService$Downloadable#load: Obtained the updated data file for hudson.plugins.gradle.GradleInstaller
2023-08-03 06:24:30.366+0000 [id=159]	INFO	h.m.DownloadService$Downloadable#load: Obtained the updated data file for hudson.tasks.Ant.AntInstaller
2023-08-03 06:24:32.331+0000 [id=159]	INFO	h.m.DownloadService$Downloadable#load: Obtained the updated data file for hudson.tools.JDKInstaller
2023-08-03 06:24:32.331+0000 [id=159]	INFO	hudson.util.Retrier#start: Performed the action check updates server successfully at the attempt #1
2023-08-03 06:26:53.508+0000 [id=299]	INFO	i.j.docker.client.DockerAPI#getOrMakeClient: Cached connection io.jenkins.docker.client.DockerAPI$SharableDockerClient@17d3ea47 to DockerClientParameters{dockerUri='tcp://localhost:4243', credentialsId='null', readTimeoutInMsOrNull=60000, connectTimeoutInMsOrNull=60000}  
</pre>

You may now try accessing the Jenkins Dashboard web page on your RPS Lab machine Chrome web browser
```
http://localhost:8080
```
