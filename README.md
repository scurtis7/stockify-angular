# Stockify-Angular

This application will allow you to follow and research stocks.  I use the 
[Alpha Vantage API](https://www.alphavantage.co/documentation/#) to get stock information.

## Version 0.0.1
This is the initial version with all of the three main pieces (Spring Boot, Angular9 & Postgresql) working together.
Not much functionality yet just the initial shell of the application.

## Technologies
- Spring Boot - `v2.2.5-RELEASE`
- Java - `v1.8`
- Angular - `v9.0.5`
- Postgresql - `v12.1`
- Gradle - `v6.2.2`
- Node - `v13.8.0`
- Typescript - `3.7.5`

## How to run locally
I use a Mac and IntelliJ IDEA so these instructions are for that setup.
After you clone the repository then follow the steps below.

### Start DB 
Make sure postgresql is installed and running locally.

### Initialize the database
Next you will need to setup the database and initialize the tables.  I do this from IntelliJ and the database init
scripts can be found in `stockify-angular/miscellaneous/database/init.sql`

### Build the Angular application
To build the Angular application follow the following steps:
- open a terminal
- navigate to `stockify-angular/src/webapp`
- install angular dependencies with this command `npm install` (you only have to do this once)
- run the following command `npm run build`

### Build the spring boot application
Next build the Spring Boot application with these steps:
- open a terminal
- navigate to `stockify-angular/`
- run the following command `./gradlew clean build`

### Start the application
Once the application is built you can run it with the following command:
- In the terminal from the same location you ran the build from
- run the following command `./gradlew bootRun`
- navigate to the [Stockify application](http://localhost:8080)

**NOTE:** You can also build and run the application from IntelliJ
