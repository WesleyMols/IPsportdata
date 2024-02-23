This application makes use of a simple MVC structure, with four layers in the architecture. 
The domain is used to make decisions and calculations. This is linked to the API via interfaces. 
The persistence is used to connect to a MySQL database via a JDBC connection. In here data is stored from the API and from the domain.
Together these two layers form the model. 
The app layer is what I called the API layer or controller makes also a connection to the client. It passes information through from client to persistence and domain via its controller. 
The InputDTO contains all getters and setters to pass input data from client side. 
The App file contains the backend server and forms the entry point of the application. 
The client layer (view) has an index hmtl file which defines what is shown in general. Then different page files in the corresponding folder. 
The App file here determines what is shown on the home page at localhost 5173. 
The backend is passed through via a proxy. 

This is an oevrview of the architecture:
![alt text](/Tekeningen/architectureDraw.svg "architecture")

Tests are dependent on JUnit and Jacoco is used to report on test coverage.
The frontend server is run via Vite. The backend via Jetty. 
At the moment Cypress is not yet used. 