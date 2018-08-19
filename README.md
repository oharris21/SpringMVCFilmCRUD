## Spring MVC Film CRUD Project

### Description
The goal of the Spring MVC Film CRUD Project is to allow the user to access a database schema, called sdvid and to perform certain actions while connected to the database. In particular, the film, film_actor, and actor tables from the schema are used. The user is prompted with an initial homepage website listing various actions they can take. For example, the user can add a film to the database, retrieve a film from the database using a film ID, or even search for films with a keyword. These actions take the user to different webpages, displaying the results to the particular action taken. When searching for films by keyword, the webpage will list the films matching the string entered into the input form. Furthermore, each film listed has an option to edit, delete, or see the details of that particular film in the row. Utilizing dynamic jsp webpages and depending on the actions the user takes, sometimes the same jsp view page is used to display corresponding results - but these are variable due to conditional java embedded EL being used on the jsp page itself. I.e. we can use jsp pages to display something different depending on user actions and whether or not those actions are successful, e.g. printing out a message on the same page which states that addition of a film to the database was successful or not.

The overarching reach of this project was to implement STS and the Spring Framework in conjunction with JDBC API methods and Gradle to create a fully-functional dynamic Java web project. This web application is run by an Apache Tomcat server instead of requiring a main() method or general application class.

 Since there was not enough time, CSS styling has not yet been incorporated for the html pages in the project - this would be a nice stretch goal to implement when the project is revisited.

### Skill Distillery Week 7 Homework
This project was assigned after Week 7 of Skill Distillery's Java Coding
School.

#### Technologies Used

* Java
* mySQL, mySQL workbench
* JDBC API methods via java.sql
* EER Diagrams
* Gradle
* Spring Tool Suite IDE
* Spring Framework
* Spring MVC
* HTML/CSS
* Apache Tomcat Server

#### Lessons Learned

* Using JDBC API methods with a mySQL driver to access a database schema.
* Using PreparedStatements to avoid poor coding via mySQL injections.
* Setting build configuration profile with Gradle dependency manager, and also learning how to run Gradle builds/tasks for a web application project.
* Advanced mySQL commands to pull the right data from tables and also translating those commands to work with Java via the java.sql library.
* Advanced request handling methods with Spring MVC, STS, to use flashAttributes() and ModelAndView objects to redirect a POST to GET request url mapping in a controller class.
* DML, DDL, mySQL query handling, especially with the particular executeUpdate() method
* Cleaning projects/server and cleaning work directories to clear cache, allowing Tomcat Apache server to run appropriately due to changes made in project
* Adding Spring and Gradle nature to a dynamic web project in STS. Configuring a Spring project, especially setting up appropriate beans/dependencies, dispatcher servlet, component scans (in the -servlet.xml file), etc.
