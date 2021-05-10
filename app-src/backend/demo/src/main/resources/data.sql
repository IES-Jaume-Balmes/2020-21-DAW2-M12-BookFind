--------------Category
INSERT INTO CATEGORY
VALUES (1, 'Classics');
INSERT INTO CATEGORY
VALUES (2, 'Horror');
INSERT INTO CATEGORY
VALUES (3, 'Science Fiction');
INSERT INTO CATEGORY
VALUES (4, 'Romance');

-----------Books

INSERT INTO BOOK (BOOK_ID, AUTHOR, DESCRIPTION, IMAGE, ISBN, TITLE, PRICE, PUBLISHED_DATE)
VALUES (1, 'Orson Scott Card', 'science fiction novel by American author Orson Scott Card', 'ender_games.jpg',
        '9783161484100', 'Enders Game ', 9.99, '1985-10-12');

INSERT INTO BOOK (BOOK_ID, AUTHOR, DESCRIPTION, IMAGE, ISBN, TITLE, PRICE, PUBLISHED_DATE)
VALUES (2, 'Charlotte Bronte',
        'La historia es narrada por Jane Eyre quien a los diez años de edad es custodiada por su tía política, la señora Reed. El señor Reed, hermano de la madre de Jane, la toma a su cargo cuando queda huérfana, pero muriendo él mismo poco después',
        'Jane_Eyre.jpg',
        '9783491484100', 'Jane Eyre', 15.99, '1847-01-01');

--------------Category
INSERT INTO BOOK_CATEGORIES
VALUES (2, 1);----jane eyre have two categories, romance and classic
INSERT INTO BOOK_CATEGORIES
VALUES (2, 4);
INSERT INTO BOOK_CATEGORIES
VALUES (1, 3);

/*select * from BOOK_CATEGORIES JOIN BOOK ON BOOK_ID = BOOK_BOOK_ID JOIN CATEGORY ON CATEGORY_ID = CATEGORIES_CATEGORY_ID*/

