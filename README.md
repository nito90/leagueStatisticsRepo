## Overview

The project implements the logic for the creation of a new point system.

## Prerequisites
- JDK 1.8 (Oracle)
- Maven 3

## Installation 

```
mvn clean install
```

## Deployment
```
mvn spring-boot:run
```

## Url to interact with Swagger
```
http://localhost:8080/swagger-ui.html
```

## The format of the output should be:

```json
{
    "leagueName" : "<YOUR_NAME>",
    "table": [
        {
        "position": 1,
        "newSystemPoints": 16.3,
        "name": "Aberdeen"
        },
        {
        "position": 2,
        "newSystemPoints": 15.1,
        "name": "Celtic"}
        ]
}
```
