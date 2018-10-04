# HomeCredit-Guru99 Bank System Exercise

## Requirements
- Selenium WebDriver
- Page Object Pattern
- Programming language: Java
- TestNG

## Installation
1. IntelliJ IDEA and JDK 1.8
2. Maven

## Test Execution
```
mvn clean test
```

## Test Scenarios - Verify three functions of Demo Banking System.
```
1. Verify that a new customer can be created.
- User login successful with valid username and password generated from Demo Banking Site.
- Navigate to Create New Customer Page from Left Menu Page
- Input valid information for new Customer
- Verify that The new Customer is created successful with correct Information

2. Verify creating new account based on the customer just created above.
- Navigate to Create New Account Page from Left Menu Page
- Input valid information for new Account with created Customer Id from test "1"
- Verify that The new Account is created successful with correct Information

3. Verify deposit function work fine with the account just created.
- Navigate to Deposit Page from Left Menu Page
- Input valid deposit amount and account Id from test "2"
- Verify that deposit successful with correct update balance
 ```

## Report location
```
${basedir}\target\surefire-reports
```
 