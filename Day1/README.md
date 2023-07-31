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

##  ⛹️‍♂️ Lab - Installing tree utility in CentOS
```
sudo yum install -y epel-release
sudo yum install -y tree
```


## ⛹️‍♂️ Lab - Cloning the TekTutor Training Repository (Only the first time)
```
cd ~
git clone https://github.com/tektutor/devops-aug-2023.git
cd devops-aug-2023
tree
```

## ⛹️‍♂️ Lab - Pulling only delta changes after doing clone once
```
cd ~
cd devops-aug-2023
git pull
```

## ⛹️‍♂️ Lab - Compile your first maven project
```
cd ~
cd devops-aug-2023/Day1/hello
mvn compile
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023/Day1/hello$ <b>mvn compile</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< org.tektutor:hello >-------------------------
[INFO] Building hello 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ hello ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/jegan/devops-aug-2023/Day1/hello/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ hello ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/jegan/devops-aug-2023/Day1/hello/target/classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.787 s
[INFO] Finished at: 2023-07-31T12:53:22+05:30
[INFO] ------------------------------------------------------------------------
</pre>


## ⛹️‍♀️ Lab - Cleaning your project binary output folder(target -folder)
```
cd ~
cd devops-aug-2023/Day1/hello
mvn clean
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023/Day1/hello$ <b>mvn clean</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< org.tektutor:hello >-------------------------
[INFO] Building hello 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ hello ---
[INFO] Deleting /home/jegan/devops-aug-2023/Day1/hello/target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.208 s
[INFO] Finished at: 2023-07-31T12:55:04+05:30
[INFO] ------------------------------------------------------------------------
jegan@tektutor.org:~/devops-aug-2023/Day1/hello$ <b>ls</b>
pom.xml  src  
</pre>

## ⛹️‍♂️ Lab - Effective pom
```
cd ~
cd devops-aug-2023/Day1/hello
mvn help:effective-settings
```

Expected output
```
jegan@tektutor.org:~/devops-aug-2023/Day1/hello$ mvn help:effective-settings
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< org.tektutor:hello >-------------------------
[INFO] Building hello 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.4.0:effective-settings (default-cli) @ hello ---
[INFO] 
Effective user-specific configuration settings:

<?xml version="1.0" encoding="UTF-8"?>
<!-- ====================================================================== -->
<!--                                                                        -->
<!-- Generated by Maven Help Plugin                                         -->
<!-- See: https://maven.apache.org/plugins/maven-help-plugin/               -->
<!--                                                                        -->
<!-- ====================================================================== -->
<!-- ====================================================================== -->
<!--                                                                        -->
<!-- Effective Settings for 'jegan' on 'tektutor.org'                       -->
<!--                                                                        -->
<!-- ====================================================================== -->
<settings xmlns="http://maven.apache.org/SETTINGS/1.1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd">
  <localRepository>/home/jegan/.m2/repository</localRepository>
  <servers>
    <server>
      <username>admin</username>
      <password>***</password>
      <id>jfrog</id>
    </server>
  </servers>
  <pluginGroups>
    <pluginGroup>org.apache.maven.plugins</pluginGroup>
    <pluginGroup>org.codehaus.mojo</pluginGroup>
  </pluginGroups>
</settings>


[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.454 s
[INFO] Finished at: 2023-07-31T13:47:26+05:30
[INFO] ------------------------------------------------------------------------
```

