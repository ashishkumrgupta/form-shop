<h2>The Farmshop</h2>
This is an assignment project.

<h2>System requirements</h2>
1) Java-8 or higher <br>
2) maven <br>
3) lombok should be installed. (If not available you will see complilation errors in IDE)

<h2> Build Process</h2>
This is a maven project, hence to build, go to root directory and use <b> mvn clean install. </b> <br>
This will generate a jar in the target directory.

<run the project>
To run the Jar use <b> java - jar farmershop-services-0.0.1-SNAPSHOT, </b>

Once the process is successfully started following Rest-api's can be accessed via <b>CURL</b> or <b>postman</b>

<h4> 1) As a farmer, I want to see an overview of my flock, with a JSON representation, using a HTTP REST service</h4>

curl -v http://localhost:8080/farmshop/admin/flocks

<h4> 2) As a  farmer and client of the webshop, I want to see what stock of milk and wool is available. </h4>
curl -v http://localhost:8080/farmshop/client/stocks

<h4> 3) As a client of the webshop, I want to be able to order milk or/and wool.</h4>
curl -d {"customer":"Milk and Wool Trading Ltd","order":{"milk":10,"wool": 3 }} http://localhost:8080/farmshop/client/order

<h4>4) As a farmer, I'd like to see history of (fulfilled) orders</h4>
curl -v http://localhost:8080/farmshop/admin/orders
