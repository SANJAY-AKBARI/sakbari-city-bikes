
SAKBARI-CITY-BIKES

# Application

The application is used to test for cityBikes API run using the Maven java plugin.
Tests are can be run in as following different ways
1. Junit
2. CucumberRunner
3. Postman
4. Command Line

Following Scenarios are tested for cityBikes API.

#1. http://api.citybik.es/v2/networks  (Scenario 1)
#2. http://api.citybik.es/v2/networks/network_id  (Scenario 2)
#3. http://api.citybik.es/v2/networks?fields=id,name,href (Scenario 3)


I tested this feature in few way. Manual way to check how is API end point work for this feature.
I tested in postman to get response. I created postman folder and dump the all data

# 1. Junit
In Junit Configurations i have provided below details to run Junit tests along with Plugins
You can run the cucumber tests suite in your IDE by launching CucumberRunnerTest.java class as a junit test with below values.

# Run/Debug Configurations

1. Name:   CucumberRunner
2. Class:  com.citybikes.runner.CucumberRunnerTest
3. VM Options: -ea
4. Use classpath of module: sakbari-city-bikes
5. JRE: 1.8
6. Shorten commandline: user-local default

  
# 2. CucumberRunner

Cucumber tests  whole Feature: getBikeLocations
Cucumber Java with BDD Given,When,Then,And format.
Provided details as below.
#Run/Debug Configurations

1. Name: Feature getBikeLocations
2. Main class: io.cucumber.core.cli.Main
3. Glue: com.citybikes.stepIntegeration
4. Feature or folder path: C:/repos/sakbari-city-bikes/src/test/resources/features/getBikeLocations.feature
5. Program arguments:   --plugin org.jetbrains.plugins.cucumber.java.run.CucumberJvm5SMFormatter
6. Use classpath of module: sakbari-city-bikes
7. JRE: 1.8
8. Shorten commandline: user-local default

# 3. POSTMAN

 How to test API endpoint with json response format.
 Postman is currently one of the most popular tools used in API testing.
 Accessibility, Use of Collections, Collaboration, Continuous Integration,are in Postman. 
 
 Each URL is called a Request while the data sent back to you is called a Response.
 
 These are the Request Methods:
 GET: Used to access a resource
 POST: Used to create information
 PUT: Used to update a resource
 DELETE: Used to delete a resource
 
 #Create a Collection of API Calls
 A collection is a place where you will group all your API calls.
 After creating the environment click again on 
 New >> Collection give a name and add a description (Optional) to your collection and then click on create.
 Once this is done, you can import a file, import a folder, import from a link or paste the JSON Raw Text, 
 for testing purposes we will be using the postman collection.
 
 #1.http://api.citybik.es/v2/networks  (Scenario 1)
 In Postman using above End points with GET Method in default Environment and send it to the request.
 Then I'm getting Response body as a JSON format with status code 200 OK.
 I'm getting it entire networks across the globe.
 #which is including under networks Company Name, Network_id, Location,latitude,city,longitude,country etc. with related brief details.
   
     
 #2.http://api.citybik.es/v2/networks/network_id  (Scenario 2)
 In Postman using above End points with GET Method in default Environment and send it to the request.
 Then I'm getting Response body as a JSON format with status code 200 OK.
 I'm getting it entire networks_id which i mentioned in networks/visa-frankfurt across the globe.
 Which is including Company Name, Network_id, Location,latitude,city,longitude,country with related brief detials.
 Here I'm getting extra details with 
 #stations,extra,bike_uids, number,uids,free_bikes,id,timestamp,empty_slots which obviously related given network_id.
    
 #3.http://api.citybik.es/v2/networks?fields=id,name,href (Scenario 3)
 In Postman using above End points with GET Method in default Environment and send it to the request.
 Then I'm getting Response body as a JSON format with status code 200 OK.
 #I'm getting it only 3 values under networks href, id,name across the globe. 
 As we can see in url as a field.
   
 # 4.Command Prompt
 
 #How to Run  Junit in command line
 
 How to run cityBikes in commandline  using maven
    
 You can run the following command to run all your test cases:
 mvn clean test
    
 You can run a for particular test as below
  
 mvn clean test -Dtest=com.citybikes.runner.CucumberRunnerTest  
  
 #########################
 
 Automation Scenario testing with BDD Cucumber (stepIntegeration) and Junit with Cucumber runner
 I wrote 3 scenario in getBikeLocations.feature file

 # Scenario 1 This scenario indicates for globe. 
 How can i find out city bikes location.  So what i did, i used network parameter to send a request to get city bikes location.if is  successful i will get response  200

 # Scenario 2 This scenario indicates  for specific city location.
 To get bike locations for specified city. 
 I used specified city as a Network_id. So i used Visa-Frankfurt as network_id to get successful response  200

 # Scenario 3 This scenario indicates for city Frankfurt in Germany (Note: Acronym DE as define Deutschland).
 First i need to get city bikes location. 
 Then i passed parameter as a network_id to pass query string parameters in GET url using Rest Assured. 
 I can pass them as a Queryparameter to get  Latitude and Longitude field.



 # Utils
 Utility API endpoints  to enable provided link 
 API End points here

 http://api.citybik.es/v2/networks
 http://api.citybik.es/v2/networks/network_id
 http://api.citybik.es/v2/networks?fields=id,name,href
   
 # Dependencies
 To run cucumber i downloaded latest dependencies in pom.xml file which are belows
 io.cucumber:cucumber-junit:6.8.2
 io.cucumber:cucumber-java:6.8.2
 io.rest-assured:rest-assured:4.3.2
 io.cucumber:cucumber-core:6.8.2

 Imports Plugins and add in StepDefinitions class

`
