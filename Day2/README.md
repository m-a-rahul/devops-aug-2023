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
bd36c7bfe5f4: Pull complete python
4d207285f6d2: Pull complete 
9402da1694b8: Pull complete 
9bdbf45d01af: Pull complete 
dd8b7ef87a9d: Pull complete 
4de52e7027c5: Pull complete 
Digest: sha256:9a1b705aecedc76e8bf87dfca091d7093df3f2dd4765af6c250134ce4298a584
Status: Downloaded newer image for python:latest0
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
docker run -d --name mysql --hostname mysql -v /tmp/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root mysql:latest

docker exec -it mysql bash
mysql -u root -p

CREATE DATABASE tektutor;
USE tektutor;
CREATE TABLE training (id INT NOT NULL, name VARCHAR(100), duration VARCHAR(100), PRIMARY KEY(id) );
INSERT INTO training VALUES ( 1, "DevOps", "5 Days" );
INSERT INTO training VALUES ( 2, "Azure DevOps", "5 Days");
SELECT * FROM training;

exit
exit
```

Let's us delete the mysql container
```
docker rm -f mysql
```

Let's create a new mysql container 
```
docker run -dit --name python --hostname python python:latest bashjegan@tektutor.org:~/devops-aug-2023$ docker run -d --name mysql --hostname mysql -v /tmp/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root
```

Let's get inside the mysql container0
```
docker exec -it mysql bash
mysql -u root -p
SHOW DATABASE;
USE tektutor;
SHOW TABLES;
SELECT * FROM training;
```

The expectation is, even though we deleted the old mysql container, the data will be preserved as we are using external volume/storage.

## Lab - Deleting containers

```
docker rm -f python python2 python3
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE           COMMAND   CREATED          STATUS          PORTS     NAMES
52c4b16eb690   python:latest   "bash"    14 minutes ago   Up 14 minutes             python3
37276c57eca6   python:latest   "bash"    14 minutes ajegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE           COMMAND   CREATED         STATUS         PORTS     NAMES
17c7493b364a   python:latest   "bash"    7 minutes ago   Up 7 minutes             python
jegan@tektutor.org:~/devops-aug-2023$ docker stop python
python
jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
jegan@tektutor.org:~/devops-aug-2023$ docker ps -a
CONTAINER ID   IMAGE                                                   COMMAND                  CREATED         STATUS                       PORTS     NAMES
17c7493b364a   python:latest                                           "bash"                   7 minutes ago   Exited (137) 7 seconds ago             python
40549d3aaa65   releases-docker.jfrog.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   24 hours ago    Exited (137) 21 hours ago              artifactory
2cbd6b96b0c5   xebialabs/xl-release:22.2                               "/opt/xebialabs/tini…"   7 weeks ago     Exited (130) 7 weeks ago               xlr
2d1d256a3e00   mysql:latest                                            "docker-entrypoint.s…"   7 weeks ago     Exited (0) 7 weeks ago                 mysql
jegan@tektutor.org:~/devops-aug-2023$ docker start python
python
jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE           COMMAND   CREATED         STATUS        PORTS     NAMES
17c7493b364a   python:latest   "bash"    7 minutes ago   Up 1 second             python
jegan@tektutor.org:~/devops-aug-2023$ docker restart python
python
go   Up 14 minutes             python2
6e6ab2d1cfb5   python:latest   "bash"    25 minutes ago   Up 24 minutes             python
jegan@tektutor.org:~/devops-aug-2023$ docker rm -f python python2 python3
python
python2
python3

jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
</pre>

