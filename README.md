# MFPE-Audit-Management

This is the MFPE Audit Management System Project.

## The Team Members are Menaka, Ruksana, Harsh, Vaishnavi and Hriday.

## Name     -    Microservice

Menaka   -   Audit CheckList

Ruksana  -   Audit Severity

Harsh    -  Audit Benchmark

Vaishnavi-  Audit-Management-App

Hriday   -   Authorization (JWT)

### Audit-Authorization-Microservice :
  This module is used for doing the **Authentication** and **Authorization** part of our project. 
  This microsevice provides the endpoints for authentication and validation. This MS creates JWTs(JSON Web Token)
  for a authenticated user who is in Database and then it validates the user based on the JWT token passed in the
  "Authentication"-Request-Header.("Bearer j.w.t...")

  * #### Postman details : 
    <table>
        <thead>
            <th>Method</th>
            <th>Postman URL</th>
            <th>Returns</th>
        </thead>
        <tbody>
            <tr>
                <td>GET</td>
                <td>http://localhost:8100/auth/health-check</td>
                <td>String</td>
            </tr>
            <tr>
                <td>POST</td>
                <td>http://localhost:8100/auth/authenticate</td>
                <td>JWT Bearer Token</td>
            </tr>
            <tr>
                <td>POST</td>
                <td>http://localhost:8100/auth/validate</td>
                <td>The Manager details</td>
            </tr>
        </tbody>
    </table>

### Audit-Checklist-Microservice :
  This module is used for retrieving the *List of Questions based on the user's request* for each *Audit Type* from the H2 in-memory database.
  This microservice is used by the Audit-Benchmark Microservice to store and retrieve the no of acceptable NOs for each Audit Type
  This microsevice is used by the Audit-Severity Microservice to evaluate the status of a project and provide an appropriate response.

  * #### --Endpoints : 
    <table>
        <thead>
            <th>Method</th>
            <th>Endpoint Path</th>
            <th>Returns</th>
        </thead>
        <tbody>
            <tr>
                <td>GET</td>
                <td>/AuditChecklist</td>
                <td>Displays the list of Questions</td>
            </tr>
        </tbody>
    </table>

  * #### --Dependencies on Other microsevices : *Authorization Microservice*

### MFPE-Audit-Management-Benchmark microservice

Harsh Goyel,2048714
CDE|IJ023

Audit Benchmark is a middleware microservice.
This microservice stores the number of acceptable “No” in the database.
Upon request it returns data as a list in a user-defined AuditBenchmark datatype.
It is used to pass the number of  acceptable “No” or the benchmark, in other words, to audit severity microservice.
Method:
GET:/AuditBenchmark:

### Audit-Severity-Microservice :
  This module is used for checking the severity of the audit by invoking the *Benchmark* and *Checklist*  Microservice as Request from the portal.
  This microservice will return the status of the audit response by giving the project execution status and the remedial action.

  * #### --Endpoints : 
    <table>
        <thead>
            <th>Method</th>
            <th>Endpoint Path</th>
            <th>Returns</th>
        </thead>
        <tbody>
            <tr>
                <td>POST</td>
                <td>/ProjectExecutionStatus</td>
                <td>Audit Severity</td>
            </tr>
        </tbody>
    </table>

  * #### --Dependencies on Other microsevices : *Audit-Authorization,Audit-Checklist,Audit-Benchmark*