## ⛹️‍♀️ Lab - Listing the default lifecycle phases
```
cd ~
cd devops-aug-2023/Day1/hello
mvn help:describe -Dcmd=compile
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023/Day1/hello$ mvn help:describe -Dcmd=compile
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< org.tektutor:hello >-------------------------
[INFO] Building hello 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.4.0:describe (default-cli) @ hello ---
[INFO] 'compile' is a phase corresponding to this plugin:
org.apache.maven.plugins:maven-compiler-plugin:3.1:compile

It is a part of the lifecycle for the POM packaging 'jar'. This lifecycle includes the following phases:
* validate: Not defined
* initialize: Not defined
* generate-sources: Not defined
* process-sources: Not defined
* generate-resources: Not defined
* process-resources: org.apache.maven.plugins:maven-resources-plugin:2.6:resources
* compile: org.apache.maven.plugins:maven-compiler-plugin:3.1:compile
* process-classes: Not defined
* generate-test-sources: Not defined
* process-test-sources: Not defined
* generate-test-resources: Not defined
* process-test-resources: org.apache.maven.plugins:maven-resources-plugin:2.6:testResources
* test-compile: org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile
* process-test-classes: Not defined
* test: org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test
* prepare-package: Not defined
* package: org.apache.maven.plugins:maven-jar-plugin:2.4:jar
* pre-integration-test: Not defined
* integration-test: Not defined
* post-integration-test: Not defined
* verify: Not defined
* install: org.apache.maven.plugins:maven-install-plugin:2.4:install
* deploy: org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.466 s
[INFO] Finished at: 2023-07-31T13:50:23+05:30
[INFO] ------------------------------------------------------------------------
</pre>

## ⛹️‍♀️ Lab - Listing the clean lifecycle phases
```
cd ~
cd devops-aug-2023/Day1/hello
mvn help:describe -Dcmd=clean
```

Expected output
<pre>
egan@tektutor.org:~/devops-aug-2023/Day1/hello$ mvn help:describe -Dcmd=clean
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< org.tektutor:hello >-------------------------
[INFO] Building hello 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] ]
[INFO] --- maven-help-plugin:3.4.0:describe (default-cli) @ hello ---
[INFO] 'clean' is a phase within the 'clean' lifecycle, which has the following phases: 
* pre-clean: Not defined
* clean: org.apache.maven.plugins:maven-clean-plugin:2.5:clean
* post-clean: Not defined

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.443 s
[INFO] Finished at: 2023-07-31T13:52:13+05:30
[INFO] ------------------------------------------------------------------------
</pre>

## ⛹️‍♀️ Lab - Listing the site lifecycle phases
```
cd ~
cd devops-aug-2023/Day1/hello
mvn site
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023/Day1/hello$ mvn help:describe -Dcmd=site
[INFO] Scanning for projects...
[INFO] ]
[INFO] -------------------------< org.tektutor:hello >-------------------------
[INFO] Building hello 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.4.0:describe (default-cli) @ hello ---
[INFO] 'site' is a phase within the 'site' lifecycle, which has the following phases: 
* pre-site: Not defined
* site: org.apache.maven.plugins:maven-site-plugin:3.3:site
* post-site: Not defined
* site-deploy: org.apache.maven.plugins:maven-site-plugin:3.3:deploy
showWarnings
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.438 s
[INFO] Finished at: 2023-07-31T13:52:37+05:30
[INFO] ------------------------------------------------------------------------
</pre>

## ⛹️‍♀️ Lab - Executing JUnit Test cases as part of maven build
```
cd ~
cd devops-aug-2023/Day1/helloshowWarnings
mvn test
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023/Day1/hello$ mvn test
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< org.tektutor:hello >-------------------------
[INFO] Building hello 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ hello ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/jegan/devops-aug-2023/Day1/hello/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ hello ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/jegan/devops-aug-2023/Day1/hello/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ hello ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourcshowWarningseDirectory /home/jegan/devops-aug-2023/Day1/hello/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ hello ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/jegan/devops-aug-2023/Day1/hello/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ hello ---
[INFO] Surefire report directory: /home/jegan/devops-aug-2023/Day1/hello/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running org.tektutor.HelloTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.032 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.350 s
[INFO] Finished at: 2023-07-31T14:12:14+05:30
[INFO] ------------------------------------------------------------------------ 
</pre>

## ⛹️‍♀️ Lab - Listing the maven plugin goals
```
cd ~
cd devops-aug-2023/Day1/helloshowWarnings
mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin:3.1 -Ddetail
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023/Day1/hello$ <b>mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin:3.1 -Ddetail</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------------< org.tektutor:hello >-------------------------
[INFO] Building hello 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.4.0:describe (default-cli) @ hello ---
[INFO] org.apache.maven.plugins:maven-compiler-plugin:3.1

Name: Maven Compiler Plugin
Description: The Compiler Plugin is used to compile the sources of your
  project.
