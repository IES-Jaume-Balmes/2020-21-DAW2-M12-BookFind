--------------Category
INSERT INTO category
VALUES (1, 'Classics');
INSERT INTO category
VALUES (2, 'Horror');
INSERT INTO category
VALUES (3, 'Science_Fiction');
INSERT INTO category
VALUES (4, 'Romance');
INSERT INTO category
VALUES (5, 'Art');
INSERT INTO category
VALUES (6, 'Historical_Fiction');
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
INSERT INTO category
VALUES (17, 'Mind,_body_and_spirit');
INSERT INTO category
VALUES (18, 'Crimes_and_mystery');
INSERT INTO category
VALUES (19, 'Literary_essays');
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (1, 'Harper Lee');
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                1,
                1,
                'The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it. "To Kill A Mockingbird" became both an instant bestseller and a critical success when it was first published in 1960. It went on to win the Pulitzer Prize in 1961 and was later made into an Academy Award-winning film, also a classic.',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '9787620081527',
                'To Kill a Mockingbird',
                11.21,
                '1960-01-01',
                100,
                324
        );
INSERT INTO book_categories
VALUES (1, 1);
INSERT INTO book_categories
VALUES (1, 14);
INSERT INTO book_categories
VALUES (1, 15);
--2
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (2, 'F. Scott Fitzgerald');
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                2,
                2,
                'The Great Gatsby, F. Scott Fitzgerald''s third book, stands as the supreme achievement of his career. This exemplary novel of the Jazz Age has been acclaimed by generations of readers. The story is of the fabulously wealthy Jay Gatsby and his new love for the beautiful Daisy Buchanan, of lavish parties on Long Island at a time when The New York Times noted "gin was the national drink and sex the national obsession," it is an exquisitely crafted tale of America in the 1920s.
The Great Gatsby is one of the great classics of twentieth-century literature.',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '0743273567',
                'The Great Gatsby',
                6.09,
                '1925-01-01',
                100,
                200
        );
INSERT INTO book_categories
VALUES (2, 1);
INSERT INTO book_categories
VALUES (2, 15);
--3
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (3, 'Paz Padilla');
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                3,
                3,
                'En El humor de mi vida no esperéis encontrar una morbosa tragedia romántica de sufrimiento y dolor. Si era justo lo deseado, Shakespeare está al fondo del tercer pasillo, en el segundo estante a mano derecha. ',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '0-3483-9987-1',
                'El humor de mi vida',
                18.90,
                '2021-04-07',
                100,
                272
        );
INSERT INTO book_categories
VALUES (3, 17);
--4
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (4, 'María Dueñas');
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                4,
                4,
                'Cuatro destinos. Dos misiones. Una mujer.Vuelve a sumergirte en un tiempo inolvidable.Después de El tiempo entre costuras, SIRA, la nueva novela de María Dueñas. La Segunda Gran Guerra llega a su fin y el mundo emprende una tortuosa reconstrucción. Concluidas sus funciones como colaboradora de los Servicios Secretos británicos, Sira afronta el futuro con ansias de serenidad. No lo logrará, sin embargo.',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '0-1271-8027-3',
                'Sira',
                21.76,
                '2021-04-14',
                100,
                648
        );
INSERT INTO book_categories
VALUES (4, 3);
--5
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (5, 'Javier Castillo');
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                5,
                5,
                'Después de alcanzar el millón de ejemplares vendidos, Javier Castillo pone en jaque al lector en su quinta novela¿Quieres jugar?Nueva York, 2011. Una chica de quince años aparece crucificada en un suburbio a las afueras. Miren Triggs, periodista de investigación del Manhattan Press, recibe de manera inesperada un extraño sobre.',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '0-3790-0083-0',
                'El juego del alma',
                17.95,
                '2021-03-15',
                100,
                528
        );
INSERT INTO book_categories
VALUES (5, 10);
INSERT INTO book_categories
VALUES (5, 13);
INSERT INTO book_categories
VALUES (5, 18);
--6
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (6, 'Elísabet Benavent');
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                6,
                6,
                'Una aspirante a actriz cansada de hacer castings...Un artista reconocido en plena crisis creativa...Unos valiosos cuadros encontrados en un desván...Y el arte del engaño para cambiar las leyes del karma.',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '0-3912-4458-2',
                'El arte de engañar al karma',
                17.95,
                '2021-04-8',
                100,
                696
        );
INSERT INTO book_categories
VALUES (6, 3);
--7
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (7, 'Ariana Godoy');
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                7,
                7,
                '¡Llega por fin la novela juvenil que está triunfando en Wattpad! Raquel lleva toda la vida loca por Ares, su atractivo y misterioso vecino. Lo observa sin ser vista desde su ventana y es que, muy a su pesar, no han intercambiado ni una triste palabra. Lo que Raquel no sabe es que eso está a punto de cambiar... Ares comenzará a cruzarse en su camino hasta en los lugares más inesperados y descubrirá que, en realidad, Raquel no es la niña inocente que creía. ',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '0-2845-0443-2',
                'A través de mi ventana',
                18,
                '2019-05-16',
                100,
                416
        );
INSERT INTO book_categories
VALUES (7, 4);
--8
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (8, 'Lorenzo Silva');
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                8,
                8,
                'La épica revuelta de las gentes de Castilla contra el abuso de poder de Carlos v culminó en la batalla de Villalar, el 23 de abril de 1521. Las tropas imperiales arrollaron a las de las Comunidades de Castilla y decapitaron a sus principales capitanes: Padilla, Bravo y Maldonado. Aquella jornada marcó el declive definitivo de un próspero reino que se extendía a lo largo de tres continentes y cuya disolución dio lugar a un nuevo Imperio que se sirvió de sus gentes y sus recursos.',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '0-5030-5439-9',
                'Castellano',
                19.85,
                '2021-05-05',
                100,
                368
        );
INSERT INTO book_categories
VALUES (8, 7);
INSERT INTO book_categories
VALUES (8, 9);
--9
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                9,
                7,
                'Una de las historias más exitosas de Wattpad con millones de lectores: una historia altamente adictiva de una de las autoras estrella de la plataforma, Ariana Godoy. El pueblo de Wilson es tranquilo, regido por unas costumbres y creencias religiosas muy estrictas, donde Leigh ha crecido, siguiendo cada regla y pauta como se le ha indicado.',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '0-9700-7505-7',
                'Heist',
                17.05,
                '2021-05-06',
                100,
                448
        );
INSERT INTO book_categories
VALUES (9, 4);
--10
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (10, 'Irene Vallejo Moreu');
INSERT INTO book (
                book_id,
                author_id,
                description,
                image,
                isbn,
                title,
                price,
                published_date,
                product_stock,
                num_of_pages
        )
VALUES (
                10,
                10,
                'Este es un libro sobre la historia de los libros. Un recorrido por la vida de ese fascinante artefacto que inventamos para que las palabras pudieran viajar en el espacio y en el tiempo. La historia de su fabricación, de todos los tipos que hemos ensayado a lo largo de casi treinta siglos: libros de humo, de piedra, de arcilla, de juncos, de seda, de piel, de árboles y, los últimos llegados, de plástico y luz.',
                'https://i.picsum.photos/id/527/282/450.jpg?hmac=zhJViD1L3DLE2FjdU99-50WMTc2T_fzm2Bn2Uv7FPPE',
                '0-4014-9427-6',
                'El infinito en un junco: La invención de los libros en el mundo antiguo',
                23.70,
                '2019-09-18',
                100,
                452
        );
INSERT INTO book_categories
VALUES (10, 18);