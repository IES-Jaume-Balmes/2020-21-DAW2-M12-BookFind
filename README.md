[![Contributors][contributors-shield]][contributors-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind/">
    <img src="https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind/blob/main/docs/img/inicio.jpg" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">BookFind</h3>

  <p align="center">
    Web application developed with spring and vue.js, this application was designed with the purpose of manage a bookstore, sales and user control also provide an excellent customer experience
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template">View Demo</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Report Bug</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Request Feature</a>
  </p>


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
  <!--   <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>-->
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
 <li><a href="#api">How to use</a> <ul>
        <li><a href="#built-with">Api endpoints</a></li>
      </ul>
</li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->

# About The Project

bookfind is a web application that have its own database, with bookfind a costumer can buy books directly on the
website.

### Documentation:

https://ies-jaume-balmes.github.io/2020-21-DAW2-M12-BookFind/

### The main functionalities consist on:

* the user can sign up, search for books using filters and even put a rating to the bought books  :smile:

### Functionality:

There will be 2 user profiles, normal customer and administrator.

### Normal user:

* Registration: the user must be able to sign up.
* Unsubscribe: a user who has registered must be able to unsubscribe (delete).
* Login: the registered user must be able to log in.
* Logout: the user must be able to log out.

### Books:

* Search: a registered user must be able to search the books in the database.
* Buy: the user must be able to buy a selected book
* Rate: the user must be able to rating books

## Built With

Here you will find a list of some of technologies used in this project.

* [Spring](https://spring.io/)
* [Vue.js](https://vuejs.org/)

## Application architecture

[![Web architecture][web-architecture]](https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind/blob/main/docs/img/bd.png)

## Roadmap

See the [open issues](https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind/issues) for a list of proposed
features (and known issues).






<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->

## Members

* Pol Barcia - [@PolBarcia](https://github.com/PolBarcia) - pbarcia18@jaumebalmes.net
* Christian Miranda - [cmiran0](https://github.com/cmiran0) - cmidand0@jaumebalmes.net
* Barbara Herrera - [@barbarahf](https://github.com/barbarahf) - bherrera19@jaumebalmes.net

## Mentor

* Pere Guitart Colom

<!-- api -->

## ENDPOINTS

### 1) Book controller

Spring automatically handles the numbers, that is, negative or very large numbers will not give an error. The variables
pageSize and pageNumber are set in spring properties.

a) Returns by pagination --> METHOD:GET

    books/page?pageSize=0&pageNumber=12

b) Returns the pages with "sort", in this case by id (choose the parameter) and in form (desc) --> METHOD:GET

    books/page?pageSize=0&pageNumber=12&sort=id,desc

c) Books ascending price --> METHOD:GET

    /books/price-asc

d) Books desc price --> METHOD:GET

    /books/price-desc

e) Returns 1 book by id --> METHOD:GET

     books/{id num}

### Admin BOOK endpoints

a) Crear a book books/new --> METHOD:POST

    books/new

    Postman example:
    {   
    "bookId":555,
    "isbn":"123",
    "image":"cccc",
    "title":"titulo",
    "publishedDate":"1847-01-01",
        "author":--> Object author 
    "description":"description",
    "price":15
    }

b)Upate book (pass book object as parameter) --> METHOD:PUT

    books/update

c) delate a book by its id --> METHOD:DELETE

    books/delate/{id}

### 2) Cart controller  

a) Get the actual user cart (MUST BE LOGEDIN, USER)-->METHOD:GET

    /cart

b) Add new lineItems (books, products) to the actual logedin user -->METHOD:POST

    /cart/add

    Postman example:
    {
    "quantity":5,
    "productId":1
    }

c)Change the quantity of lineItems (book) you will buy -->METHOD:PUT

      cart/{itemId}

        PUT BODY NEEDS A NUMBER (IS THE NUMBER OF THE NEW QUANTITY OF "LINE ITEMS"

        FOREXAMPLE, LINEITEM IS 5 OF PRIDE AND PREJUDICE (5 BOOKS OF PRIDE AND PREJUDICE) AND NOW I JUST WANT 1, THE PUT BODY IS A 1
        
        PUT BODY:

        1

        The id is the id of the lineItem object


        this method returns the new lineitem (modified) in json

d) Delete an LineItem from the cart -->METHOD:DELETE

    /cart/{itemId}
e) Check out and create a new order (buy) -->METHOD:POST
    
    /cart/checkout

### 3) CATEGORY CONTROLLER (CLASSIC BOOK, ROMANTIC NOVEL, ETC)
a)  Get all books category -->METHOD:GET

        books/category?pageSize=0&pageNumber=12&sort=id,desc
        sort is optional
b) Return pagination by category -->METHOD:GET
    
    books/category/{type}
    example: books/category/classic?pageSize=0&pageNumber=12&sort=id,desc
                
### 4) User controller
a) Create a new user METHOD:POST
    
    /user/sign-up
    IMPORTANT: THIS WILL SEND AN EMAIL WITH TOKEN AUTH, IF YOU DONT ACEP IT, THE USER CAN NOT LOGIN
    POSTMAN EXAMPLE:
    
    {
    "firstName":"TOM",
    "lastName":"CAT",
    "username":"tomcat",
    "password":"123456",
    "email":"tomcat@gmail.com",
    "phone":"888999977"
    }

b) login
    
    /login
c) logout

    /logout

d)


Project
Link: [https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind](https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind)


<!-- ACKNOWLEDGEMENTS -->

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge

[contributors-url]: https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind/graphs/contributors


[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge

[stars-url]: https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind/stargazers

[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge

[issues-url]: https://github.com/othneildrew/Best-README-Template/issues

[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge

[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555

[linkedin-url]: https://linkedin.com/in/othneildrew

[product-screenshot]: images/screenshot.png

[web-architecture]: https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind/tree/main/Docs/architecture.png