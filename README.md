# code-excercise

There are three microservices in this project
They are namely service, client and service-client-composer

The service-client-composer microservice is the one that calls both the service and client microservices.

To safeguard against cheating i.e. to make sure we are responding to the same client that asked the question.

1. First the user should get token which has payload like userID etc from auth server.
2. Create an interceptor class
3. Create a bean of type UserSession with request scope
4. In the interceptor class, extract the token and set the attributes like userID into UserSession object
5. Now you can use this UserSession object in your controllers or services for this request alone
6. Finally use the userID from the UserSession as part of the key in the hashmap in the service MS
7. That way if a malicious user comes and asks the answer to the same question, we will not return data in the hashmap specific to another user

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



