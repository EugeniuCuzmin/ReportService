FROM java:8
#RUN cd /opt && ls
ADD audience_profile.jar audience_profile.jar
RUN sh -c 'touch audience_profile.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://audpro_mongo/audience_profile","-Djava.security.egd=file:/dev/./urandom","-jar","/audience_profile.jar"]