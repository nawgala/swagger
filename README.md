# READE

This is a basic project structure of multi module kotlin project with Maven. 
Dependencies has managed with bom in the parent pom


## Environment
 
* JDK 14
* Maven 3.5.2
* Mysql 8.0.0_16


## How to build

`mvn clean install -DskipTests -Dhttps.protocols=TLSv1.2`


## How to Release 

use following command to tag the project on gitBD

    mvn release:prepare -Dmaven.test.skip=true -Darguments="-Dmaven.test.skip=true" -Dresume=false
    
    
## Server
   How to start spring boot application with custom package scanning    
    
## Swagger Server
   
   Sample spring boot application with swagger interface

   Ref: https://springfox.github.io/springfox/docs/snapshot/

   You can access swagger UI from http://localhost:8080/tas/swagger-ui/index.html