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
2. what about the database?
3. the backend server is started with the command: gradle run
4. the frontend server is started from the client folder with the command: npm run dev
5. localhost can then be found at port 5173 (default)

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



Details of software stack:
* client layer interacts with a user on the localhost server of Vite and communicates with the API layer through an App and api
* app/API layer acts as a layer in between client and domain, this layer contains a controllor that communicates with client, persistence, and domain
* domain layer contains the businesslogic and communicates with the API via interfaces
* persistence is used to store data and username in a MySQL database

![alt text](/Tekeningen/architectureDraw.svg "architecture")
