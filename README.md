This is the final project of the Sogyo academy for software engineers.
My project is titled IPsportdata. The goal is to analyse test results and give a race peace advice based on input of test results.

Installation guide
1. to run this application one would need to install Node and gradle
2. more?
3. the backend server is started with the command: gradle run
4. the frontend server is started from the client folder with the command: npm run dev
5. localhost can then be found at port 5173 (default)



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
* ask to understand the problem instead of to find one solution



Details of software stack:
* client layer to communicate with a user
* app/API layer acts as a layer in between client and domain.
* domain layer contains the businesslogic
* persistence is used to store


First restriction to use this application:
A protocol to find MLSS must be followed similar to the described protocol on: https://www.highnorth.co.uk/articles/blood-lactate-testing-protocols-for-cyclists
Sample values can be entered in the specific boxes.
This results in the following business rules:
* power data n corresponds with sample 1 and sample 2
* if sample 2 - sample 1 < 1 then next (power n+1) else return power n and power n-1