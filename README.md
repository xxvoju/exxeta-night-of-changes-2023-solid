
# Night of chances - 2023

## From spaghetti code to SOLID structure

This repository is dedicated for the workshop materials and exercises. 

## First steps
You should simply clone the repository import it into your favorite IDE as maven project, and you are good to go.

The exercises can be found in package **sk.exxeta.nightofchances.example**. Packages _exercise1, exercis2, exercise3_, contain the sources for the examples shown in the presentation from state before the refactoring. 

The refactored resources can be found in package **sk.exxeta.nightofchances.refactored**

## Exercise4
The bonus exercise can be found in package **sk.exxeta.nightofchances.example.example4**. The package contains a single class _EmployeeEntity_. 
This entity holds basic information about an employee and is also capable of managing a collection of employees. 
The _EmployeeEntity_ provides the following operations for the client:
* save the employee
* retrieve all saved employees
* retrieve employee by name
* delete employee by name
* display employee details in the console
* calculate days worked in a specific month
* calculate employee salary in a specific month
* send employee salary to a given bank account for a specific month

**Note**
the implementation of these methods is pretty simple and straight forward therefore you can find the code pretty simple, and refactoring as an over-engineering. You should however not focus on the implementation details, but on the code structure.

## The task 
is to find code organization smells and to reorganize the code in a way, that is compliant with the presented solid guidelines:
* Single responsibility principle: a class should have only a single responsibility
* Open-Closed principle: software modules should be open for extension but closed for modification
* Liskov substitution principle: objects in a program should be replaceable with instances of their subtypes without altering the correctness of the program
* Interface segregation principle: clients should not be forced to depend upon the interfaces that they do not use. 
* Dependency inversion principle: program to an interface not to an implementation

You can reorganize the code, you are allowed to add or change method signatures, split methods in a way it suits you the best, but the resulting code itself should also provide the operations listed above
* _hint_ you are not forced to keep the implementation as rigid as it is, but you can e.g. replace System.out.println with an abstraction e.g.:
  *  displayEmployeeDetails() printing to System.out can request the print writer from the client, so the signature can by something like:  displayEmployeeDetails(PrintStream output)

### Your solution
You should upload your solution in your public accessible github repository, and you should send a link to this repository to us via email to the addresses from under the QR code.

Good luck
