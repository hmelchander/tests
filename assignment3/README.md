**Assignment 3**

Example invocation (project root)

`mvn clean package`

`java -jar target/assignment3-0.0.1-SNAPSHOT.jar`

**Usage**

POST http://localhost:8080/api/rest/v1/calculate/polish

Content-Type: application/json

Body:

```
{
  "expression": "- 2e3 - 700 + 7 * 2 15"
}
```
