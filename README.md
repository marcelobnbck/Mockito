# Customer Registration Project with Mockito

This project demonstrates the use of Mockito framework to test a customer registration service. It includes model classes, a repository, and a custom exception.

## Tests

The `CustomerRegisterTest` class demonstrates the use of Mockito to test the `CustomerRegister` class. It includes tests for the following scenarios:

* Successful registration of a customer.

* CPF validation.

* Verification of interactions with the repository mock.

* Verification that the address is correctly passed to the repository.

## How to run the tests

To run the tests, you can use JUnit and Mockito. Check the following dependencies in your project:

* JUnit 5
* Mockito

You can run the tests using your IDE, reviewing the results, or by command line:
* mvn install - to perform the installations
* mvn test - to perform the tests
