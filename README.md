This is the final project of the Sogyo academy for software engineers.
My project is titled IPsportdata. This application can take Maximal Lactate Steady State (MLSS) test data and return an estimaiton for anearobe threshold power. The goal is to analyse test results and give a race power advice. Users should first perform a cycling test as described in the following protocol.

A protocol to find MLSS must be followed similar to the described protocol on: https://www.highnorth.co.uk/articles/blood-lactate-testing-protocols-for-cyclists
It is recommended to perform this test on an ergometer and have some practice in taking lactate samples. 
Sample values can be entered in the specific boxes.
This results in the following business rules:
* power data n corresponds with sample 1 and sample 2
* if sample 2 - sample 1 < 1 then next (power n+1) else return power n and power n-1

Installation guide
1. to run this application one would need to install Node and gradle
2. A MySQL database is required to store data inputs and return those;
    * Run this SQL script to create the required table:
    ``` 
    CREATE TABLE user_input (
    input_id int NOT NULL auto_increment,
    username varChar(50),
    power int,
    lactate_one decimal(5,2),
    lactate_two decimal(5,2),
    lt_diff decimal(5,2),
    heart_rate int,
    primary key (input_id)
    );
    ```
    * Run this SQL script to create the required function:
    ```
    create function namePar2 ()
    RETURNS varchar(50) DETERMINISTIC
    return @username;
    ```
    * Run this SQL script to create the required stored procedure:
    ```
    CREATE DEFINER=`root`@`localhost` PROCEDURE `create_view`()
    BEGIN
    Drop view  if exists output;

    CREATE VIEW output AS
        SELECT 
            power, lactate_one, lactate_two, lt_diff, heart_rate
        FROM
            user_input
        WHERE
            user_input.username = namePar2();

    SELECT 
        *
    FROM
        db_ip_wesley.output;
    END
    ```

3. the backend server is started with the command: 
    ``` gradle run ```
4. the frontend server is started from the client folder with the command:
    ``` npm run dev ```
5. localhost can then be found at port 5173 (default)
6. Plotly is used to generated the graphs, therefore the following command needs to ben ran in client folder: ```npm install plotly.js-dist```

Usage
* Any user should first submit an username
* Then the test data can be submitted, one row at the time
* This way the inputs are stored and analysed

Must:
* some form of data input, starting with user input on webpage
* data input format of blood lactate and velocity
* calculate anaerobe threshold
* inform about race pace of one hour TT (equals anaerobe threshold by assumption)


Should:
* calculate aerobe threshold
* allow more data types: heart rate, power
* store results with timestamp per user


Could:
* allow multiple test formats, all on different pages
* plot graph of the input data and calculated values
* analyse previous results with each other
* provide training zones



Would:
* analyse all user data from a database by simple input of user id
* provide with trainingprograms


It is intended to gain experience in the following technical aspects:
* Cypress as a testing framework for web browser
* Behavior driven design
* Deeper understanding of Java and Object-Oriented Programming
* Understanding a complete application with an MVC architecture.
* JavaScript for web page logic




Furthermore, the following personal goals are formulated to improve upon:
* growth mindset
* ask help to understand the problem better 
