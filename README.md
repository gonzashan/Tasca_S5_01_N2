# Tasca_S5_01_N2 
## Exercici API Rest CRUD amb MySQL

![N|Solid](https://logistreak.com/images/icon/mysql.png)
 <img src="https://www.yihaomen.com/static/upload/mkyong/201908/spring-thymeleaf.png" style="border-radiux: 10px;" height="140" width="360" >

En aquesta tasca faràs un CRUD (Create, Read, Update, Delete) que pugui ser cridat com a API Rest i, també, com aplicació web..



## Objetius
- Protocol HTTP / REST.
- JPA.
- CRUD amb Spring.
- MySQL.
- Thymeleaf.


Tenim una entitat anomenada FlorEntity, que disposa de les següents propietats:

- Integer pk_FlorID
- String nomFlor
- String paisFlor

També tenim una DTO anomenada FlorDTO, que tindrà les mateixes propietats que l’entitat Sucursal, afegint-ne una:

-  String tipusFlor.

Aquesta propietat, en funció del país d'origen de la flor, haurà d’indicar si és “UE” o “Fora UE”. Per a fer això, pots tenir una llista privada a la mateixa DTO (per exemple: List<String> països), amb els països que formen part de la UE.

Aprofitant l’especificació JPA, hauràs de persistir l’entitat FlorEntity a una base de dades MySQL, seguint el patró MVC.

El consell és que FlorDTO la facis servir al Controller, i FlorEntity al Repository. La capa de serveis serà l’encarregada de fer la traducció entre les dues.

Per a això, depenent del package principal, crearàs una estructura de packages, on ubicaràs les classes que necessitis:

-   cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers
-   cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain
-   cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto
-   cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.services
-   cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository
 
    <img src="https://github.com/gonzashan/Tasca_S5_T01_N2/blob/main/screen-shots/tree.png" height="387" width="340" >

 
La classe ubicada al paquet controllers (FlorController, per exemple), haurà de ser capaç de donar resposta a les següents peticions per actualitzar i consultar informació:

    http://localhost:9001/flor/add
    http://localhost:9001/flor/getOne/{id}
    http://localhost:9001/flor/getAll
    http://localhost:9001/flor/update
    http://localhost:9001/flor/delete/{id}
    

# Resultats       
       http://localhost:9001/flor/add
 <img src="https://github.com/gonzashan/Tasca_S5_T01_N2/blob/main/screen-shots/add.png" height="490" width="650" >
   
       http://localhost:9001/flor/getOne/{id}
 <img src="https://github.com/gonzashan/Tasca_S5_T01_N2/blob/main/screen-shots/getOne.png" height="490" width="650" >
   
       http://localhost:9001/flor/getAll
 <img src="https://github.com/gonzashan/Tasca_S5_T01_N2/blob/main/screen-shots/getAll.png" height="490" width="650" >
   
       http://localhost:9001/flor/update
 <img src="https://github.com/gonzashan/Tasca_S5_T01_N2/blob/main/screen-shots/update.png" height="490" width="650" >
   
       http://localhost:9001/flor/getOne{id}ERROR
 <img src="https://github.com/gonzashan/Tasca_S5_T01_N2/blob/main/screen-shots/getOne-Error.png" height="490" width="650" >
   
       http://localhost:9000/sucursal/delete/{id}      
 <img src="https://github.com/gonzashan/Tasca_S5_T01_N2/blob/main/screen-shots/delete.png" height="491" width="650" >
