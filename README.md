# code-excercise

There are three microservices in this project
They are namely service, client and service-client-composer

The service-client-composer microservice is the one that calls both the service and client microservices.

Follow the below steps to run this project after checking out into your system

1. Run the service microservice at 9095
2. Run the client microservice at 9096
3. Run the service-client-composer microservice at 9097
4. Finally access the service-client-composer microservice at the below URL.

GET http://localhost:9097/service/client/colloborate

Sample Output:

Client : Hey Service, can you provide me a question with numbers to add?
Service : Please sum the numbers 1,6,6
Client : Please sum the numbers 1,6,6 and the answer is 111
Service : That’s wrong. Please try again
Client : Sorry. Please sum the numbers 1,6,6 and the answer is 13
Service : That’s great



