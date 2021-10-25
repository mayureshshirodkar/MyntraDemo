# MyntraDemo
POM design pattern is used along with Cucumber + Junit framework. 
Maven for handling plugins and java dependencies.

Note: Inorder to trigger the tests, run the TestRunner class(Junit class) available under src/test/java/testrunners.

This Framework has 3 main components:

1. Feature Layer - Contains all the feature files for the application.

2. Page Layer - Page object model based design pattern, all actions and locators for a page.

3. Step Definition - Step definition for each step in the feature file

4. Driver Factory - Initialises the driver for the implementation

5. Utilities - Contains utility for Web Element actions, Reading property files

6. Test Runner - Initiates the Tests

Other packages in the framework:

Reports - Contains the reports generated during test run.

Resources - Contains all the property and configuration files.


![Framework](/overview.png)


 
