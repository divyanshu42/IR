../apache-tomcat-7.0.69/bin/catalina.sh stop
rm ../apache-tomcat-7.0.69/webapps/nutch-0.9.war
rm -r ../apache-tomcat-7.0.69/webapps/nutch-0.9
export JAVA_HOME=/usr/lib/jvm/java-8-oracle/
ant
ant war
cp build/nutch-0.9.war ../apache-tomcat-7.0.69/webapps/
../apache-tomcat-7.0.69/bin/catalina.sh start
