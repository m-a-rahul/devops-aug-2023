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
