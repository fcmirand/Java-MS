# Java-MS
Custom JAVA MS 

Creating a custom microservice using JAVA

Build Chart and Image

docker build -t pulsar-service:1.0.0 .
docker tag pulsar-service:1.0.0 <your-registry>/pulsar-service:1.0.0
docker push <your-registry>/pulsarservice:1.0.0

--Packege chart--
helm package .

--Save img--
docker save -o pulsar-service-1.0.0.img <your-registry>/pulsar-service:v1.0.0

helm install pulsar-service ./pulsar-service-0.1.0.tgz --namespace default


