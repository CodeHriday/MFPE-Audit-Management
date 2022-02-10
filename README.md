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
### Audit Benchmark Microservice:
