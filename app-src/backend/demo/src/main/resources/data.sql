--------------Category
INSERT INTO category
VALUES (1, 'Classics');

INSERT INTO category
VALUES (2, 'Horror');

INSERT INTO category
VALUES (3, 'Science Fiction');

INSERT INTO category
VALUES (4, 'Romance');

INSERT INTO category
VALUES (5, 'Art');

INSERT INTO category
VALUES (6, 'Historical Fiction');


INSERT INTO category
VALUES (7, 'History');

INSERT INTO category
VALUES (8, 'Fantasy');

INSERT INTO category
VALUES (9, 'Fiction');

INSERT INTO category
VALUES (10, 'Mystery');

INSERT INTO category
VALUES (11, 'Nonfiction');

INSERT INTO category
VALUES (12, 'Poetry');

INSERT INTO category
VALUES (13, 'Thriller');
INSERT INTO category
VALUES (14, 'Suspense');
INSERT INTO category
VALUES (15, 'Novel');
INSERT INTO category
VALUES (16, 'Biography');


INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (1, 'Harper Lee');
INSERT INTO book (book_id,
                  author_id,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (1, 1,
        'The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it. "To Kill A Mockingbird" became both an instant bestseller and a critical success when it was first published in 1960. It went on to win the Pulitzer Prize in 1961 and was later made into an Academy Award-winning film, also a classic.',
        'To_Kill_a_Mockingbird.jpg',
        '9787620081527',
        'To Kill a Mockingbird',
        11.21,
        '1960-01-01',
        100,
        324);
INSERT INTO book_categories
VALUES (1, 1);
INSERT INTO book_categories
VALUES (1, 14);
INSERT INTO book_categories
VALUES (1, 15);
--2
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (2, 'F. Scott Fitzgerald');
INSERT INTO book (book_id,
                  author_id,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (2, 2,
        'The Great Gatsby, F. Scott Fitzgerald''s third book, stands as the supreme achievement of his career. This exemplary novel of the Jazz Age has been acclaimed by generations of readers. The story is of the fabulously wealthy Jay Gatsby and his new love for the beautiful Daisy Buchanan, of lavish parties on Long Island at a time when The New York Times noted "gin was the national drink and sex the national obsession," it is an exquisitely crafted tale of America in the 1920s.
The Great Gatsby is one of the great classics of twentieth-century literature.', 'The_Great_Gatsby.jpg',
        '0743273567',
        'The Great Gatsby',
        6.09,
        '1925-01-01',
        100,
        200);
INSERT INTO book_categories
VALUES (2, 1);
INSERT INTO book_categories
VALUES (2, 15);
