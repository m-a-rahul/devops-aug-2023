## What is Hypervisor?
- Hypervisor refers to Virtualization technology
- Virtualization allows us to run multiple OS on the same Laptop/Desktop/Workstation/Server
- Many OS can be active and can run side by side
- Each Virtual Machine(VM) aka Guest OS represents one Operating System
- Each VM gets its own dedicated hardware resources (RAM, CPU Cores, Virtual Network Card, Virtual graphics card, Storage, etc)
- This type of virtualization is called heavy-weight virtualization as each VM requires dedicated hardware resources
- Benefits
- Processors with multiple cores
- Processors also comes in different form Factors
  - SCM (Single Chip Module) - 1 IC will contain just 1 Processor
  - MCM (Multiple Chip Module) - 1 IC may contain many Processors ( 8 Processors )
  - Each Processor supports 256 cores ( 8 Processor x 256 = 2048 Cores )
  - HyperThreading - each physical core is seen as 2~4 virtual cores ( 2048 Physical cores x 2 = 4096 Virtual cores )
 
## What are Containers?
- Application virtualization technology
- one container represents one application
- light weight virtualization technology, as containers don't require dedicated hardware resources
- though comparing a container with Virtual Machine which represents a OS is incorrect, why people tend to compare is
  - Just like an OS has a shell/command-prompt the containers also have such terminal
  - Just like an OS has a file system, the containers also have file system
  - Just like an OS has a Network card, the containers also tend to have virtual network cards
  - Just like OS gets an IP address, containers also get their own IP address
  - Just like OS, containers also have their own network stack
  - Just like OS, containers also have their port range 0-65535
 
# Docker Commands

## Listing docker images from your local docker registry
```
docker images
```

Expected output
<pre>
egan@tektutor.org:~/devops-aug-2023$ docker images
REPOSITORY                                       TAG            IMAGE ID       CREATED         SIZE
releases-docker.jfrog.io/jfrog/artifactory-oss   latest         b440125d9795   4 days ago      1.84GB
tektutor/maven                                   latest         80584dce5e06   7 weeks ago     973MB
tektutor/ansible-centos-node                     latest         4b5334077cdf   7 weeks ago     468MB
tektutor/ansible-ubuntu-node                     latest         1463db4fb11c   7 weeks ago     220MB
liquibase/liquibase                              latest         0aa2a8bc2574   7 weeks ago     355MB
xebialabs/xl-release                             22.2           ff6e8416ec95   7 weeks ago     887MB
mysql                                            latest         c71276df4a87   8 weeks ago     565MB
tektutor/java                                    1.0            3dec350d1b8d   2 months ago    416MB
tektutor/hello                                   1.0            f0652e271e67   2 months ago    416MB
localhost:5000/tektutor-ubuntu                   22.04          8af846fe34ca   2 months ago    729MB
bitnami/nginx                                    latest         7a094f97a968   2 months ago    92.2MB
nginx                                            latest         f9c14fe76d50   2 months ago    143MB
wordpress                                        latest         5174bdcbb532   2 months ago    616MB
registry                                         2              65f3b3441f04   2 months ago    24MB
ubuntu                                           22.04          3b418d7b466a   3 months ago    77.8MB
registry.access.redhat.com/ubi8/openjdk-11       latest         d1ce871371c2   3 months ago    394MB
mysql                                            5.7            dd6675b5cfea   3 months ago    569MB
centos                                           centos7        eeb6ee3f44bd   22 months ago   204MB
ubuntu                                           16.04          b6f507652425   23 months ago   135MB
liquibase/liquibase                              4.4.2          819dfbe60d20   2 years ago     348MB
maven                                            3.6.3-jdk-11   e23b595c92ad   2 years ago     658MB
docker.bintray.io/jfrog/artifactory-oss          6.23.13        6106bdbbf79d   2 years ago     743MB
k8s.gcr.io/pause                                 3.1            da86e6ba6ca1   5 years ago     742kB
</pre>

## Downloading docker image from Docker Hub to Local Registry
```
docker pull python:latest
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023$ docker pull python:latest
latest: Pulling from library/python
785ef8b9b236: Pull complete 
5a6dad8f55ae: Pull complete 
bd36c7bfe5f4: Pull complete 
4d207285f6d2: Pull complete 
9402da1694b8: Pull complete 
9bdbf45d01af: Pull complete 
dd8b7ef87a9d: Pull complete 
4de52e7027c5: Pull complete 
Digest: sha256:9a1b705aecedc76e8bf87dfca091d7093df3f2dd4765af6c250134ce4298a584
Status: Downloaded newer image for python:latest
docker.io/library/python:latest
</pre>

You may now try listing the docker images to see if python image shows up
```
docker images
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023$ docker images
REPOSITORY                                       TAG            IMAGE ID       CREATED         SIZE
releases-docker.jfrog.io/jfrog/artifactory-oss   latest         b440125d9795   4 days ago      1.84GB
<b>python                                           latest         608c79ebc6d5   6 weeks ago     1.01GB</b>
</pre>
