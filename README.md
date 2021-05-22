# weatherTop
The Webapp created is based around the theme of a weather app that not only displays various elements of the weather to the user, but also allows them to sign up to the app, log in and create their own stations and readings, as well as having the ability to delete them also. The app is connected to a database using elephantSQL, that when deployed, allows for persistence in that information that the user creates is stored in the database. The Webapp is deployed using the Heroku Cloud Application Platform at http://intense-stream-13285.herokuapp.com/

Below, I will give a quick run through of the major pages that allow for the functionalities and displays of the Webapp.

Dashboard.java(controller)
This renders many of the methods that I have created in the models. This is the controller for my dashboard page and invokes the methods from models for this page and renders them to the dashboard view. The logic is contained in my models which are then processed in my Dashboard controller. I am invoking the methods by first, creating an arraylist called stations, then iterating through this arraylist using a for each loop, the methods are called to place their values inside of a variable. This controller also contains my methods to both add and delete stations as these are all contained on the Dashboard page.


StationCtrl.java(controller)
Much the same as Dashboard.java, this controller is rendering methods that I have created in the models. As my stations page contains much of the same functionality as the dashboard page, many of these methods are invoked from the same methods in the models. This controller also contains the methods to both addreading and deletereading, allowing the user to add and delete as many readings as they please.


Member.java(model)
This model is a part of the webapp that allows the user to create members i.e sign up and log in. The model contains a variables such as firstname, lastname, etc that are added to the Member constructor. Also contains methods to help in finding both the member by email and also their password which as then invoked in the Accounts.java controller.

Reading.java(model)
This model contains the variables that make up the reading data, along with its constructor. It also contains a small method that allows for the displaying of a timestamp. Also contains getters and setters of the variables.

Stations.java(model)
The Station model contains much of the logic that is applied on my Webapp. This model contains most of my methods that I have implemented to invoke the logic. It contains methods that are simple return statements and return statements with more complex formulas added, switch statements, a Hashmap, amongst other things. Much of these methods and logic is then invoked by the controllers to produce the desired information. 

StationAnalytics.java(utils)
Allows me to pull the smallest and largest values for many different readings, for example the largest/smallest temperature from the readings. 

addreading.html(tag)
This is the form that allows me to add readings. Contains input fields for the fields required for a full reading. This tag is then called in station.html(the Station page).

addstation.html(tag)
This is the form that allows the user to add a station. Contains 3 fields to allow the user to add station name, lat and lng. This is then contained in the dashboard.html page where it is displayed.

listweather.html(tag)
Contains both my summary and also the readings to be displayed. The readings are called from the controller, which then invoke the logic from the model. The summary contained in listweather is called in both station.html and also dashboard.html, so applies the DRY principle and displayed the summary cards in the frontend. The readings contained in this tag are then called in the station.html page to display the readings table.

about.html(view)
This contains some simple text and images about the app that is created using Fomantic UI and html.

dashboard.html(view)
This html page displays my Dashboard page. The dashboard page displays stations that the member has access to the summary cards of the readings. It also allows the user/member to add/delete stations. 

login.html(view)
A simple login form that calls logic from the Accounts.java controller to allow a user that has an account to log in as a member.

Signup.html(view)
Again, a simple form that allows the user to sign up to the webapp.

station.html(view)
Without having much code on here, this html page calls much of its views from listweather.html and addreading.html to display information such as the summary cards and readings table.


Known bugs/problems:
- The timestamp will not display for current readings that are coming from the yaml file. For new readings the timestamps are displayed but are not displayed from current readings.


