This is the final project of the Sogyo academy for software engineers. 
My project is titled IPsportdata. The goal is to analyse test results and give a race peace advise based on input of test results.

Must:
* some form of data input, starting with user input on webpage
* data input format of blood lacate and velocity
* calculate anaerobe threshold
* inform about race pace of one hour TT (equels anaerobe threshold by assumption)

Should:
* calculate aerobe threshold
* allow more data types: heart rate, power
* provide trainingzones
* store results with timestamp per user

Could:
* allow multiple test formats, all on different pages
* plot graph of the input data and calculated values
* analyse previous results with eachother


Would:
* analyse all user data from a database by simple input of user id
* provide with trainingprograms

It is entended to gain experience in the following technical aspects:
* Cypress as a testing framework for web browser
* Behavior driven design
* Deeper understanding of Java and Object-Orientated Programming
* Understanding a complete application with an MVC architecture.
* JavaScript for webpage logic


Futhermore, the following personal goals are formulated to improve upon:
* growth mindset
* ask to understand the problem instead of to find one solution
* 

Details of software stack:
* client layer to communicate with a user
* app/API layer acts as a layer inbetween client and domain. 
* domain layer contains the businesslogic
* persistence is used to store 

First restriction to use this application:
A protocol to find MLSS must be followed similar to the described protocol on: https://www.highnorth.co.uk/articles/blood-lactate-testing-protocols-for-cyclists
Sample values can be entered in the specific boxes. 
This results in the following business rules:
* power data n corresponds with sample 1 and sample 2
* if sample 2 - sample 1 < 1 then next (power n+1) else return power n and pwoer n-1 