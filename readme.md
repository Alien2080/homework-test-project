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

## Home Page

### Hello Greeting
1. Enter 'Dan' into the Forename field
2. Click the 'SUBMIT' button
3. Verify that the popup message says 'Hello Dan'

### State Transition
1. Click the 'CLICK ME DOWN!' button
2. Verify that the text changes to 'CLICK ME UP!'
3. Click it again
4. Verify that the text changes to 'CLICK ME DOWN!'

### Love List
1. Find the unordered list item with the text 'List Item 2'
2. Click the Heart icon within this list item
3. Verify that the popup message says 'You loved List Item 2'

### Buttons
1. Click the 'LOGIN' button
2. Verify that the alert message shows 'You clicked the login button'
3. Click the 'CANCEL' button
4. Verify that the alert message shows 'You clicked the cancel button'
5. Click the 'HOME' button
6. Verify that the alert message shows 'You clicked the home button'
7. Click the 'LINK' button
4. Verify that the alert message shows 'You clicked the link button'
5. Click the 'UPLOAD' button
6. Verify that the alert message shows 'You clicked the upload button'

## Login Dialog

### Manadatory Error Message
1. Click the 'USER' (icon) menu item
2. Click the 'LOGIN' button in the 'Login' dialog
3. Verify that the Username error says 'Invalid user and password'
4. Verify that the Password error says 'Invalid user and password'