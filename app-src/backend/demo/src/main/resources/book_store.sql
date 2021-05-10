/*DROP
DATABASE book_find;
CREATE
DATABASE book_find;
USE
book_find;
CREATE TABLE Category
(
    id            int      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_category CHAR(60) NOT NULL
);

CREATE TABLE Book
(
    id             int             NOT NULL AUTO_INCREMENT PRIMARY KEY,
    isbn           CHAR(25) UNIQUE NOT NULL,
    title          char(50)        NOT NULL,
    author         char(50)        NOT NULL,
    date_published DATE            NOT NULL,
    genre          int             NOT NULL,
    img_name       char(100)       NOT NULL,
    id_category    int,
    FOREIGN KEY (id_category) REFERENCES Category (id)
);

CREATE TABLE User
(
    id         int             NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login_id   CHAR(100),
    user_name  CHAR(50) UNIQUE NOT NULL,
    email      char(50) UNIQUE NOT NULL,
    phone      char(50),
    user_admin BOOLEAN         NOT NULL,
    password   char(50)
);

CREATE TABLE Cart
(
    id         int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created    DATE,
    iva_amount DECIMAL
);

CREATE TABLE Order_status
(
    id     int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    status CHAR(50),
   
);

CREATE TABLE Order_created
(
    id      int      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    number  CHAR(50),
    ordered DATE     NOT NULL,
    shipped DATE     NOT NULL,
    ship_to CHAR(70) NOT NULL,
    status  int      NOT NULL,
    FOREIGN KEY (status) REFERENCES Order_status (id)
);


CREATE TABLE LineItem
(
    id       int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantity int,
    price    float,
    order_id int NOT NULL,
    book_id  int NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Order_created (id),
    FOREIGN KEY (book_id) REFERENCES Book (id)
);*/