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
INSERT INTO category

VALUES (17, 'Mind, body and spirit');

INSERT INTO category
VALUES (18, 'Crimes and mystery');

INSERT INTO category
VALUES (19, 'Literary essays');





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
                'https://i.picsum.photos/id/717/282/450.jpg?hmac=O0ZyNq5DwcfyhIBfCyMUCtV5xzYk31JCXld-uyo8BlY',
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
                'https://i.picsum.photos/id/90/282/450.jpg?hmac=InXYyQFmsDwP65jhQVJCHhTis8OlRtMJblJaZo-F6K4',
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
                'https://i.picsum.photos/id/154/282/450.jpg?hmac=sJz9mkH6aaAT8og5UJ3rYHNocrH7m7iybCd94pozWCI',
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
                'https://i.picsum.photos/id/182/282/450.jpg?hmac=sz5qk2IJoVEdphFDFn-Un3sVxsbVnfZ9rJYG6cjxRTY',
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
                'https://i.picsum.photos/id/382/282/450.jpg?hmac=gpRwbU841EfVpZuyBGlLkeFx7H1KP32wA5hl9IUAzbE',
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
                'https://i.picsum.photos/id/408/282/450.jpg?hmac=37tuVksPdpIXcGwWzYwmCvpAuSLDK0uCSxkGmknBY2w',
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
                'https://i.picsum.photos/id/358/282/450.jpg?hmac=1mKJr1AjY9wzW2Fi1FkhLLwND0PwJkox6sSjZHvmHzw',
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
                'https://i.picsum.photos/id/743/282/450.jpg?hmac=Rn63uojbCjIZYReHk77j1-Bs73SqE7pMehqSnbaT0dY',
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
values (9, 'Irene Vallejo Moreu');
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
                'https://i.picsum.photos/id/475/282/450.jpg?hmac=shiwrNipzuRpd4qnAskNwV_U_0wVyWuB95BZpOIyTXM',
                '0-4014-9427-6',
                'El infinito en un junco: La invención de los libros en el mundo antiguo',
                23.70,
                '2019-09-18',
                100,
                452
        );
INSERT INTO book_categories
VALUES (10, 18);

--11
INSERT INTO AUTHOR (AUTHOR_ID, NAME)
values (10, 'J. K. Rowling');
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
                11,
                10,
                '"Con las manos temblorosas, Harry le dio la vuelta al sobre y vio un sello de lacre púrpura con un escudo de armas: un león, un águila, un tejón y una serpiente, que rodeaban una gran letra H." Harry Potter nunca ha oído hablar de Hogwarts hasta que empiezan a caer cartas en el felpudo del número 4 de Privet Drive. Llevan la dirección escrita con tinta verde en un sobre de pergamino amarillento con un sello de lacre púrpura, y sus horripilantes tíos se apresuran a confiscarlas. Más tarde, el día que Harry cumple once años, Rubeus Hagrid, un hombre gigantesco cuyos ojos brillan como escarabajos negros, irrumpe con una noticia extraordinaria: Harry Potter es un mago, y le han concedido una plaza en el Colegio Hogwarts de Magia y Hechicería. ¡Está a punto de comenzar una aventura increíble!',
                'https://i.picsum.photos/id/313/282/450.jpg?hmac=pByXORQgx5xJp9J1XfU_BjgDnOj6vqt3m6xJ6zAoCVQ',
                '0-9916-3885-9',
                'HARRY POTTER Y LA PIEDRA FILOSOFAL',
                14.25,
                '1999-03-01',
                100,
                264
        );
INSERT INTO book_categories
VALUES (11, 8);
INSERT INTO book_categories
VALUES (11, 10);

--12
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
                12,
                10,
                'El verano de Harry Potter ha incluido el peor cumpleaños de su vida, las funestas advertencias de un elfo doméstico llamado Dobby y el rescate de casa de los Dursley protagonizado por su amigo Ron Weasley al volante de un coche mágico volador. De vuelta en el Colegio Hogwarts de Magia y Hechicería, donde va a empezar su segundo curso, Harry oye unos extraños susurros que resuenan por los pasillos vacíos. Y entonces empiezan los ataques y varios alumnos aparecen petrificados... Por lo visto, las siniestras predicciones de Dobby se están cumpliendo....',
                'https://i.picsum.photos/id/125/282/450.jpg?hmac=gQBA2omrDPbzEoI78Q7_p9J4KmMHKBLT4mflCBwqNkA',
                '0-4486-3890-8',
                'HARRY POTTER Y LA CAMARA SECRETA',
                15.20,
                '1999-10-18',
                100,
                296
        );
INSERT INTO book_categories
VALUES (12, 8);
INSERT INTO book_categories
VALUES (12, 10);

