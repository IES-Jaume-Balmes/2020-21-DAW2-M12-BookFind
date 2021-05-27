--------------Category
INSERT INTO CATEGORY
VALUES (1, 'Classics');
/*INSERT INTO CATEGORY(CATEGORY)
 VALUES ('Horror');
 INSERT INTO CATEGORY(CATEGORY)
 VALUES ('Science Fiction');
 INSERT INTO CATEGORY(CATEGORY)
 VALUES ('Romance');*/
-----------Author
INSERT INTO AUTHOR
VALUES (1, 'Jane', 'Austen');
-----------Books
INSERT INTO BOOK (
                BOOK_ID,
                DESCRIPTION,
                IMAGE,
                ISBN,
                TITLE,
                PRICE,
                PUBLISHED_DATE,
                PRODUCT_STOCK,
                AUTOR_AUTHOR_ID
        )
VALUES (
                1,
                'Novela romantica',
                'orgulloyprejuicio.jpg',
                '9783161444484100',
                'Orgullo y prejuicio ',
                10.99,
                '1885-10-12',
                100,
                1
        );
INSERT INTO BOOK (
                BOOK_ID,
                DESCRIPTION,
                IMAGE,
                ISBN,
                TITLE,
                PRICE,
                PUBLISHED_DATE,
                PRODUCT_STOCK,
                AUTOR_AUTHOR_ID
        )
VALUES (
                2,
                'Descripcion 25',
                '',
                '9783161444484101',
                'Interface Circuits for Microsensor Integrated Systems',
                13.99,
                '1875-10-12',
                103,
                1
        );
INSERT INTO BOOK (
                BOOK_ID,
                DESCRIPTION,
                IMAGE,
                ISBN,
                TITLE,
                PRICE,
                PUBLISHED_DATE,
                PRODUCT_STOCK,
                AUTOR_AUTHOR_ID
        )
VALUES (
                3,
                'Descripcion 26',
                '',
                '9783161444484102',
                'libro 28',
                1.99,
                '1875-10-11',
                103,
                1
        );
INSERT INTO BOOK (
                BOOK_ID,
                DESCRIPTION,
                IMAGE,
                ISBN,
                TITLE,
                PRICE,
                PUBLISHED_DATE,
                PRODUCT_STOCK,
                AUTOR_AUTHOR_ID
        )
VALUES (
                4,
                'Descripcion 256',
                '',
                '9783161444484152',
                'libro 25',
                18.99,
                '1875-10-12',
                103,
                1
        );
/*INSERT INTO BOOK (BOOK_ID, AUTHOR, DESCRIPTION, IMAGE, ISBN, TITLE, PRICE, PUBLISHED_DATE, PRODUCT_STOCK)
 VALUES (1, 'ddsfa', 'science fiction novel by American author Orson Scott Card', 'ender_games.jpg',
 '9783161444484100', 'Enders Game ', 10, '1985-10-12', 100);
 
 INSERT INTO BOOK (BOOK_ID, AUTHOR, DESCRIPTION, IMAGE, ISBN, TITLE, PRICE, PUBLISHED_DATE, PRODUCT_STOCK)
 VALUES (2, 'ssdsd',
 'La historia es narrada por Jane Eyre quien a los diez años de edad es custodiada por su tía política, la señora Reed. El señor Reed, hermano de la madre de Jane, la toma a su cargo cuando queda huérfana, pero muriendo él mismo poco después',
 'Jane_Eyre.jpg',
 '9783491484444100', 'Jane Eyre', 15.99, '1847-01-01', 100);*/
--------------Category
INSERT INTO BOOK_CATEGORIES
VALUES (1, 1);
/*INSERT INTO BOOK_CATEGORIES
 VALUES (2, 1);----jane eyre have two categories, romance and classic
 INSERT INTO BOOK_CATEGORIES
 VALUES (2, 2);----jane eyre have two categories, romance and classic
 INSERT INTO BOOK_CATEGORIES
 VALUES (1, 2);----jane eyre have two categories, romance and classic
 INSERT INTO BOOK_CATEGORIES
 VALUES (2, 4);
 INSERT INTO BOOK_CATEGORIES
 VALUES (1, 3);*/
/*select * from BOOK_CATEGORIES JOIN BOOK ON BOOK_ID = BOOK_BOOK_ID JOIN CATEGORY ON CATEGORY_ID = CATEGORIES_CATEGORY_ID*/