Group Id: org.apache.maven.plugins
Artifact Id: maven-compiler-plugin
Version: 3.1
Goal Prefix: compiler

This plugin has 3 goals:

compiler:compile
  Description: Compiles application sources
  Implementation: org.apache.maven.plugin.compiler.CompilerMojo
  Language: java
  Bound to phase: compile

  Available parameters:

    annotationProcessors
      
      Names of annotation processors to run. Only applies to JDK 1.6+ If not
      set, the default annotation processors discovery process applies.

    compilerArgs
      
      Sets the arguments to be passed to the compiler if {@link #fork} is set
      to true. Example:
      <compilerArgs> <arg>-Xmaxerrs=1000</arg> <arg>-Xlint</arg>
      </compilerArgs>

    compilerArgument
      
      Sets the unformatted single argument string to be passed to the compiler
      if {@link #fork} is set to true. To pass multiple arguments such as
      -Xmaxerrs 1000 (which are actually two arguments) you have to use {@link
      #compilerArguments}.
      
      This is because the list of valid arguments passed to a Java compiler
      varies based on the compiler version.

    compilerArguments
      
      Sets the arguments to be passed to the compiler (prepending a dash) if
      {@link #fork} is set to true.
      
      This is because the list of valid arguments passed to a Java compiler
      varies based on the compiler version.
      
      To pass -Xmaxerrs 1000 -Xlint -Xlint:-path -Averbose=true you should
      include the following:
      <compilerArguments> <Xmaxerrs>1000</Xmaxerrs> <Xlint/> <Xlint:-path/>
      <Averbose>true</Averbose> </compilerArguments>
      Deprecated. use {@link #compilerArgs} instead.

    compilerId (Default: javac)
      User property: maven.compiler.compilerId
      The compiler id of the compiler to use. See this guide for more
      information.

    compilerReuseStrategy (Default: ${reuseCreated})
      User property: maven.compiler.compilerReuseStrategy
      Strategy to re use javacc class created:
      * reuseCreated (default): will reuse already created but in case of
      multi-threaded builds, each thread will have its own instance
      * reuseSame: the same Javacc class will be used for each compilation even
      for multi-threaded build
      * alwaysNew: a new Javacc class will be created for each compilation Note
      this parameter value depends on the os/jdk you are using, but the default
      value should work on most of env.

    compilerVersion
      User property: maven.compiler.compilerVersion
      Version of the compiler to use, ex. "1.3", "1.5", if {@link #fork} is set
      to true.

    debug (Default: true)
      User property: maven.compiler.debug
      Set to true to include debugging information in the compiled class files.

    debuglevel
      User property: maven.compiler.debuglevel
      Keyword list to be appended to the -g command-line switch. Legal values
      are none or a comma-separated list of the following keywords: lines,
      vars, and source. If debug level is not specified, by default, nothing
      will be appended to -g. If debug is not turned on, this attribute will be
      ignored.

    encoding (Default: ${project.build.sourceEncoding})
      User property: encoding
      The -encoding argument for the Java compiler.

    excludes
      A list of exclusion filters for the compiler.

    executable
      User property: maven.compiler.executable
      Sets the executable of the compiler to use when {@link #fork} is true.

    failOnError (Default: true)
      User property: maven.compiler.failOnError
      Indicates whether the build will continue even if there are compilation
      errors.

    fileExtensions
      file extensions to check timestamp for incremental build default contains
      only .class

    forceJavacCompilerUse (Default: false)
      User property: maven.compiler.forceJavacCompilerUse
      compiler can now use javax.tools if available in your current jdk, you
      can disable this feature using
      -Dmaven.compiler.forceJavacCompilerUse=true or in the plugin
      configuration

    fork (Default: false)
      User property: maven.compiler.fork
      Allows running the compiler in a separate process. If false it uses the
      built in compiler, while if true it will use an executable.

    generatedSourcesDirectory (Default:
    ${project.build.directory}/generated-sources/annotations)
      
      Specify where to place generated source files created by annotation
      processing. Only applies to JDK 1.6+

    includes
      A list of inclusion filters for the compiler.

    maxmem
      User property: maven.compiler.maxmem
      Sets the maximum size, in megabytes, of the memory allocation pool, ex.
      "128", "128m" if {@link #fork} is set to true.

    meminitial
      User property: maven.compiler.meminitial
      Initial size, in megabytes, of the memory allocation pool, ex. "64",
      "64m" if {@link #fork} is set to true.

    mojoExecution
      User property: mojoExecution
      (no description available)

    optimize (Default: false)
      User property: maven.compiler.optimize
      Set to true to optimize the compiled code using the compiler's
      optimization methods.

    outputFileName
      Sets the name of the output file when compiling a set of sources to a
      single file.
      
      expression="${project.build.finalName}"

    proc
      
      Sets whether annotation processing is performed or not. Only applies to
      JDK 1.6+ If not set, both compilation and annotation processing are
      performed at the same time.
      
      Allowed values are:
      
      * none - no annotation processing is performed.
      * only - only annotation processing is done, no compilation.

    showDeprecation (Default: false)
      User property: maven.compiler.showDeprecation
      Sets whether to show source locations where deprecated APIs are used.

    showWarnings (Default: false)
      User property: maven.compiler.showWarnings
      Set to true to show compilation warnings.

    skipMain
      User property: maven.main.skip
      Set this to 'true' to bypass compilation of main sources. Its use is NOT
      RECOMMENDED, but quite convenient on occasion.

    skipMultiThreadWarning (Default: false)
      User property: maven.compiler.skipMultiThreadWarning
      (no description available)

    source (Default: 1.5)
      User property: maven.compiler.source
      The -source argument for the Java compiler.

    staleMillis (Default: 0)
      User property: lastModGranularityMs
      Sets the granularity in milliseconds of the last modification date for
      testing whether a source needs recompilation.

    target (Default: 1.5)
      User property: maven.compiler.target
      The -target argument for the Java compiler.

    useIncrementalCompilation (Default: true)
      User property: maven.compiler.useIncrementalCompilation
      to enable/disable incrementation compilation feature

    verbose (Default: false)
      User property: maven.compiler.verbose
      Set to true to show messages about what the compiler is doing.

compiler:help
  Description: Display help information on maven-compiler-plugin.
    Call mvn compiler:help -Ddetail=true -Dgoal=<goal-name> to display
    parameter details.
  Implementation: org.apache.maven.plugin.compiler.HelpMojo
  Language: java

  Available parameters:

    detail (Default: false)
      User property: detail
      If true, display all settable properties for each goal.

    goal
      User property: goal
      The name of the goal for which to show help. If unspecified, all goals
      will be displayed.

    indentSize (Default: 2)
      User property: indentSize
      The number of spaces per indentation level, should be positive.

    lineLength (Default: 80)
      User property: lineLength
      The maximum length of a display line, should be positive.

compiler:testCompile
  Description: Compiles application test sources.
  Implementation: org.apache.maven.plugin.compiler.TestCompilerMojo
  Language: java
  Bound to phase: test-compile

  Available parameters:

    annotationProcessors
      
      Names of annotation processors to run. Only applies to JDK 1.6+ If not
      set, the default annotation processors discovery process applies.

    compilerArgs
      
      Sets the arguments to be passed to the compiler if {@link #fork} is set
      to true. Example:
      <compilerArgs> <arg>-Xmaxerrs=1000</arg> <arg>-Xlint</arg>
      </compilerArgs>

    compilerArgument
      
      Sets the unformatted single argument string to be passed to the compiler
      if {@link #fork} is set to true. To pass multiple arguments such as
      -Xmaxerrs 1000 (which are actually two arguments) you have to use {@link
      #compilerArguments}.
      
      This is because the list of valid arguments passed to a Java compiler
      varies based on the compiler version.

    compilerArguments
      
      Sets the arguments to be passed to the compiler (prepending a dash) if
      {@link #fork} is set to true.
      
      This is because the list of valid arguments passed to a Java compiler
      varies based on the compiler version.
      
      To pass -Xmaxerrs 1000 -Xlint -Xlint:-path -Averbose=true you should
      include the following:
      <compilerArguments> <Xmaxerrs>1000</Xmaxerrs> <Xlint/> <Xlint:-path/>
      <Averbose>true</Averbose> </compilerArguments>
      Deprecated. use {@link #compilerArgs} instead.

    compilerId (Default: javac)
      User property: maven.compiler.compilerId
      The compiler id of the compiler to use. See this guide for more
      information.

    compilerReuseStrategy (Default: ${reuseCreated})
      User property: maven.compiler.compilerReuseStrategy
      Strategy to re use javacc class created:
      * reuseCreated (default): will reuse already created but in case of
      multi-threaded builds, each thread will have its own instance
      * reuseSame: the same Javacc class will be used for each compilation even
      for multi-threaded build
      * alwaysNew: a new Javacc class will be created for each compilation Note
      this parameter value depends on the os/jdk you are using, but the default
      value should work on most of env.

    compilerVersion
      User property: maven.compiler.compilerVersion
      Version of the compiler to use, ex. "1.3", "1.5", if {@link #fork} is set
      to true.

    debug (Default: true)
      User property: maven.compiler.debug
      Set to true to include debugging information in the compiled class files.

    debuglevel
      User property: maven.compiler.debuglevel
      Keyword list to be appended to the -g command-line switch. Legal values
      are none or a comma-separated list of the following keywords: lines,
      vars, and source. If debug level is not specified, by default, nothing
      will be appended to -g. If debug is not turned on, this attribute will be
      ignored.

    encoding (Default: ${project.build.sourceEncoding})
      User property: encoding
      The -encoding argument for the Java compiler.

    executable
      User property: maven.compiler.executable
      Sets the executable of the compiler to use when {@link #fork} is true.

    failOnError (Default: true)
      User property: maven.compiler.failOnError
      Indicates whether the build will continue even if there are compilation
      errors.

    fileExtensions
      file extensions to check timestamp for incremental build default contains
      only .class

    forceJavacCompilerUse (Default: false)
      User property: maven.compiler.forceJavacCompilerUse
      compiler can now use javax.tools if available in your current jdk, you
      can disable this feature using
      -Dmaven.compiler.forceJavacCompilerUse=true or in the plugin
      configuration

    fork (Default: false)
      User property: maven.compiler.fork
      Allows running the compiler in a separate process. If false it uses the
      built in compiler, while if true it will use an executable.

    generatedTestSourcesDirectory (Default:
    ${project.build.directory}/generated-test-sources/test-annotations)
      
      Specify where to place generated source files created by annotation
      processing. Only applies to JDK 1.6+

    maxmem
      User property: maven.compiler.maxmem
      Sets the maximum size, in megabytes, of the memory allocation pool, ex.
      "128", "128m" if {@link #fork} is set to true.

    meminitial
      User property: maven.compiler.meminitial
      Initial size, in megabytes, of the memory allocation pool, ex. "64",
      "64m" if {@link #fork} is set to true.

    mojoExecution
      User property: mojoExecution
      (no description available)

    optimize (Default: false)
      User property: maven.compiler.optimize
      Set to true to optimize the compiled code using the compiler's
      optimization methods.

    outputFileName
      Sets the name of the output file when compiling a set of sources to a
      single file.
      
      expression="${project.build.finalName}"

    proc
      
      Sets whether annotation processing is performed or not. Only applies to
      JDK 1.6+ If not set, both compilation and annotation processing are
      performed at the same time.
      
      Allowed values are:
      
      * none - no annotation processing is performed.
      * only - only annotation processing is done, no compilation.

    showDeprecation (Default: false)
      User property: maven.compiler.showDeprecation
      Sets whether to show source locations where deprecated APIs are used.

    showWarnings (Default: false)
      User property: maven.compiler.showWarnings
      Set to true to show compilation warnings.

    skip
      User property: maven.test.skip
      Set this to 'true' to bypass compilation of test sources. Its use is NOT
      RECOMMENDED, but quite convenient on occasion.

    skipMultiThreadWarning (Default: false)
      User property: maven.compiler.skipMultiThreadWarning
      (no description available)

    source (Default: 1.5)
      User property: maven.compiler.source
      The -source argument for the Java compiler.

    staleMillis (Default: 0)
      User property: lastModGranularityMs
      Sets the granularity in milliseconds of the last modification date for
      testing whether a source needs recompilation.

    target (Default: 1.5)
      User property: maven.compiler.target
      The -target argument for the Java compiler.

    testCompilerArgument
      
      Sets the unformatted argument string to be passed to test compiler if
      fork is set to true.
      
      This is because the list of valid arguments passed to a Java compiler
      varies based on the compiler version.

    testCompilerArguments
      
      Sets the arguments to be passed to test compiler (prepending a dash) if
      fork is set to true.
      
      This is because the list of valid arguments passed to a Java compiler
      varies based on the compiler version.

    testExcludes
      A list of exclusion filters for the compiler.

    testIncludes
      A list of inclusion filters for the compiler.

    testSource
      User property: maven.compiler.testSource
      The -source argument for the test Java compiler.

    testTarget
      User property: maven.compiler.testTarget
      The -target argument for the test Java compiler.

    useIncrementalCompilation (Default: true)
      User property: maven.compiler.useIncrementalCompilation
      to enable/disable incrementation compilation feature

    verbose (Default: false)
      User property: maven.compiler.verbose
      Set to true to show messages about what the compiler is doing.


[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.875 s
[INFO] Finished at: 2023-07-31T14:15:32+05:30
[INFO] ------------------------------------------------------------------------
</pre>


## Running JFrog Artifactory servers via Docker container
```
```

Expected output
<pre>
jegan@tektutor.org:~/devops-aug-2023/Day1/hello$ docker logs -f artifactory
Preparing to run Artifactory in Docker
Running as uid=1030(artifactory) gid=1030(artifactory) groups=1030(artifactory)
Dockerfile for this image can found inside the container.
To view the Dockerfile: 'cat /docker/artifactory-oss/Dockerfile.artifactory'.
Copying Artifactory bootstrap files
2023-07-31T09:33:20.999Z [shell] [INFO ] [] [installerCommon.sh:1601       ] [main] - Checking open files and processes limits
2023-07-31T09:33:21.040Z [shell] [INFO ] [] [installerCommon.sh:1604       ] [main] - Current max open files is 1048576
2023-07-31T09:33:21.083Z [shell] [INFO ] [] [installerCommon.sh:1615       ] [main] - Current max open processes is unlimited
[WARN ] Error while initializing File resolver : Config file does not exists : /opt/jfrog/artifactory/var/etc/system.yaml

Database connection check failed Could not determine database type
2023-07-31T09:33:21.200Z [shell] [INFO ] [] [installerCommon.sh:1684       ] [main] - Testing directory /opt/jfrog/artifactory/var has read/write permissions for user id 1030
2023-07-31T09:33:21.245Z [shell] [INFO ] [] [installerCommon.sh:1699       ] [main] - Permissions for /opt/jfrog/artifactory/var are good
2023-07-31T09:33:21.936Z [shell] [INFO ] [] [installerCommon.sh:3477       ] [main] - Setting JF_SHARED_NODE_ID to 40549d3aaa65
2023-07-31T09:33:22.065Z [shell] [INFO ] [] [installerCommon.sh:3477       ] [main] - Setting JF_SHARED_NODE_IP to 172.17.0.2
2023-07-31T09:33:22.193Z [shell] [INFO ] [] [installerCommon.sh:3477       ] [main] - Setting JF_SHARED_NODE_NAME to 40549d3aaa65
2023-07-31T09:33:23.616Z [shell] [INFO ] [] [artifactoryCommon.sh:438      ] [main] - Removing old custom drivers : /opt/jfrog/artifactory/app/artifactory/tomcat/lib/jf_*
2023-07-31T09:33:23.658Z [shell] [INFO ] [] [artifactoryCommon.sh:443      ] [main] - Copying /opt/jfrog/artifactory/var/bootstrap/artifactory/tomcat/lib/README.md to /opt/jfrog/artifactory/app/artifactory/tomcat/lib/jf_README.md
2023-07-31T09:33:24.039Z [shell] [INFO ] [] [artifactoryCommon.sh:213      ] [main] - Saving /opt/jfrog/artifactory/app/artifactory/tomcat/conf/server.xml as /opt/jfrog/artifactory/app/artifactory/tomcat/conf/server.xml.orig
2023-07-31T09:33:24.092Z [shell] [INFO ] [] [artifactoryCommon.sh:221      ] [main] - Using Tomcat template to generate : /opt/jfrog/artifactory/app/artifactory/tomcat/conf/server.xml
2023-07-31T09:33:24.243Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${artifactory.port||8081} to default value : 8081
2023-07-31T09:33:24.366Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${artifactory.tomcat.connector.sendReasonPhrase||false} to default value : false
2023-07-31T09:33:24.495Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${artifactory.tomcat.connector.relaxedPathChars||_SQUARE_BRACKETS_} to default value : _SQUARE_BRACKETS_
2023-07-31T09:33:24.629Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${artifactory.tomcat.connector.relaxedQueryChars||_SQUARE_BRACKETS_} to default value : _SQUARE_BRACKETS_
2023-07-31T09:33:24.756Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${artifactory.tomcat.connector.maxThreads||200} to default value : 200
2023-07-31T09:33:24.967Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${artifactory.tomcat.maintenanceConnector.port||8091} to default value : 8091
2023-07-31T09:33:25.096Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${artifactory.tomcat.maintenanceConnector.maxThreads||5} to default value : 5
2023-07-31T09:33:25.219Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${artifactory.tomcat.maintenanceConnector.acceptCount||5} to default value : 5
2023-07-31T09:33:25.426Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${access.http.port||8040} to default value : 8040
2023-07-31T09:33:25.551Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${access.tomcat.connector.sendReasonPhrase||false} to default value : false
2023-07-31T09:33:25.678Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${access.tomcat.connector.maxThreads||50} to default value : 50
2023-07-31T09:33:25.926Z [shell] [INFO ] [] [systemYamlHelper.sh:607       ] [main] - Resolved JF_PRODUCT_HOME (/opt/jfrog/artifactory) from environment variable
2023-07-31T09:33:26.116Z [shell] [INFO ] [] [systemYamlHelper.sh:967       ] [main] - Resolved ${shared.tomcat.workDir||/opt/jfrog/artifactory/var/work/artifactory/tomcat} to default value : /opt/jfrog/artifactory/var/work/artifactory/tomcat

========================
JF Environment variables
========================

JF_ARTIFACTORY_USER                 : artifactory
JF_SHARED_NODE_ID                   : 40549d3aaa65
JF_SHARED_NODE_IP                   : 172.17.0.2
JF_ARTIFACTORY_PID                  : /opt/jfrog/artifactory/app/run/artifactory.pid
JF_PRODUCT_DATA_INTERNAL            : /var/opt/jfrog/artifactory
JF_SYSTEM_YAML                      : /opt/jfrog/artifactory/var/etc/system.yaml
JF_PRODUCT_HOME                     : /opt/jfrog/artifactory
JF_ROUTER_TOPOLOGY_LOCAL_REQUIREDSERVICETYPES : jfrt,jfac,jfmd,jffe,jfob,jfint,jfevt
JF_SHARED_NODE_NAME                 : 40549d3aaa65
Using default router's certificate and private key
Starting router...
router not running. Proceed to start it up.
router started. PID: 3624
2023-07-31T09:33:41.011Z [jfrt ] [INFO ] [7229d8b333b247ec] [ctoryContextConfigListener:326] [art-init            ] - 
                _   _  __           _                      ____   _____ _____
     /\        | | (_)/ _|         | |                    / __ \ / ____/ ____|
    /  \   _ __| |_ _| |_ __ _  ___| |_ ___  _ __ _   _  | |  | | (___| (___
   / /\ \ | '__| __| |  _/ _` |/ __| __/ _ \| '__| | | | | |  | |\___ \\___ \
  / ____ \| |  | |_| | || (_| | (__| || (_) | |  | |_| | | |__| |____) |___) |
 /_/    \_\_|   \__|_|_| \__,_|\___|\__\___/|_|   \__, |  \____/|_____/_____/
 Version:  7.63.8                                  __/ |
 Revision: 76308900                               |___/
 Product Version:  7.63.8
 Product Revision: 76308900
 Artifactory Home: '/opt/jfrog/artifactory'
 Node ID: '40549d3aaa65'
###############################################################
###   All services started successfully in 38.440 seconds   ###
###############################################################  
</pre>