--13
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
                13,
                10,
                'Cuando el autobús noctámbulo irrumpe en una calle oscura y frena con fuertes chirridos delante de Harry, comienza para él un nuevo curso en Hogwarts, lleno de acontecimientos extraordinarios. Sirius Black, asesino y seguidor de lord Voldemort, se ha fugado, y dicen que va en busca de Harry. En su primera clase de Adivinación, la profesora Trelawney ve un augurio de muerte en las hojas de té de la taza de Harry... Pero quizá lo más aterrador sean los dementores que patrullan por los jardines del colegio, capaces de sorberte el alma con su beso...',
                'https://i.picsum.photos/id/1005/282/450.jpg?hmac=5FFna0PwMRF3kG4LqOeWnhOIkee_ZucBsaBtxMIj5X0',
                '0-3460-1505-7',
                'HARRY POTTER Y EL PRISIONERO DE AZKABAN',
                17.10,
                '2000-10-01',
                100,
                360
        );
INSERT INTO book_categories
VALUES (13, 8);
INSERT INTO book_categories
VALUES (13, 10);

--14
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
                14,
                10,
                'Se va a celebrar en Hogwarts el Torneo de los Tres Magos. Sólo los alumnos mayores de diecisiete años pueden participar en esta competición, pero, aun así, Harry sueña con ganarla. En Halloween, cuando el cáliz de fuego elige a los campeones, Harry se lleva una sorpresa al ver que su nombre es uno de los escogidos por el cáliz mágico. Durante el torneo deberá enfrentarse a desafíos mortales, dragones y magos tenebrosos, pero con la ayuda de Ron y Hermione, sus mejores amigos, ¡quizá logre salir con vida!',
                'https://i.picsum.photos/id/829/282/450.jpg?hmac=lAWFsx4mlbS0bycxA6pRW7T4P24PvlauEyhkt8tjX0k',
                '0-9186-2875-X',
                'HARRY POTTER Y EL CALIZ DE FUEGO',
                21.85,
                '2001-03-09',
                100,
                672
        );
INSERT INTO book_categories
VALUES (14, 8);
INSERT INTO book_categories
VALUES (14, 10);

--15
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
                15,
                10,
                'Son malos tiempos para Hogwarts. Tras el ataque de los dementores a su primo Dudley, Harry Potter comprende que Voldemort no se detendrá ante nada para encontrarlo. Muchos niegan que el Señor Tenebroso haya regresado, pero Harry no está solo: una orden secreta se reúne en Grimmauld Place para luchar contra las fuerzas oscuras. Harry debe permitir que el profesor Snape le enseñe a protegerse de las brutales incursiones de Voldemort en su mente. Pero éstas son cada vez más potentes, y a Harry se le está agotando el tiempo...',
                'https://i.picsum.photos/id/634/282/450.jpg?hmac=-c221_Qw_aPZzg4kMtabRSbsBRCJ_CVKHHrezd1X8vg',
                '0-1734-0837-0',
                'HARRY POTTER Y LA ORDEN DEL FENIX',
                23.75,
                '2004-02-21',
                100,
                928
        );
INSERT INTO book_categories
VALUES (15, 8);
INSERT INTO book_categories
VALUES (15, 10);

--16
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
                16,
                10,
                'Con dieciseis años cumplidos, Harry inicia el sexto curso en Hogwarts en medio de terribles acontecimientos que asolan Inglaterra. Elegido capitán del equipo de quidditch, los ensayos, los exámenes y las chicas ocupan todo su tiempo, pero la tranquilidad dura poco. A pesar de los ferreos controles de seguridad que protegen la escuela, dos alumnos son brutalmente atacados. Dumbledore sabe que se acerca el momento, anunciado por la Profecía, en que Harry y Voldemort se enfrentarán a muerte: "El único con poder para vencer al Señor Tenebroso se acerca... Uno de los dos debe morir a manos del otro, pues ninguno de los dos podrá vivir mientras siga el otro con vida."',
                'https://i.picsum.photos/id/13/282/450.jpg?hmac=nGHkUnpMgRLTAqXKs0deqrx-M5-UAgyMbhiPCzuP2-g',
                '0-2635-7992-1',
                'HARRY POTTER Y EL MISTERIO DEL PRINCIPE',
                20.90,
                '2006-02-23',
                100,
                576
        );
INSERT INTO book_categories
VALUES (16, 8);
INSERT INTO book_categories
VALUES (16, 10);

--17
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
                17,
                10,
                'Cuando se monta en el sidecar de la moto de Hagrid y se eleva en el cielo, dejando Privet Drive por última vez, Harry Potter sabe que lord Voldemort y sus mortífagos se hallan cerca. El encantamiento protector que había mantenido a salvo a Harry se ha roto, pero el no puede seguir escondiendose. El Señor Tenebroso se dedica a aterrorizar a todos los seres queridos de Harry, y, para detenerlo, este habrá de encontrar y destruir los horrocruxes que quedan. La batalla definitiva debe comenzar: Harry tendrá que alzarse y enfrentarse a su enemigo...',
                'https://i.picsum.photos/id/847/282/450.jpg?hmac=VTmvlYIglbFNOTHDMqKcuBtEKl9E_idHsf7Dgx2llyw',
                '0-2304-6692-3',
                'HARRY POTTER Y LAS RELIQUIAS DE LA MUERTE',
                21.85,
                '2008-02-21',
                100,
                640
        );
INSERT INTO book_categories
VALUES (17, 8);
INSERT INTO book_categories
VALUES (17, 10);