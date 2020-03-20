# Homework Test Project
## Tom Aylen
### 20/3/2020  

This is a demo project to learn about automated testing using the Selenium WebDriver.  
https://www.selenium.dev/projects/

[To discuss](discussion.md)

# Tests
This section describes the tests that are contained within this project.
## Web Playground Test
https://d1iw6mb9di5l9r.cloudfront.net/  
This list is the test that are written for the Web Playground webpage, which was provided by AccessHQ as part of a code camp.

## Forms Page

### Manadatory Error Messages
1. Click the 'FORMS' menu item
2. Click the 'SUBMIT' button
3. Verify the manadatory error messages:
    - "Your name is required"
    - "Your email is required"
    - "You must agree to continue"
4. Enter a valid name
5. Enter a valid email address
6. Click the 'agree' checkbox
7. Verify that the error messages are no longer present or empty

### Successful Submission
1. Click the 'FORMS' menu item
2. Enter 'Dan' in the name field
3. Enter 'dan@abc.com' in the email field
4. Click the 'agree' checkbox
5. Click the 'SUBMIT' button
6. Verify that the popup message says 'Thanks for your feedback Dan'
