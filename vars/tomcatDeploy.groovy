def call(tomcatIp,warFileName,tomcatUser,credId){
  sshagent([credId]) {
    sh "scp target/${warFileName} ${tomcatUser}@${tomcatIp}:/opt/tomcat9/webapps/"
    sh "ssh ${tomcatUser}@${tomcatIp} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ${tomcatUser}@${tomcatIp} /opt/tomcat9/bin/startup.sh"
  }
}
