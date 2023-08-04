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


Checking sonarqube logs
<pre>
jegan@tektutor.org:~$ docker logs sonarqube
2023.08.04 04:53:04 INFO  app[][o.s.a.AppFileSystem] Cleaning or creating temp directory /opt/sonarqube/temp
2023.08.04 04:53:04 INFO  app[][o.s.a.es.EsSettings] Elasticsearch listening on [HTTP: 127.0.0.1:9001, TCP: 127.0.0.1:37839]
2023.08.04 04:53:04 INFO  app[][o.s.a.ProcessLauncherImpl] Launch process[ELASTICSEARCH] from [/opt/sonarqube/elasticsearch]: /opt/java/openjdk/bin/java -Xms4m -Xmx64m -XX:+UseSerialGC -Dcli.name=server -Dcli.script=./bin/elasticsearch -Dcli.libs=lib/tools/server-cli -Des.path.home=/opt/sonarqube/elasticsearch -Des.path.conf=/opt/sonarqube/temp/conf/es -Des.distribution.type=tar -cp /opt/sonarqube/elasticsearch/lib/*:/opt/sonarqube/elasticsearch/lib/cli-launcher/* org.elasticsearch.launcher.CliToolLauncher
2023.08.04 04:53:04 INFO  app[][o.s.a.SchedulerImpl] Waiting for Elasticsearch to be up and running
2023.08.04 04:53:07 INFO  es[][o.e.n.Node] version[8.7.0], pid[244], build[tar/09520b59b6bc1057340b55750186466ea715e30e/2023-03-27T16:31:09.816451435Z], OS[Linux/5.19.0-50-generic/amd64], JVM[Eclipse Adoptium/OpenJDK 64-Bit Server VM/17.0.8/17.0.8+7]
2023.08.04 04:53:07 INFO  es[][o.e.n.Node] JVM home [/opt/java/openjdk], using bundled JDK [false]
2023.08.04 04:53:07 INFO  es[][o.e.n.Node] JVM arguments [-Des.networkaddress.cache.ttl=60, -Des.networkaddress.cache.negative.ttl=10, -Djava.security.manager=allow, -XX:+AlwaysPreTouch, -Xss1m, -Djava.awt.headless=true, -Dfile.encoding=UTF-8, -Djna.nosys=true, -XX:-OmitStackTraceInFastThrow, -Dio.netty.noUnsafe=true, -Dio.netty.noKeySetOptimization=true, -Dio.netty.recycler.maxCapacityPerThread=0, -Dlog4j.shutdownHookEnabled=false, -Dlog4j2.disable.jmx=true, -Dlog4j2.formatMsgNoLookups=true, -Djava.locale.providers=SPI,COMPAT, --add-opens=java.base/java.io=ALL-UNNAMED, -XX:+UseG1GC, -Djava.io.tmpdir=/opt/sonarqube/temp, -XX:ErrorFile=/opt/sonarqube/logs/es_hs_err_pid%p.log, -Xlog:disable, -Des.networkaddress.cache.ttl=60, -Des.networkaddress.cache.negative.ttl=10, -XX:+AlwaysPreTouch, -Xss1m, -Djava.awt.headless=true, -Dfile.encoding=UTF-8, -Djna.nosys=true, -Djna.tmpdir=/opt/sonarqube/temp, -XX:-OmitStackTraceInFastThrow, -Dio.netty.noUnsafe=true, -Dio.netty.noKeySetOptimization=true, -Dio.netty.recycler.maxCapacityPerThread=0, -Dio.netty.allocator.numDirectArenas=0, -Dlog4j.shutdownHookEnabled=false, -Dlog4j2.disable.jmx=true, -Dlog4j2.formatMsgNoLookups=true, -Djava.locale.providers=COMPAT, -Dcom.redhat.fips=false, -Xmx512m, -Xms512m, -XX:MaxDirectMemorySize=256m, -XX:+HeapDumpOnOutOfMemoryError, -XX:G1HeapRegionSize=4m, -XX:InitiatingHeapOccupancyPercent=30, -XX:G1ReservePercent=15, -Des.distribution.type=tar, --module-path=/opt/sonarqube/elasticsearch/lib, --add-modules=jdk.net, -Djdk.module.main=org.elasticsearch.server]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [aggregations]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [analysis-common]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [apm]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [blob-cache]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [lang-painless]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [old-lucene-versions]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [parent-join]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [reindex]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [transport-netty4]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [x-pack-aggregate-metric]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [x-pack-core]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [x-pack-profiling]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] loaded module [x-pack-security]
2023.08.04 04:53:08 INFO  es[][o.e.p.PluginsService] no plugins loaded
2023.08.04 04:53:10 INFO  es[][o.e.e.NodeEnvironment] using [1] data paths, mounts [[/ (overlay)]], net usable_space [466.4gb], net total_space [937.3gb], types [overlay]
2023.08.04 04:53:10 INFO  es[][o.e.e.NodeEnvironment] heap size [512mb], compressed ordinary object pointers [true]
2023.08.04 04:53:10 INFO  es[][o.e.n.Node] node name [sonarqube], node ID [dG9wBJPRRUyMAD2fT5YG8A], cluster name [sonarqube], roles [ml, data_frozen, ingest, data_cold, data, remote_cluster_client, master, data_warm, data_content, transform, data_hot]
2023.08.04 04:53:10 INFO  es[][o.e.x.p.ProfilingPlugin] Profiling is enabled
2023.08.04 04:53:10 INFO  es[][o.e.x.s.Security] Security is disabled
2023.08.04 04:53:11 INFO  es[][o.e.t.n.NettyAllocator] creating NettyAllocator with the following configs: [name=unpooled, suggested_max_allocation_size=1mb, factors={es.unsafe.use_unpooled_allocator=null, g1gc_enabled=true, g1gc_region_size=4mb, heap_size=512mb}]
2023.08.04 04:53:11 INFO  es[][o.e.i.r.RecoverySettings] using rate limit [40mb] with [default=40mb, read=0b, write=0b, max=0b]
2023.08.04 04:53:11 INFO  es[][o.e.d.DiscoveryModule] using discovery type [single-node] and seed hosts providers [settings]
2023.08.04 04:53:11 INFO  es[][o.e.n.Node] initialized
2023.08.04 04:53:11 INFO  es[][o.e.n.Node] starting ...
2023.08.04 04:53:11 INFO  es[][o.e.t.TransportService] publish_address {127.0.0.1:37839}, bound_addresses {127.0.0.1:37839}
2023.08.04 04:53:11 WARN  es[][o.e.b.BootstrapChecks] max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]
2023.08.04 04:53:11 INFO  es[][o.e.c.c.ClusterBootstrapService] this node has not joined a bootstrapped cluster yet; [cluster.initial_master_nodes] is set to [sonarqube]
2023.08.04 04:53:11 INFO  es[][o.e.c.c.Coordinator] setting initial configuration to VotingConfiguration{dG9wBJPRRUyMAD2fT5YG8A}
2023.08.04 04:53:11 INFO  es[][o.e.c.s.MasterService] elected-as-master ([1] nodes joined)[_FINISH_ELECTION_, {sonarqube}{dG9wBJPRRUyMAD2fT5YG8A}{5Z1yHAQKQgaNK7UMe6og_Q}{sonarqube}{127.0.0.1}{127.0.0.1:37839}{cdfhilmrstw}{8.7.0} completing election], term: 1, version: 1, delta: master node changed {previous [], current [{sonarqube}{dG9wBJPRRUyMAD2fT5YG8A}{5Z1yHAQKQgaNK7UMe6og_Q}{sonarqube}{127.0.0.1}{127.0.0.1:37839}{cdfhilmrstw}{8.7.0}]}
2023.08.04 04:53:12 INFO  es[][o.e.c.c.CoordinationState] cluster UUID set to [Ljkgdea5Qp2QcTAwbzbagA]
2023.08.04 04:53:12 INFO  es[][o.e.c.s.ClusterApplierService] master node changed {previous [], current [{sonarqube}{dG9wBJPRRUyMAD2fT5YG8A}{5Z1yHAQKQgaNK7UMe6og_Q}{sonarqube}{127.0.0.1}{127.0.0.1:37839}{cdfhilmrstw}{8.7.0}]}, term: 1, version: 1, reason: Publication{term=1, version=1}
2023.08.04 04:53:12 INFO  es[][o.e.r.s.FileSettingsService] starting file settings watcher ...
2023.08.04 04:53:12 INFO  es[][o.e.r.s.FileSettingsService] file settings service up and running [tid=42]
2023.08.04 04:53:12 INFO  es[][o.e.c.c.NodeJoinExecutor] node-join: [{sonarqube}{dG9wBJPRRUyMAD2fT5YG8A}{5Z1yHAQKQgaNK7UMe6og_Q}{sonarqube}{127.0.0.1}{127.0.0.1:37839}{cdfhilmrstw}{8.7.0}] with reason [completing election]
2023.08.04 04:53:12 INFO  es[][o.e.h.AbstractHttpServerTransport] publish_address {127.0.0.1:9001}, bound_addresses {127.0.0.1:9001}
2023.08.04 04:53:12 INFO  es[][o.e.n.Node] started {sonarqube}{dG9wBJPRRUyMAD2fT5YG8A}{5Z1yHAQKQgaNK7UMe6og_Q}{sonarqube}{127.0.0.1}{127.0.0.1:37839}{cdfhilmrstw}{8.7.0}{rack_id=sonarqube, xpack.installed=true}
2023.08.04 04:53:12 INFO  es[][o.e.g.GatewayService] recovered [0] indices into cluster_state
2023.08.04 04:53:12 INFO  es[][o.e.h.n.s.HealthNodeTaskExecutor] Node [{sonarqube}{dG9wBJPRRUyMAD2fT5YG8A}] is selected as the current health node.
2023.08.04 04:53:12 INFO  es[][o.e.l.LicenseService] license [b2fd13e4-1f1b-4a27-80d8-b409989fdb7d] mode [basic] - valid
2023.08.04 04:53:12 INFO  app[][o.s.a.SchedulerImpl] Process[es] is up
2023.08.04 04:53:12 INFO  app[][o.s.a.ProcessLauncherImpl] Launch process[WEB_SERVER] from [/opt/sonarqube]: /opt/java/openjdk/bin/java -Djava.awt.headless=true -Dfile.encoding=UTF-8 -Djava.io.tmpdir=/opt/sonarqube/temp -XX:-OmitStackTraceInFastThrow --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.io=ALL-UNNAMED --add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED --add-exports=java.base/jdk.internal.ref=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED --add-opens=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.management/sun.management=ALL-UNNAMED --add-opens=jdk.management/com.sun.management.internal=ALL-UNNAMED -Dcom.redhat.fips=false -Xmx512m -Xms128m -XX:+HeapDumpOnOutOfMemoryError -Dhttp.nonProxyHosts=localhost|127.*|[::1] -cp ./lib/sonar-application-10.1.0.73491.jar:/opt/sonarqube/lib/jdbc/h2/h2-2.1.214.jar org.sonar.server.app.WebServer /opt/sonarqube/temp/sq-process7398677787460174571properties
WARNING: A terminally deprecated method in java.lang.System has been called
WARNING: System::setSecurityManager has been called by org.sonar.process.PluginSecurityManager (file:/opt/sonarqube/lib/sonar-application-10.1.0.73491.jar)
WARNING: Please consider reporting this to the maintainers of org.sonar.process.PluginSecurityManager
WARNING: System::setSecurityManager will be removed in a future release
2023.08.04 04:53:12 INFO  web[][o.s.p.ProcessEntryPoint] Starting Web Server
2023.08.04 04:53:13 INFO  web[][o.s.s.p.LogServerVersion] SonarQube Server / 10.1.0.73491 / 53c01c35c264c7e3d76cf5fb955de406f36b115e
2023.08.04 04:53:13 INFO  web[][o.s.s.p.d.EmbeddedDatabase] Starting embedded database on port 9092 with url jdbc:h2:tcp://127.0.0.1:9092/sonar;NON_KEYWORDS=VALUE
2023.08.04 04:53:13 INFO  web[][o.s.s.p.d.EmbeddedDatabase] Embedded database started. Data stored in: /opt/sonarqube/data
2023.08.04 04:53:13 INFO  web[][o.s.d.DefaultDatabase] Create JDBC data source for jdbc:h2:tcp://127.0.0.1:9092/sonar;NON_KEYWORDS=VALUE
2023.08.04 04:53:13 INFO  web[][c.z.h.HikariDataSource] HikariPool-1 - Starting...
2023.08.04 04:53:13 INFO  web[][c.z.h.p.HikariPool] HikariPool-1 - Added connection conn2: url=jdbc:h2:tcp://127.0.0.1:9092/sonar user=
2023.08.04 04:53:13 INFO  web[][c.z.h.HikariDataSource] HikariPool-1 - Start completed.
2023.08.04 04:53:13 WARN  web[][o.s.db.dialect.H2] H2 database should be used for evaluation purpose only.
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerFileSystemImpl] SonarQube home: /opt/sonarqube
2023.08.04 04:53:14 INFO  web[][o.s.s.u.SystemPasscodeImpl] System authentication by passcode is disabled
2023.08.04 04:53:14 INFO  web[][o.s.s.p.d.m.h.MigrationHistoryTableImpl] Creating table schema_migrations
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy C# Code Quality and Security / 9.3.0.71466 / e47cf88a6286a446a098754e5775535a330f58d7
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Clean as You Code / 2.0.0.334 / 424c67de80b14c8c1b168104a6749b9d280ef4f9
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Configuration detection fot Code Quality and Security / 1.2.0.267 / 4f37ba9ffb37a96d5883e52ad392ed32c5c6eaab
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Flex Code Quality and Security / 2.9.0.3375 / 3fb9c557effa2d3f6e4017984611e8dae60d030a
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Go Code Quality and Security / 1.13.0.4374 / dc92e7c248e31ecae6e18d94781588cc6264e517
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy HTML Code Quality and Security / 3.8.0.3510 / c8f3d4a50984c6a0b0699616f98ce81a9d2893db
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy IaC Code Quality and Security / 1.17.0.3976 / 5089f396ccda1f2ea0a6f2961b10042ea8c9cd69
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy JaCoCo / 1.3.0.1538 / 74a7798c7cea687c72ed9df40c93eb7ea2a58c49
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Java Code Quality and Security / 7.20.0.31692 / b40c64f1075774f7232608df6636586009ab8ab3
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy JavaScript/TypeScript/CSS Code Quality and Security / 10.3.1.21905 / f95f3d172103f7e438556705c96fb336b33900b4
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Kotlin Code Quality and Security / 2.15.0.2579 / 6ea5707d5a5600fc808653075f9d9cb6c21a4788
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy PHP Code Quality and Security / 3.30.0.9766 / 783200fd5af4e0f8ccbf027a97ebb5f377d5014f
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Python Code Quality and Security / 4.3.0.11660 / 7914a5be1ad88eab1ebd2a3c2f7e606404601e30
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Ruby Code Quality and Security / 1.13.0.4374 / dc92e7c248e31ecae6e18d94781588cc6264e517
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Scala Code Quality and Security / 1.13.0.4374 / dc92e7c248e31ecae6e18d94781588cc6264e517
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy Text Code Quality and Security / 2.1.0.1163 / 849cef77adc8d1a50235d2ef7005e23f67e2838a
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy VB.NET Code Quality and Security / 9.3.0.71466 / e47cf88a6286a446a098754e5775535a330f58d7
2023.08.04 04:53:14 INFO  web[][o.s.s.p.ServerPluginManager] Deploy XML Code Quality and Security / 2.8.1.4006 / 80e5629b173cd7a47c04e97cbe1a263db84ff844
2023.08.04 04:53:15 INFO  web[][o.s.s.e.EsClientProvider] Connected to local Elasticsearch: [http://localhost:9001]
2023.08.04 04:53:15 WARN  web[][o.s.a.s.w.WebService$Action] Description is not set on action api/monitoring/metrics
2023.08.04 04:53:15 WARN  web[][o.s.a.s.w.WebService$Action] Since is not set on action api/monitoring/metrics
2023.08.04 04:53:15 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/monitoring/metrics
2023.08.04 04:53:15 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/system/liveness
2023.08.04 04:53:15 INFO  web[][o.s.s.p.d.m.AutoDbMigration] Automatically perform DB migration on fresh install
2023.08.04 04:53:15 INFO  web[][DbMigrations] Executing DB migrations...
2023.08.04 04:53:15 INFO  web[][DbMigrations] #1 'Create initial schema'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #1 'Create initial schema': success | time=250ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #2 'Populate initial schema'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #2 'Populate initial schema': success | time=40ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100000 'Remove orphan rules in Quality Profiles'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100000 'Remove ```
```orphan rules in Quality Profiles': success | time=15ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100001 'Drop index 'projects_module_uuid' in the 'Components' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100001 'Drop index 'projects_module_uuid' in the 'Components' table': success | time=8ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100002 'Drop column 'module_uuid' in the 'Components' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100002 'Drop column 'module_uuid' in the 'Components' table': success | time=24ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100003 'Drop column 'module_uuid_path' in the 'Components' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100003 'Drop column 'module_uuid_path' in the 'Components' table': success | time=14ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100004 'Drop column 'b_module_uuid' in the 'Components' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100004 'Drop column 'b_module_uuid' in the 'Components' table': success | time=13ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100005 'Drop column 'b_module_uuid_path' in the 'Components' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100005 'Drop column 'b_module_uuid_path' in the 'Components' table': success | time=14ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100006 'Drop index 'projects_root_uuid' in the 'Components' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100006 'Drop index 'projects_root_uuid' in the 'Components' table': success | time=4ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100007 'Drop column 'root_uuid' in the 'Components' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100007 'Drop column 'root_uuid' in the 'Components' table': success | time=19ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100008 'Update value of 'user_local' in the 'users' table'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100008 'Update value of 'user_local' in the 'users' table': success | time=10ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100009 'Make column 'user_local' not nullable in the 'users' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100009 'Make column 'user_local' not nullable in the 'users' table': success | time=16ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100010 'Create 'scim_groups' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100010 'Create 'scim_groups' table': success | time=4ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100011 'Create unique index on scim_groups.group_uuid'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100011 'Create unique index on scim_groups.group_uuid': success | time=3ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100012 'Log a warning message if 'sonar.scim.enabled' is used'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100012 'Log a warning message if 'sonar.scim.enabled' is used': success | time=4ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100013 'Drop 'sonar.scim.enabled' property'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100013 'Drop 'sonar.scim.enabled' property': success | time=3ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100014 'Drop any SCIM User provisioning, turning all users local'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100014 'Drop any SCIM User provisioning, turning all users local': success | time=2ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100015 'Add ncloc to 'Projects' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100015 'Add ncloc to 'Projects' table': success | time=7ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100016 'Populate ncloc in 'Projects' table'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #100016 'Populate ncloc in 'Projects' table': success | time=8ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101000 'Add 'scm_accounts' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101000 'Add 'scm_accounts' table': success | time=4ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101001 'Migrate scm accounts from 'users' to 'scm_accounts' table'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassRowSplitter] 1 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101001 'Migrate scm accounts from 'users' to 'scm_accounts' table': success | time=13ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101002 'Add index on 'scm_accounts.scm_account''...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101002 'Add index on 'scm_accounts.scm_account'': success | time=3ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101003 'Add index on 'users.email''...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101003 'Add index on 'users.email'': success | time=4ms
2023.08.04 04:53:16 INFO  w```
```eb[][DbMigrations] #101004 'Drop 's```
``````
```cm_accounts' column in 'users' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101004 'Drop 'scm_accounts' column in 'users' table': success | time=12ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101005 'Add column 'is_main' to 'project_branches' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101005 'Add column 'is_main' to 'project_branches' table': success | time=8ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101006 'Update value of 'is_main' in 'project_branches' table'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101006 'Update value of 'is_main' in 'project_branches' table': success | time=5ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101007 'Alter column 'is_main' in 'project_branches' table - make it not nullable'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101007 'Alter column 'is_main' in 'project_branches' table - make it not nullable': success | time=5ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101008 'Increase size of 'internal_properties.kee' from 20 to 40 characters'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101008 'Increase size of 'internal_properties.kee' from 20 to 40 characters': success | time=5ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101009 'Create column 'project_uuid' in 'user_tokens'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101009 'Create column 'project_uuid' in 'user_tokens': success | time=6ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101010 'Remove user tokens linked to unexistent project'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101010 'Remove user tokens linked to unexistent project': success | time=7ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101011 'Populate 'project_key' in 'user_tokens''...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101011 'Populate 'project_key' in 'user_tokens'': success | time=7ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101012 'Drop column 'project_key' in 'user_tokens'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101012 'Drop column 'project_key' in 'user_tokens': success | time=9ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101013 'Increase size of 'ce_queue.task_type' from 15 to 40 characters'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101013 'Increase size of 'ce_queue.task_type' from 15 to 40 characters': success | time=2ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101014 'Increase size of 'ce_activity.task_type' from 15 to 40 characters'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101014 'Increase size of 'ce_activity.task_type' from 15 to 40 characters': success | time=2ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101015 'Add 'external_groups' table.'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101015 'Add 'external_groups' table.': success | time=5ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101016 'Add index on 'external_groups(external_identity_provider, external_id).'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101016 'Add index on 'external_groups(external_identity_provider, external_id).': success | time=3ms```
```
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101017 'Add 'code_variants' column in 'issues' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101017 'Add 'code_variants' column in 'issues' table': success | time=11ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101018 'Fix different uuids for subportfolios'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101018 'Fix different uuids for subportfolios': success | time=7ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101019 'Add report_schedules table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101019 'Add report_schedules table': success | time=4ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101020 'Add report_subscriptions table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101020 'Add report_subscriptions table': success | time=4ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101021 'Add report_schedules unique index'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101021 'Add report_schedules unique index': success | time=3ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101022 'Add report_subscriptions unique index'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101022 'Add report_subscriptions unique index': success | time=4ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101023 'Rename column 'component_uuid' to 'entity_uuid' in the 'properties' table'...
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101023 'Rename column 'component_uuid' to 'entity_uuid' in the 'properties' table': success | time=8ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101024 'Populate report_schedules table'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101024 'Populate report_schedules table': success | time=6ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101025 'Populate```
``` report_subscriptions table'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101025 'Populate report_subscriptions table': success | time=5ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101026 'Remove report properties'...
2023.08.04 04:53:16 INFO  web[][o.s.s.p.d.m.s.MassUpdate] 0 rows processed (0 items/sec)
2023.08.04 04:53:16 INFO  web[][DbMigrations] #101026 'Remove report properties': success | time=6ms
2023.08.04 04:53:16 INFO  web[][DbMigrations] Executed DB migrations: success | time=677ms
2023.08.04 04:53:16 INFO  web[][o.s.s.p.Platform] Database has been automatically updated
2023.08.04 04:53:16 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.platform.web.WebServiceFilter@4f5c30b1 [pattern=UrlPattern{inclusions=[/api/system/migrate_db.*, ...], exclusions=[/api/components/update_key, ...]}]
2023.08.04 04:53:16 INFO  web[][o.s.w.s.DispatcherServlet] Initializing Servlet 'app'
2023.08.04 04:53:16 INFO  web[][o.s.s.p.DetectPluginChange] Detect plugin changes
2023.08.04 04:53:17 INFO  web[][o.s.w.s.DispatcherServlet] Completed initialization in 958 ms
2023.08.04 04:53:17 INFO  web[][o.s.s.e.IndexCreator] Create index [metadatas]
2023.08.04 04:53:17 INFO  web[][o.s.s.a.EmbeddedTomcat] HTTP connector enabled on port 9000
2023.08.04 04:53:17 INFO  es[][o.e.c.m.MetadataCreateIndexService] [metadatas] creating index, cause [api], templates [], shards [1]/[0]
2023.08.04 04:53:18 INFO  es[][o.e.c.r.a.AllocationService] current.health="GREEN" message="Cluster health status changed from [YELLOW] to [GREEN] (reason: [shards started [[metadatas][0]]]).```
```" previous.health="YELLOW" reason="shards started [[metadatas][0]]"
2023.08.04 04:53:18 INFO  web[][o.s.s.e.IndexCreator] Create mapping metadatas
2023.08.04 04:53:18 INFO  es[][o.e.c.m.MetadataMappingService] [metadatas/ykmxnaO8T5W8MsyYNxUdDg] create_mapping
2023.08.04 04:53:18 INFO  web[][o.s.s.e.IndexCreator] Create index [components]
2023.08.04 04:53:18 INFO  es[][o.e.c.m.MetadataCreateIndexService] [components] creating index, cause [api], templates [], shards [5]/[0]
2023.08.04 04:53:18 INFO  es[][o.e.c.r.a.AllocationService] current.health="GREEN" message="Cluster health status changed from [YELLOW] to [GREEN] (reason: [shards started [[components][4]]])." previous.health="YELLOW" reason="shards started [[components][4]]"
2023.08.04 04:53:19 INFO  web[][o.s.s.e.IndexCreator] Create mapping components
2023.08.04 04:53:19 INFO  es[][o.e.c.m.MetadataMappingService] [components/iohHK6ekTNqmKlizcRRlXw] create_mapping
2023.08.04 04:53:19 INFO  web[][o.s.s.e.IndexCreator] Create index [projectmeasures]
2023.08.04 04:53:19 INFO  es[][o.e.c.m.MetadataCreateIndexService] [projectmeasures] creating index, cause [api], templates [], shards [5]/[0]
2023.08.04 04:53:19 INFO  es[][o.e.c.r.a.AllocationService] current.health="GREEN" message="Cluster health status changed from [YELLOW] to [GREEN] (reason: [shards started [[projectmeasures][4]]])." previous.health="YELLOW" reason="shards started [[projectmeasures][4]]"
2023.08.04 04:53:19 INFO  web[][o.s.s.e.IndexCreator] Create mapping projectmeasures
2023.08.04 04:53:19 INFO  es[][o.e.c.m.MetadataMappingService] [projectmeasures/FNaOkqcyTR6FmSA33WB77g] create_mapping
2023.08.04 04:53:19 INFO  web[][o.s.s.e.IndexCreator] Create index [rules]
2023.08.04 04:53:19 INFO  es[][o.e.c.m.MetadataCreateIndexService] [rules] creating index, cause [api], templates [], shards [2]/[0]
2023.08.04 04:53:19 INFO  es[][o.e.c.r.a.AllocationService] curr```
``````
``````
```ent.health="GREEN" message="Cluster health status changed from [YELLOW] to [GREEN] (reason: [shards started [[rules][0]]])." previous.health="YELLOW" reason="shards started [[rules][0]]"
2023.08.04 04:53:19 INFO  web[][o.s.s.e.IndexCreator] Create mapping rules
2023.08.04 04:53:19 INFO  es[][o.e.c.m.MetadataMappingService] [rules/q5ef-pv1S82bju1NXVE_9A] create_mapping
2023.08.04 04:53:19 INFO  web[][o.s.s.e.IndexCreator] Create index [issues]
2023.08.04 04:53:20 INFO  es[][o.e.c.m.MetadataCreateIndexService] [issues] creating index, cause [api], templates [], shards [5]/[0]
2023.08.04 04:53:20 INFO  es[][o.e.c.r.a.AllocationService] current.health="GREEN" message="Cluster health status changed from [YELLOW] to [GREEN] (reason: [shards started [[issues][4]]])." previous.health="YELLOW" reason="shards started [[issues][4]]"
2023.08.04 04:53:20 INFO  web[][o.s.s.e.IndexCreator] Create mapping issues
2023.08.04 04:53:20 INFO  es[][o.e.c.m.MetadataMappingService] [issues/FMXjDO1FTSKbo5YTfguW-Q] create_mapping
2023.08.04 04:53:20 INFO  web[][o.s.s.e.IndexCreator] Create index [views]
2023.08.04 04:53:20 INFO  es[][o.e.c.m.MetadataCreateIndexService] [views] creating index, cause [api], templates [], shards [5]/[0]
2023.08.04 04:53:20 INFO  es[][o.e.c.r.a.AllocationService] current.health="GREEN" message="Cluster health status changed from [YELLOW] to [GREEN] (reason: [shards started [[views][4]]])." previous.health="YELLOW" reason="shards started [[views][4]]"
2023.08.04 04:53:20 INFO  web[][o.s.s.e.IndexCreator] Create mapping views
2023.08.04 04:53:20 INFO  es[][o.e.c.m.MetadataMappingService] [views/VlTML3pgQaCgRI5gzW5AsA] create_mapping
2023.08.04 04:53:20 INFO  web[][o.s.s.s.LogServerId] Server ID: 147B411E-AYm-5I1ZkqorrBOFQST-
2023.08.04 04:53:20 WARN  web[][o.s.s.a.LogOAuthWarning] For security reasons, OAuth authentication should use HTTPS. You should set the property 'Administration > Configuration > Server base URL' to a HTTPS URL.
2023.08.04 04:53:20 INFO  web[][o.s.s.p.UpdateCenterClient] Update center: https://update.sonarsource.org/update-center.properties
2023.08.04 04:53:21 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action saml/validation_init
2023.08.04 04:53:21 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/system/liveness
2023.08.04 04:53:21 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/plugins/download
2023.08.04 04:53:21 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/analysis_cache/get
2023.08.04 04:53:21 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/alm_integrations/check_pat
2023.08.04 04:53:21 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/push/sonarlint_events
2023.08.04 04:53:21 WARN  web[][o.s.a.s.w.WebService$Action] Since is not set on action api/cayc/issues_creation_histogram
2023.08.04 04:53:21 WARN  web[][o.s.a.s.w.WebService$Action] The response example is not set on action api/cayc/issues_creation_histogram
```
``````
``````
```2023.08.04 04:53:21 INFO  web[][o.s.s.a.p.ExpiredSessionsCleaner] Purge of expired session tokens has removed 0 elements
2023.08.04 04:53:21 INFO  web[][o.s.s.a.p.ExpiredSessionsCleaner] Purge of expired SAML message ids has removed 0 elements
2023.08.04 04:53:21 INFO  web[][o.s.s.n.NotificationDaemon] Notification service started (delay 60 sec.)
2023.08.04 04:53:21 INFO  web[][o.s.s.t.TelemetryDaemon] Sharing of SonarQube statistics is enabled.
2023.08.04 04:53:21 INFO  web[][o.s.w.s.DispatcherServlet] Initializing Servlet 'app'
2023.08.04 04:53:22 INFO  web[][o.s.w.s.DispatcherServlet] Completed initialization in 224 ms
2023.08.04 04:53:22 INFO  web[][o.s.s.s.GeneratePluginIndex] Generate scanner plugin index
2023.08.04 04:53:22 INFO  web[][o.s.s.s.RegisterMetrics] Register metrics
2023.08.04 04:53:22 INFO  web[][o.s.s.q.RegisterQualityGates] Built-in quality gate's conditions of [Sonar way] has been updated
2023.08.04 04:53:22 INFO  web[][o.s.s.r.RegisterRules] Register rules
2023.08.04 04:53:54 INFO  web[][o.s.s.q.b.BuiltInQProfileRepositoryImpl] Load quality profiles
2023.08.04 04:53:54 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register quality profiles
2023.08.04 04:53:54 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile kubernetes/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile css/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile scala/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile jsp/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile go/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile kotlin/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile js/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile py/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile secrets/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile ruby/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile docker/Sonar way
2023.08.04 04:53:55 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile cs/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile java/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile web/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile flex/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile xml/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile json/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile php/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile terraform/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile text/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles]```
``` Register profile vbnet/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile cloudformation/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile yaml/Sonar way
2023.08.04 04:53:56 INFO  web[][o.s.s.q.RegisterQualityProfiles] Register profile ts/Sonar way
2023.08.04 04:53:57 INFO  web[][o.s.s.s.RegisterPermissionTemplates] Register permission templates
2023.08.04 04:53:57 INFO  web[][o.s.s.s.RenameDeprecatedPropertyKeys] Rename deprecated property keys
2023.08.04 04:53:57 INFO  web[][o.s.s.s.RegisterPlugins] Register plugins
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.platform.web.SonarLintConnectionFilter@1806fe33 [pattern=UrlPattern{inclusions=[/api/*], exclusions=[/api/v2/*]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.platform.web.WebServiceFilter@651185f7 [pattern=UrlPattern{inclusions=[/api/issues/delete_comment.*, ...], exclusions=[/api/authentication/login.*, ...]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.platform.web.WebServiceReroutingFilter@26534670 [pattern=UrlPattern{inclusions=[/api/components/bulk_update_key, ...], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.DefaultAdminCredentialsVerifierFilter@23166841 [pattern=UrlPattern{inclusions=[/*], exclusions=[*.css, ...]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.InitFilter@c4eed76 [pattern=UrlPattern{inclusions=[/sessions/init/*], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.SamlValidationRedirectionFilter@6519ef35 [pattern=UrlPattern{inclusions=[/oauth2/callback/saml], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.OAuth2CallbackFilter@59c54520 [pattern=UrlPattern{inclusions=[/oauth2/callback/*], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.ResetPasswordFilter@49816a39 [pattern=UrlPattern{inclusions=[/*], exclusions=[*.css, ...]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.ws.LoginAction@4e43bd3b [pattern=UrlPattern{inclusions=[/api/authentication/login], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.ws.LogoutAction@1f777c82 [pattern=UrlPattern{inclusions=[/api/authentication/logout], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.authentication.ws.ValidateAction@3b638651 [pattern=UrlPattern{inclusions=[/api/authentication/validate], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.saml.ws.ValidationInitAction@4db5a04f [pattern=UrlPattern{inclusions=[/saml/validation_init], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.saml.ws.ValidationAction@fc01235 [pattern=UrlPattern{inclusions=[/saml/validation], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.user.ws.ChangePasswordAction@32df0b22 [pattern=UrlPattern{inclusions=[/api/users/change_password], exclusions=[]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.p.w.MasterServletFilter] Initializing servlet filter org.sonar.server.plugins.PluginsRiskConsentFilter@18153a0b [pattern=UrlPattern{inclusions=[/*], exclusions=[*.css, ...]}]
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Indexing of type [projectmeasures/auth/projectmeasure]...
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Indexing of type [projectmeasures/auth/projectmeasure] done | time=140ms
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Indexing of type [components/auth/component]...
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Indexing of type [components/auth/component] done | time=92ms
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Indexing of type [views/view]...
2023.08.04 04:53:57 INFO  es[][o.e.c.s.IndexScopedSettings] updating [index.refresh_interval] from [30s] to [-1]
2023.08.04 04:53:57 INFO  es[][o.e.c.s.IndexScopedSettings] updating [index.refresh_interval] from [30s] to [-1]
2023.08.04 04:53:57 INFO  es[][o.e.c.s.IndexScopedSettings] updating [index.refresh_interval] from [-1] to [30s]
2023.08.04 04:53:57 INFO  es[][o.e.c.s.IndexScopedSettings] updating [index.refresh_interval] from [-1] to [30s]
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Indexing of type [views/view] done | time=184ms
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Trigger asynchronous indexing of type [issues/auth/issue]...
2023.08.04 04:53:57 INFO  web[][o.s.s.i.i.AsyncIssueIndexingImpl] 0 pending indexation task found to be deleted...
2023.08.04 04:53:57 INFO  web[][o.s.s.i.i.AsyncIssueIndexingImpl] 0 completed indexation task found to be deleted...
2023.08.04 04:53:57 INFO  web[][o.s.s.i.i.AsyncIssueIndexingImpl] Indexation task deletion complete.
2023.08.04 04:53:57 INFO  web[][o.s.s.i.i.AsyncIssueIndexingImpl] Deleting tasks characteristics...
2023.08.04 04:53:57 INFO  web[][o.s.s.i.i.AsyncIssueIndexingImpl] Tasks characteristics deletion complete.
2023.08.04 04:53:57 INFO  web[][o.s.s.i.i.AsyncIssueIndexingImpl] 0 branch found in need of issue sync.
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Trigger asynchronous indexing of type [issues/auth/issue] done | time=48ms
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Inde```
``````
```xing of types [components/auth],[projectmeasures/auth],[issues/auth]...
2023.08.04 04:53:57 INFO  web[][o.s.s.e.IndexerStartupTask] Indexing of types [components/auth],[projectmeasures/auth],[issues/auth] done | time=100ms
2023.08.04 04:53:57 INFO  web[][o.s.s.q.ProjectsInWarningDaemon] Counting number of projects in warning is enabled.
2023.08.04 04:53:57 INFO  web[][o.s.s.p.p.PlatformLevelStartup] Running Community Edition
2023.08.04 04:53:58 INFO  web[][o.s.s.q.ProjectsInWarningDaemon] Counting number of projects in warning will be disabled as there are no more projects in warning.
2023.08.04 04:53:58 INFO  app[][o.s.a.SchedulerImpl] Process[web] is up
2023.08.04 04:53:58 INFO  app[][o.s.a.ProcessLauncherImpl] Launch process[COMPUTE_ENGINE] from [/opt/sonarqube]: /opt/java/openjdk/bin/java -Djava.awt.headless=true -Dfile.encoding=UTF-8 -Djava.io.tmpdir=/opt/sonarqube/temp -XX:-OmitStackTraceInFastThrow --add-opens=java.base/java.util=ALL-UNNAMED --add-exports=java.base/jdk.internal.ref=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED --add-opens=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.management/sun.management=ALL-UNNAMED --add-opens=jdk.management/com.sun.management.internal=ALL-UNNAMED -Dcom.redhat.fips=false -Xmx512m -Xms128m -XX:+HeapDumpOnOutOfMemoryError -Dhttp.nonProxyHosts=localhost|127.*|[::1] -cp ./lib/sonar-application-10.1.0.73491.jar:/opt/sonarqube/lib/jdbc/h2/h2-2.1.214.jar org.sonar.ce.app.CeServer /opt/sonarqube/temp/sq-process12151138223240111599properties
2023.08.04 04:53:58 WARN  app[][startup] ####################################################################################################################
2023.08.04 04:53:58 WARN  app[][startup] Default Administrator credentials are still being used. Make sure to change the password or deactivate the account.
2023.08.04 04:53:58 WARN  app[][startup] ####################################################################################################################
2023.08.04 04:53:58 INFO  web[][o.s.s.p.Platform] Web Server is operational
WARNING: A terminally deprecated method in java.lang.System has been called
WARNING: System::setSecurityManager has been called by org.sonar.process.PluginSecurityManager (file:/opt/sonarqube/lib/sonar-application-10.1.0.73491.jar)
WARNING: Please consider reporting this to the maintainers of org.sonar.process.PluginSecurityManager
WARNING: System::setSecurityManager will be removed in a future release
2023.08.04 04:53:58 INFO  ce[][o.s.p.ProcessEntryPoint] Starting Compute Engine
2023.08.04 04:53:58 INFO  ce[][o.s.ce.app.CeServer] Compute Engine starting up...
2023.08.04 04:53:59 INFO  ce[][o.s.d.DefaultDatabase] Create JDBC data source for jdbc:h2:tcp://127.0.0.1:9092/sonar;NON_KEYWORDS=VALUE
2023.08.04 04:53:59 INFO  ce[][c.z.h.HikariDataSource] HikariPool-1 - Starting...
2023.08.04 04:53:59 INFO  ce[][c.z.h.p.HikariPool] HikariPool-1 - Added connection conn0: url=jdbc:h2:tcp://127.0.0.1:9092/sonar user=
2023.08.04 04:53:59 INFO  ce[][c.z.h.HikariDataSource] HikariPool-1 - Start completed.
2023.08.04 04:53:59 WARN  ce[][o.s.db.dialect.H2] H2 database should be used for evaluation purpose only.
2023.08.04 04:53:59 INFO  ce[][o.s.s.p.ServerFileSystemImpl] SonarQube home: /opt/sonarqube
2023.08.04 04:54:00 INFO  ce[][o.s.c.c.CePluginRepository] Load plugins
2023.08.04 04:54:00 INFO  ce[][o.s.c.c.ComputeEngineContainerImpl] Running Community edition
2023.08.04 04:54:00 INFO  ce[][o.s.ce.app.CeServer] Compute Engine is started
2023.08.04 04:54:01 INFO  app[][o.s.a.SchedulerImpl] Process[ce] is up
2023.08.04 04:54:01 INFO  app[][o.s.a.SchedulerImpl] SonarQube is operational
</pre>

You can start accessing SonarQube Dashboard at the below URL
<pre>
http://localhost:9000  
</pre>

Default login credentials will be
<pre>
username - admin
password - admin
</pre>

When prompted to change password, you may change this to
<pre>
username - admin
password - Admin@123
</pre>


## Lab - Ansible Windows 2019 Server node

From the Windows 2019 Server Powershell we need to execute the below Powershell script
```
#Requires -Version 3.0

# Configure a Windows host for remote management with Ansible
# -----------------------------------------------------------
#
# This script checks the current WinRM (PS Remoting) configuration and makes
# the necessary changes to allow Ansible to connect, authenticate and
# execute PowerShell commands.
#
# IMPORTANT: This script uses self-signed certificates and authentication mechanisms
# that are intended for development environments and evaluation purposes only.
# Production environments and deployments that are exposed on the network should
# use CA-signed certificates and secure authentication mechanisms such as Kerberos.
#
# To run this script in Powershell:
#
# [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
# $url = "https://raw.githubusercontent.com/ansible/ansible/devel/examples/scripts/ConfigureRemotingForAnsible.ps1"
# $file = "$env:temp\ConfigureRemotingForAnsible.ps1"
#
# (New-Object -TypeName System.Net.WebClient).DownloadFile($url, $file)
#
# powershell.exe -ExecutionPolicy ByPass -File $file
#
# All events are logged to the Windows EventLog, useful for unattended runs.
#
# Use option -Verbose in order to see the verbose output messages.
#
# Use option -CertValidityDays to specify how long this certificate is valid
# starting from today. So you would specify -CertValidityDays 3650 to get
# a 10-year valid certificate.
#
# Use option -ForceNewSSLCert if the system has been SysPreped and a new
# SSL Certificate must be forced on the WinRM Listener when re-running this
# script. This is necessary when a new SID and CN name is created.
#
# Use option -EnableCredSSP to enable CredSSP as an authentication option.
#
# Use option -DisableBasicAuth to disable basic authentication.
#
# Use option -SkipNetworkProfileCheck to skip the network profile check.
# Without specifying this the script will only run if the device's interfaces
# are in DOMAIN or PRIVATE zones.  Provide this switch if you want to enable
# WinRM on a device with an interface in PUBLIC zone.
#
# Use option -SubjectName to specify the CN name of the certificate. This
# defaults to the system's hostname and generally should not be specified.

# Written by Trond Hindenes <trond@hindenes.com>
# Updated by Chris Church <cchurch@ansible.com>
# Updated by Michael Crilly <mike@autologic.cm>
# Updated by Anton Ouzounov <Anton.Ouzounov@careerbuilder.com>
# Updated by Nicolas Simond <contact@nicolas-simond.com>
# Updated by Dag Wieërs <dag@wieers.com>
# Updated by Jordan Borean <jborean93@gmail.com>
# Updated by Erwan Quélin <erwan.quelin@gmail.com>
# Updated by David Norman <david@dkn.email>
#
# Version 1.0 - 2014-07-06
# Version 1.1 - 2014-11-11
# Version 1.2 - 2015-05-15
# Version 1.3 - 2016-04-04
# Version 1.4 - 2017-01-05
# Version 1.5 - 2017-02-09
# Version 1.6 - 2017-04-18
# Version 1.7 - 2017-11-23
# Version 1.8 - 2018-02-23
# Version 1.9 - 2018-09-21

# Support -Verbose option
[CmdletBinding()]

Param (
    [string]$SubjectName = $env:COMPUTERNAME,
    [int]$CertValidityDays = 1095,
    [switch]$SkipNetworkProfileCheck,
    $CreateSelfSignedCert = $true,
    [switch]$ForceNewSSLCert,
    [switch]$GlobalHttpFirewallAccess,
    [switch]$DisableBasicAuth = $false,
    [switch]$EnableCredSSP
)

Function Write-ProgressLog {
    $Message = $args[0]
    Write-EventLog -LogName Application -Source $EventSource -EntryType Information -EventId 1 -Message $Message
}

Function Write-VerboseLog {
    $Message = $args[0]
    Write-Verbose $Message
    Write-ProgressLog $Message
}

Function Write-HostLog {
    $Message = $args[0]
    Write-Output $Message
    Write-ProgressLog $Message
}

Function New-LegacySelfSignedCert {
    Param (
        [string]$SubjectName,
        [int]$ValidDays = 1095
    )

    $hostnonFQDN = $env:computerName
    $hostFQDN = [System.Net.Dns]::GetHostByName(($env:computerName)).Hostname
    $SignatureAlgorithm = "SHA256"

    $name = New-Object -COM "X509Enrollment.CX500DistinguishedName.1"
    $name.Encode("CN=$SubjectName", 0)

    $key = New-Object -COM "X509Enrollment.CX509PrivateKey.1"
    $key.ProviderName = "Microsoft Enhanced RSA and AES Cryptographic Provider"
    $key.KeySpec = 1
    $key.Length = 4096
    $key.SecurityDescriptor = "D:PAI(A;;0xd01f01ff;;;SY)(A;;0xd01f01ff;;;BA)(A;;0x80120089;;;NS)"
    $key.MachineContext = 1
    $key.Create()

    $serverauthoid = New-Object -COM "X509Enrollment.CObjectId.1"
    $serverauthoid.InitializeFromValue("1.3.6.1.5.5.7.3.1")
    $ekuoids = New-Object -COM "X509Enrollment.CObjectIds.1"
    $ekuoids.Add($serverauthoid)
    $ekuext = New-Object -COM "X509Enrollment.CX509ExtensionEnhancedKeyUsage.1"
    $ekuext.InitializeEncode($ekuoids)

    $cert = New-Object -COM "X509Enrollment.CX509CertificateRequestCertificate.1"
    $cert.InitializeFromPrivateKey(2, $key, "")
    $cert.Subject = $name
    $cert.Issuer = $cert.Subject
    $cert.NotBefore = (Get-Date).AddDays(-1)
    $cert.NotAfter = $cert.NotBefore.AddDays($ValidDays)

    $SigOID = New-Object -ComObject X509Enrollment.CObjectId
    $SigOID.InitializeFromValue(([Security.Cryptography.Oid]$SignatureAlgorithm).Value)

    [string[]] $AlternativeName += $hostnonFQDN
    $AlternativeName += $hostFQDN
    $IAlternativeNames = New-Object -ComObject X509Enrollment.CAlternativeNames

    foreach ($AN in $AlternativeName) {
        $AltName = New-Object -ComObject X509Enrollment.CAlternativeName
        $AltName.InitializeFromString(0x3, $AN)
        $IAlternativeNames.Add($AltName)
    }

    $SubjectAlternativeName = New-Object -ComObject X509Enrollment.CX509ExtensionAlternativeNames
    $SubjectAlternativeName.InitializeEncode($IAlternativeNames)

    [String[]]$KeyUsage = ("DigitalSignature", "KeyEncipherment")
    $KeyUsageObj = New-Object -ComObject X509Enrollment.CX509ExtensionKeyUsage
    $KeyUsageObj.InitializeEncode([int][Security.Cryptography.X509Certificates.X509KeyUsageFlags]($KeyUsage))
    $KeyUsageObj.Critical = $true

    $cert.X509Extensions.Add($KeyUsageObj)
    $cert.X509Extensions.Add($ekuext)
    $cert.SignatureInformation.HashAlgorithm = $SigOID
    $CERT.X509Extensions.Add($SubjectAlternativeName)
    $cert.Encode()

    $enrollment = New-Object -COM "X509Enrollment.CX509Enrollment.1"
    $enrollment.InitializeFromRequest($cert)
    $certdata = $enrollment.CreateRequest(0)
    $enrollment.InstallResponse(2, $certdata, 0, "")

    # extract/return the thumbprint from the generated cert
    $parsed_cert = New-Object System.Security.Cryptography.X509Certificates.X509Certificate2
    $parsed_cert.Import([System.Text.Encoding]::UTF8.GetBytes($certdata))

    return $parsed_cert.Thumbprint
}

Function Enable-GlobalHttpFirewallAccess {
    Write-Verbose "Forcing global HTTP firewall access"
    # this is a fairly naive implementation; could be more sophisticated about rule matching/collapsing
    $fw = New-Object -ComObject HNetCfg.FWPolicy2

    # try to find/enable the default rule first
    $add_rule = $false
    $matching_rules = $fw.Rules | Where-Object { $_.Name -eq "Windows Remote Management (HTTP-In)" }
    $rule = $null
    If ($matching_rules) {
        If ($matching_rules -isnot [Array]) {
            Write-Verbose "Editing existing single HTTP firewall rule"
            $rule = $matching_rules
        }
        Else {
            # try to find one with the All or Public profile first
            Write-Verbose "Found multiple existing HTTP firewall rules..."
            $rule = $matching_rules | ForEach-Object { $_.Profiles -band 4 }[0]

            If (-not $rule -or $rule -is [Array]) {
                Write-Verbose "Editing an arbitrary single HTTP firewall rule (multiple existed)"
                # oh well, just pick the first one
                $rule = $matching_rules[0]
            }
        }
    }

    If (-not $rule) {
        Write-Verbose "Creating a new HTTP firewall rule"
        $rule = New-Object -ComObject HNetCfg.FWRule
        $rule.Name = "Windows Remote Management (HTTP-In)"
        $rule.Description = "Inbound rule for Windows Remote Management via WS-Management. [TCP 5985]"
        $add_rule = $true
    }

    $rule.Profiles = 0x7FFFFFFF
    $rule.Protocol = 6
    $rule.LocalPorts = 5985
    $rule.RemotePorts = "*"
    $rule.LocalAddresses = "*"
    $rule.RemoteAddresses = "*"
    $rule.Enabled = $true
    $rule.Direction = 1
    $rule.Action = 1
    $rule.Grouping = "Windows Remote Management"

    If ($add_rule) {
        $fw.Rules.Add($rule)
    }

    Write-Verbose "HTTP firewall rule $($rule.Name) updated"
}

# Setup error handling.
Trap {
    $_
    Exit 1
}
$ErrorActionPreference = "Stop"

# Get the ID and security principal of the current user account
$myWindowsID = [System.Security.Principal.WindowsIdentity]::GetCurrent()
$myWindowsPrincipal = new-object System.Security.Principal.WindowsPrincipal($myWindowsID)

# Get the security principal for the Administrator role
$adminRole = [System.Security.Principal.WindowsBuiltInRole]::Administrator

# Check to see if we are currently running "as Administrator"
if (-Not $myWindowsPrincipal.IsInRole($adminRole)) {
    Write-Output "ERROR: You need elevated Administrator privileges in order to run this script."
    Write-Output "       Start Windows PowerShell by using the Run as Administrator option."
    Exit 2
}

$EventSource = $MyInvocation.MyCommand.Name
If (-Not $EventSource) {
    $EventSource = "Powershell CLI"
}

If ([System.Diagnostics.EventLog]::Exists('Application') -eq $False -or [System.Diagnostics.EventLog]::SourceExists($EventSource) -eq $False) {
    New-EventLog -LogName Application -Source $EventSource
}

# Detect PowerShell version.
If ($PSVersionTable.PSVersion.Major -lt 3) {
    Write-ProgressLog "PowerShell version 3 or higher is required."
    Throw "PowerShell version 3 or higher is required."
}

# Find and start the WinRM service.
Write-Verbose "Verifying WinRM service."
If (!(Get-Service "WinRM")) {
    Write-ProgressLog "Unable to find the WinRM service."
    Throw "Unable to find the WinRM service."
}
ElseIf ((Get-Service "WinRM").Status -ne "Running") {
    Write-Verbose "Setting WinRM service to start automatically on boot."
    Set-Service -Name "WinRM" -StartupType Automatic
    Write-ProgressLog "Set WinRM service to start automatically on boot."
    Write-Verbose "Starting WinRM service."
    Start-Service -Name "WinRM" -ErrorAction Stop
    Write-ProgressLog "Started WinRM service."

}

# WinRM should be running; check that we have a PS session config.
If (!(Get-PSSessionConfiguration -Verbose:$false) -or (!(Get-ChildItem WSMan:\localhost\Listener))) {
    If ($SkipNetworkProfileCheck) {
        Write-Verbose "Enabling PS Remoting without checking Network profile."
        Enable-PSRemoting -SkipNetworkProfileCheck -Force -ErrorAction Stop
        Write-ProgressLog "Enabled PS Remoting without checking Network profile."
    }
    Else {
        Write-Verbose "Enabling PS Remoting."
        Enable-PSRemoting -Force -ErrorAction Stop
        Write-ProgressLog "Enabled PS Remoting."
    }
}
Else {
    Write-Verbose "PS Remoting is already enabled."
}

# Ensure LocalAccountTokenFilterPolicy is set to 1
# https://github.com/ansible/ansible/issues/42978
$token_path = "HKLM:\SOFTWARE\Microsoft\Windows\CurrentVersion\Policies\System"
$token_prop_name = "LocalAccountTokenFilterPolicy"
$token_key = Get-Item -Path $token_path
$token_value = $token_key.GetValue($token_prop_name, $null)
if ($token_value -ne 1) {
    Write-Verbose "Setting LocalAccountTOkenFilterPolicy to 1"
    if ($null -ne $token_value) {
        Remove-ItemProperty -Path $token_path -Name $token_prop_name
    }
    New-ItemProperty -Path $token_path -Name $token_prop_name -Value 1 -PropertyType DWORD > $null
}

# Make sure there is a SSL listener.
$listeners = Get-ChildItem WSMan:\localhost\Listener
If (!($listeners | Where-Object { $_.Keys -like "TRANSPORT=HTTPS" })) {
    # We cannot use New-SelfSignedCertificate on 2012R2 and earlier
    $thumbprint = New-LegacySelfSignedCert -SubjectName $SubjectName -ValidDays $CertValidityDays
    Write-HostLog "Self-signed SSL certificate generated; thumbprint: $thumbprint"

    # Create the hashtables of settings to be used.
    $valueset = @{
        Hostname = $SubjectName
        CertificateThumbprint = $thumbprint
    }

    $selectorset = @{
        Transport = "HTTPS"
        Address = "*"
    }

    Write-Verbose "Enabling SSL listener."
    New-WSManInstance -ResourceURI 'winrm/config/Listener' -SelectorSet $selectorset -ValueSet $valueset
    Write-ProgressLog "Enabled SSL listener."
}
Else {
    Write-Verbose "SSL listener is already active."

    # Force a new SSL cert on Listener if the $ForceNewSSLCert
    If ($ForceNewSSLCert) {

        # We cannot use New-SelfSignedCertificate on 2012R2 and earlier
        $thumbprint = New-LegacySelfSignedCert -SubjectName $SubjectName -ValidDays $CertValidityDays
        Write-HostLog "Self-signed SSL certificate generated; thumbprint: $thumbprint"

        $valueset = @{
            CertificateThumbprint = $thumbprint
            Hostname = $SubjectName
        }

        # Delete the listener for SSL
        $selectorset = @{
            Address = "*"
            Transport = "HTTPS"
        }
        Remove-WSManInstance -ResourceURI 'winrm/config/Listener' -SelectorSet $selectorset

        # Add new Listener with new SSL cert
        New-WSManInstance -ResourceURI 'winrm/config/Listener' -SelectorSet $selectorset -ValueSet $valueset
    }
}

# Check for basic authentication.
$basicAuthSetting = Get-ChildItem WSMan:\localhost\Service\Auth | Where-Object { $_.Name -eq "Basic" }

If ($DisableBasicAuth) {
    If (($basicAuthSetting.Value) -eq $true) {
        Write-Verbose "Disabling basic auth support."
        Set-Item -Path "WSMan:\localhost\Service\Auth\Basic" -Value $false
        Write-ProgressLog "Disabled basic auth support."
    }
    Else {
        Write-Verbose "Basic auth is already disabled."
    }
}
Else {
    If (($basicAuthSetting.Value) -eq $false) {
        Write-Verbose "Enabling basic auth support."
        Set-Item -Path "WSMan:\localhost\Service\Auth\Basic" -Value $true
        Write-ProgressLog "Enabled basic auth support."
    }
    Else {
        Write-Verbose "Basic auth is already enabled."
    }
}

# If EnableCredSSP if set to true
If ($EnableCredSSP) {
    # Check for CredSSP authentication
    $credsspAuthSetting = Get-ChildItem WSMan:\localhost\Service\Auth | Where-Object { $_.Name -eq "CredSSP" }
    If (($credsspAuthSetting.Value) -eq $false) {
        Write-Verbose "Enabling CredSSP auth support."
        Enable-WSManCredSSP -role server -Force
        Write-ProgressLog "Enabled CredSSP auth support."
    }
}

If ($GlobalHttpFirewallAccess) {
    Enable-GlobalHttpFirewallAccess
}

# Configure firewall to allow WinRM HTTPS connections.
$fwtest1 = netsh advfirewall firewall show rule name="Allow WinRM HTTPS"
$fwtest2 = netsh advfirewall firewall show rule name="Allow WinRM HTTPS" profile=any
If ($fwtest1.count -lt 5) {
    Write-Verbose "Adding firewall rule to allow WinRM HTTPS."
    netsh advfirewall firewall add rule profile=any name="Allow WinRM HTTPS" dir=in localport=5986 protocol=TCP action=allow
    Write-ProgressLog "Added firewall rule to allow WinRM HTTPS."
}
ElseIf (($fwtest1.count -ge 5) -and ($fwtest2.count -lt 5)) {
    Write-Verbose "Updating firewall rule to allow WinRM HTTPS for any profile."
    netsh advfirewall firewall set rule name="Allow WinRM HTTPS" new profile=any
    Write-ProgressLog "Updated firewall rule to allow WinRM HTTPS for any profile."
}
Else {
    Write-Verbose "Firewall rule already exists to allow WinRM HTTPS."
}

# Test a remoting connection to localhost, which should work.
$httpResult = Invoke-Command -ComputerName "localhost" -ScriptBlock { $using:env:COMPUTERNAME } -ErrorVariable httpError -ErrorAction SilentlyContinue
$httpsOptions = New-PSSessionOption -SkipCACheck -SkipCNCheck -SkipRevocationCheck

$httpsResult = New-PSSession -UseSSL -ComputerName "localhost" -SessionOption $httpsOptions -ErrorVariable httpsError -ErrorAction SilentlyContinue

If ($httpResult -and $httpsResult) {
    Write-Verbose "HTTP: Enabled | HTTPS: Enabled"
}
ElseIf ($httpsResult -and !$httpResult) {
    Write-Verbose "HTTP: Disabled | HTTPS: Enabled"
}
ElseIf ($httpResult -and !$httpsResult) {
    Write-Verbose "HTTP: Enabled | HTTPS: Disabled"
}
Else {
    Write-ProgressLog "Unable to establish an HTTP or HTTPS remoting session."
    Throw "Unable to establish an HTTP or HTTPS remoting session."
}
Write-VerboseLog "PS Remoting has been successfully configured for Ansible."
```

Followed by list the winrm services 
```
winrm enumerate winrm/config/Listener
```

Now on the ansible controller machine, we need to install 
```
pip install "pywinrm>=0.3.0"
or
pip3 install "pywinrm>=0.3.0"
```

## Creating a docker container on your RPS Lab machine to ping the windows ansible node
First you need to create a Dockerfile with the below content
```
FROM ubuntu:22.04
RUN apt update && apt install -y python3 ansible vim git
```
You need to build an custom docker image with the above Dockerfile
```
docker build -t tektutor/ansible:latest .
docker images
```

You need to create a container using your custom ansible docker image
```
docker run -dit --name ansible --hostname ansible tektutor/ansible:latest bash
docker exec -it ansible bash
```

On the container, you can create an inventory with the below content
```
[windows]
172.20.0.192

[windows:vars]
ansible_user=Administrator
ansible_password=rps@12345
ansible_connection=winrm
ansible_winrm_server_cert_validation=ignore
```

## Ping windows node from your Ansible Controller machine
```
docker exec -it ansible bash
ansible -i inventory all -m win_ping
```

Expected output
![image](https://github.com/tektutor/devops-aug-2023/assets/12674043/175e5e33-f130-4b97-92d7-74c64566aed0)


## Copying a file from Ansible controller machine to Windows Ansible node using Ansible Playbook
```
docker exec -it ansible bash
git clone https://github.com/tektutor/devops-aug-2023.git
cd devops-aug-2023/Day5/windows-ansible-node
ansible-playbook -i inventory all copy-file-playbook.yml
```

Expected output
![image](https://github.com/tektutor/devops-aug-2023/assets/12674043/54951146-70d0-45fa-a52d-64ed83f49ef1)

## Installing Apache MSI 
```
docker exec -it ansible bash
cd devops-aug-2023
git pull
cd Day5/windows-ansible-node
ansible-playbook -i inventory all install-apache-msi-playbook.yml
```

Expected output
![image](https://github.com/tektutor/devops-aug-2023/assets/12674043/dd14e1d6-f7b9-4725-a98c-ff1901f1419b)


## Post Test URL
<pre>
https://app.mymapit.in/code4/tiny/dRdEYk  
</pre>

## Kindly give your training feedback at the below URL
<pre>
https://tcheck.co/HzQlr7
</pre>
