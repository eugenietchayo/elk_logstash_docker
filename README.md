# soumission_mvn

# https://localhost:8082/insurance

First, build the application using this command:
mvn install

Then, create the images of the application:
docker build -t springboot-app .

Lastly, lauch all the apps using this command:
docker-compose up

---
Once the application has started, navigate to these URLs:
http://localhost:9200/   ---> Elastic search
http://localhost:5601/  --> Kibana
http://localhost:9600/   --> Logstash
http://localhost:8081/loggerinfo   --> Sprint boot app