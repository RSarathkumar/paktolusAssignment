# Selenium project to validate and submit a form 

## Technical Stack:
1. Automation framework : Selenium (Page object model)
2. Test Management  : TestNG
2. Build Management : Maven 

### The project consists of following 
1. Landing the correct url loaded from a property file and verifying the landing of correct page. Headers are checked
2. Starting the form Actions by validating the input fields.
        
         First name and last name are checked for its validation by entering empty field
         Email field is validated using the invaild email
         Password is entered less than 5 characters and asserted
         Confirm password is entered from wrong password and validated
3. Terms and conditions are chacked by opening the popo up and asserting it.
4. The checkbox is enabled and submitted to create account

#### Total Tests : 11

### How to execute?
    Clone this repository to a IDE that runs testng selenium tests using maven and run testNG.xml file
           
