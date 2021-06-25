# Notz


## How to deploy on your local
 1. Open the project on your IDE as a maven project.
 2. Configure your Database Connection Credentials on `NotesDB` class on controller package.
 3. Click `Clean and Build`
 4. Click on `Run or Debug`



## About The Project

This is a maven web application project made with Java Server Pages. The Project is build under a simple MVC structure,
which the `controller` Servlets acses the `dbservice` methods , get the `modell` and put them in different Java Server Pages (`view`).
The  `dbservice` class is responsible for the connection with the mysql databse as well as using JDBC to create query methods.

After pressin `Run`,  the first thing that's going to show is the Login Page.  You can create a new User by filling a basic Sign UP form and than we are going to be entering the homepage. There you are able  to create multiple Notes as well as deleting them .The Notes are going to be saved in the MySQL , where each User has its own Table so every Note it's going to be diffrent for each User.

If you log in as an Adminstrator , instead of the homepage of  a user , you are going to see and mangage all register Users.
You can confirm the Adminstrator at Note



### Built With

This section should list any major frameworks that you built your project using. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.
* JavaEE
* JSP
* JDBC
* JQuery
* Maven
* HTML/CSS
* Bootstrap
* MySQL
* Wildfly Server


