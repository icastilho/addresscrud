# [addresscrud](https://addresscrud.herokuapp.com/)
A Simple Address CRUD example


## Quick start
1. Clone the git repo — 'git clone https://github.com/icastilho/addresscrud.git'
2. execute maven dependence install
	mvn install 
3. Run the application
	mvn spring-boot:run
3. Access the url http://localhost:8080/address from a Rest Client


## Data Base
This application using mongolab 
* mongodb://example:example@ds039010.mongolab.com:39010/heroku_app36112369
To change go to src/main/resources/application.properties

## Live [example](https://addresscrud.herokuapp.com/)

## Features

* Get All Address - GET request - http://localhost:8080/address
* Create a Address - POST request - http://localhost:8080/address
	- Json Example: {
					"street":"R. Vergueiro",
					"number": 943,
					"neighborhood": "Liberdade",
					"city": "São Paulo",
					"state": "São Paulo",
					"cep": "01504001"
					}
* Get a Address by Id - GET request - http://localhost:8080/address/{id}
* Update a Address - PUT request - http://localhost:8080/address{id}
	- Json Example: {
					"street":"R. Vergueiro",
					"number": 945,
					"neighborhood": "Liberdade",
					"city": "São Paulo",
					"state": "São Paulo",
					"cep": "01504001",
					"complement": "Proximo a estacao Vergueiro do metro"
					}
* Delete a address - DELETE request -  http://localhost:8080/address/{id}