FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/duct.module.pedestal-0.0.1-SNAPSHOT-standalone.jar /duct.module.pedestal/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/duct.module.pedestal/app.jar"]
