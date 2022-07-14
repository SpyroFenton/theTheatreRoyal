# theTheatreRoyal

## This repository contains the code for the Theatre Royal booking system application for the final project of the Aston University Skills Bootcamp. 
## Created by team Java Lagged (Fenton, Hiten, Megan, David)
## Repository created on the 03/07/2022

Instructions to run project

To start the project first initialise the SQL database, there are two databases, one contains spoof data for testing and the other is without spoof data

location: theTheatreRoyal\SQL Files
without spoof data = theatreRoyalvanilla.sql
spoof data = theatreRoyalwithData.sql

1. Open MySQL workbench, either create a new MYSQL connection or click on Local instance, import the sql file from above
2. Run sql script
(database should now be initialised)

3. Now open the java project in an IDE of your choice, file location: theTheatreRoyal\theTheatreRoyal
4. First change the credentials.txt file to match your MYSQL workbench URL, Username and password
5. Run the FrontEndController.java as a java application


There are some known bugs in the program:
- Some search results might return an error message. The reason is not clear why, as sometimes repeating the same search that previously displayed an error message will work. More testing and debugging is needed.
- Some Strings printed in the console might present 'odd' characters or symbols. We believe this to be a translation era when jumping on the program between MacOS and Windows.
- Shows in the database could still be listed if the performance has already finished or started. This is because there is no feature to make sure SQL only pulls performances from todays date and time onward. This is definitely not an ideal scenario for the program to operate on, but to implement this feature by the deadline would take more time than we currently have.
We hope you enjoy our program