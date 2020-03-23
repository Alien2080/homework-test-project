### Issues/Problems
These are issues etc. which I want to discuss with the trainer of the code camp

1. Use of 2 test cases for mandatory error messages
2. explicitly calling out 'Arrange. Act, Assert'
3. ~~Use of try/catch block for handling expected behaviour of missing error messages~~
    - ~~on testing this implementation I found that it took 90 seconds for a test, this was due to the implicit wait time of the driver, set in the set up method. Which in turn made me think about the other implimentation using findElements and just returing the first element (or empty string) would never use the implicit wait~~
    - ~~so it seems both ways have draw backs either:~~
        - ~~dont use implicit wait when retriving element (could lead to unreliable tests on some networks/applications), but maybe overcome with explicit wait~~
        - ~~use try/catch and just take the time cost, this seems like the only way to ensure the element isnt missing from network factors~~

4. FormsPage help method to get forms page
5. When testing a new website, what would be the best way to seperate the tests? via a new project per websire or with a new abstraction layer for BaseTestSuite to remove website specific data, i.e. URL and helper method to get form page