## Lab - Starting/stopping/restarting container
```
docker ps
docker stop python
docker ps
docker ps -a
docker start python
docker ps
docker restart python
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE           COMMAND   CREATED         STATUS         PORTS     NAMES
17c7493b364a   python:latest   "bash"    7 minutes ago   Up 7 minutes             python
jegan@tektutor.org:~/devops-aug-2023$ docker stop python
python
jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
jegan@tektutor.org:~/devops-aug-2023$ docker ps -a
CONTAINER ID   IMAGE                                                   COMMAND                  CREATED         STATUS                       PORTS     NAMES
17c7493b364a   python:latest                                           "bash"                   7 minutes ago   Exited (137) 7 seconds ago             python
40549d3aaa65   releases-docker.jfrog.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   24 hours ago    Exited (137) 21 hours ago              artifactory
2cbd6b96b0c5   xebialabs/xl-release:22.2                               "/opt/xebialabs/tini…"   7 weeks ago     Exited (130) 7 weeks ago               xlr
2d1d256a3e00   mysql:latest                                            "docker-entrypoint.s…"   7 weeks ago     Exited (0) 7 weeks ago                 mysql
jegan@tektutor.org:~/devops-aug-2023$ docker start python
python
jegan@tektutor.org:~/devops-aug-2023$ docker ps
CONTAINER ID   IMAGE           COMMAND   CREATED         STATUS        PORTS     NAMES
17c7493b364a   python:latest   "bash"    7 minutes ago   Up 1 second             python
jegan@tektutor.org:~/devops-aug-2023$ docker restart python
python  
</pre>

## Lab - Storing mysql db and records in an external storage using Docker Volume Mounting
```
docker run -d --name mysql --hostname mysql -v /tmp/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root mysql:latest
docker exec -it mysql bash
mysql -u root -p
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023$ docker run -d --name mysql --hostname mysql -v /tmp/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root mysql:latest
f1bb0361a59266aeccd57303070ecb182565e77b512db932d2d5e7972c2f63cc
  
jegan@tektutor.org:~/devops-aug-2023$ docker exec -it mysql bash
  
bash-4.4# mysql -u root -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 8
Server version: 8.0.33 MySQL Community Server - GPL

Copyright (c) 2000, 2023, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| tektutor           |
+--------------------+
5 rows in set (0.00 sec)

mysql> USE tektutor;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> SHOW TABLES;'
+--------------------+
| Tables_in_tektutor |
+--------------------+
| training           |
+--------------------+
1 row in set (0.00 sec)
mysql> SELECT * FROM training;
+----+-----------+----------+
| id | name      | duration |
+----+-----------+----------+
|  1 | DevOps    | 5 Days   |
|  2 | OpenShift | 5 Days   |
+----+-----------+----------+
2 rows in set (0.00 sec)

mysql> exit
Bye
bash-4.4# exit
exit
 2023, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| tektutor           |
+--------------------+
5 rows in set (0.00 sec)

mysql> USE tektutor;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> SHOW TABLES;'
+--------------------+
| Tables_in_tektutor |
+--------------------+
| training           |
+--------------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM training;
+----+-----------+----------+
| id | name      | duration |
+----+-----------+----------+
|  1 | DevOps    | 5 Days   |
|  2 | OpenShift | 5 Days   |
+----+-----------+----------+
2 rows in set (0.00 sec)

mysql> exit
Bye
bash-4.4# exit
exit  
</pre>

## Lab - Port Forwarding to expose container services to external world
First we would like to create 3 nginx web servers
```
docker run -d --name server1 --hostname server1 nginx:latest
docker run -d --name server2 --hostname server2 nginx:latest
docker run -d --name server3 --hostname server3 nginx:latest
```

Finding the IP address of server1, server2 and server3
```
docker inspect server1 | grep IPA
docker inspect server2 | grep IPA
docker inspect server3 | grep IPA
```

Let's create a container for Load Balancing with Port forwarding
```
docker run -d --name lb --hostname lb -p 8001:80 nginx:latest
```

Let's list all containers and see if they are running
```
docker ps
```

In order to configure the lb container to work like a Load Balancer, we need copy the below nginx.conf file onto the lb container

nginx.conf
<pre>
user  nginx;
worker_processes  auto;

error_log  /var/log/nginx/error.log notice;
pid        /var/run/nginx.pid;

events {
    worker_connections  1024;
}

http {

    upstream servers {
        server  172.17.0.2:80;
        server  172.17.0.3:80;
        server  172.17.0.4:80;
    }

    server {
        location / {
            proxy_pass http://servers;
        }
    }
}  
</pre>

We need to copy the above file into lb container
```
docker cp nginx.conf lb:/etc/nginx/nginx.conf
docker restart lb
docker ps
```

Let's customize the server1, server2 and server3 web pages
```
echo "Server 1" > index.html
docker cp index.html server1:/usr/share/nginx/html/index.html

echo "Server 2" > index.html
docker cp index.html server2:/usr/share/nginx/html/index.html

echo "Server 3" > index.html
docker cp index.html server3:/usr/share/nginx/html/index.html
```

Now, you may try accessing the load balancer as shown below from your chrome web browser
```
http://localhost:8001
```
Whenever a request hits port 8001 it would be forwarded to one of the web servers ( server1, server2, or server 3)

