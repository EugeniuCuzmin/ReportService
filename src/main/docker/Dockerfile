FROM java:8
ADD report.jar report.jar
ADD krb5.conf /etc/krb5.conf
ADD evkuzmin.keytab /etc/evkuzmin.keytab
RUN sh -c 'touch report.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://audpro_mongo/report","-Djavax.net.debug=all","-Dsun.security.spnego.debug=true","-Dsun.security.krb5.debug=true","-Djava.security.krb5.conf=/etc/krb5.conf","-Djava.security.egd=file:/dev/./urandom","-jar","/report.jar"]