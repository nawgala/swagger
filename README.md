# READE


## Environment
 
* JDK 14
* Maven 3.5.2
* Mysql 8.0.0_16


## How to build

`mvn clean install -DskipTests -Dhttps.protocols=TLSv1.2`


## How to Release 

use following command to tag the project on gitBD

    mvn release:prepare -Dmaven.test.skip=true -Darguments="-Dmaven.test.skip=true" -Dresume=false
    
    
## TAS Server
   TAS is stayed behind the proxy. All the authenticated request will be routed to TAS. Swagger is enabled for the tas 
   interface. you can check the response returned from tas as bellow specified

   Ref: https://springfox.github.io/springfox/docs/snapshot/

   You can access swagger UI from http://localhost:8080/tas/swagger-ui/index.html