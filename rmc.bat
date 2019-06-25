@ECHO OFF
ECHO mstransactions
docker stop mstransactions
docker rm mstransactions
docker rmi ibmdigitalbank/mstransactions
docker build . -t ibmdigitalbank/mstransactions
docker run --network mynet -d -p 8080:8080 --name mstransactions ibmdigitalbank/mstransactions
docker logs mstransactions
PAUSE