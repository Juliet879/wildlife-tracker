## WILDLIFE-TRACKER


   <img src="images/screen.png">

  ## wildlife
     -September 24th, 2020.
    ###By **Juliet Gisemba**
    
##Description
This is application that allows Rangers to track wildlife sightings in the area.

## Technologies
  Java
  Spark
  Handlebars
  Sql
  Sql2o
  PostgreSQL
  Bootstrap
  
## Setup/Instructions
    -You have PostgreSql and JDK 8+ installed
    - You have a idea (preferred Intellij)
    -You have a idea (preferred Intellij)
    -Clone the repo git clone https://github.com/Victorteka/Wildlife-Tracker.git
    -Open the folder from github in your idea
    -On your terminal type psql to open postgresql command shell
    -Create database CREATE DATABASE database_name
    -Connect to the DB \c database_name
    -Create table CREATE TABLE table_name(name varchar)
    
    
    -In PSQL:
CREATE DATABASE wildlife_tracker;
CREATE TABLE animals (id serial PRIMARY KEY, name varchar ,type varchar ,age varchar, health varchar);
CREATE TABLE sightings (id serial PRIMARY KEY, location varchar, ranger_name varchar, wildlife_id int );
  
 ## Known Bugs
- There are no known bugs currently. The page works as expected.

## Support and Contact Details
- For any comments,suggestions,feedback or inquiries, contact me via email: `julietgisemba000@gmail.com`


LICENSE
MIT License MIT license

© 2019 Juliet Gisemba
