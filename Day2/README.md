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

## Deleting docker image from local docker registry
```
docker rmi registry:2
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023$ docker rmi registry:2
Untagged: registry:2
Untagged: registry@sha256:20d084723c951e377e1a2a5b3df316173a845e300d57ccdd8ae3ab2da3439746
Deleted: sha256:65f3b3441f044d142ca365389fe0532900b4f4c7ffc47cb65f7bc7bd45857f06
Deleted: sha256:064051c3a2a77373c0e25b6be4dada18268a3431db567ef299bc6db2dfec1ff1
Deleted: sha256:b800adaafd3ce33dfcb13730ef43bb7a7483ed77b1c1d2c5354c6610028370fa
Deleted: sha256:53f461ca2fa072b83247906863d62d1abee86acba06b84504c19c58e9ff9d91a
Deleted: sha256:a1f1bff6ca971672d804bc9aeb5e762c21fd9e4390478ef6d12b96ea450c3e58
Deleted: sha256:bb01bd7e32b58b6694c8c3622c230171f1cec24001a82068a8d30d338f420d6c
</pre>

## Lab - Creating a container and running it in background
```
docker run -dit --name python --hostname python python:latest bash
docker ps
docker exec -it python bash
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023$ docker run -dit --name python --hostname python python:latest bash
17c7493b364a4172090bab1cf7daad1d485e2bfb7d0e8c132381832f1d3ce47f
jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE           COMMAND   CREATED         STATUS         PORTS     NAMES
17c7493b364a   python:latest   "bash"    2 seconds ago   Up 2 seconds             python

jegan@tektutor.org:~/devops-aug-2023$ docker exec -it python bash
root@python:/# ls
bin   dev  home  lib32	libx32	mnt  proc  run	 srv  tmp  var
boot  etc  lib	 lib64	media	opt  root  sbin  sys  usr
root@python:/# exit
exit
</pre>  


## Lab - Deleting containers
```
docker rm -f python python2 python3
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE           COMMAND   CREATED          STATUS          PORTS     NAMES
52c4b16eb690   python:latest   "bash"    14 minutes ago   Up 14 minutes             python3
37276c57eca6   python:latest   "bash"    14 minutes ago   Up 14 minutes             python2
6e6ab2d1cfb5   python:latest   "bash"    25 minutes ago   Up 24 minutes             python
jegan@tektutor.org:~/devops-aug-2023$ docker rm -f python python2 python3
python
python2
python3

jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
</pre>


