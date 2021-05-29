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
-----------BOOK

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (1, 'Harper Lee',
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
--Add categories
--book_categories book_categories  categories_id

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (2, 'Francis Scott Fitzgerald, F. Scott Fitzgerald',
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
VALUES (1, 15);

----3
INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (3, 'Sarah Clarkson',
        'We live in a broken world. Amid the daily realities of sickness and isolation, disappointment and pain, it can be profoundly difficult to grasp the real goodness of God. But this is where God breaks into our darkness with beauty. In the wonder of creation, in art or film, story or song, in the kindness of his people and the good they create, God breaks into our pain in a tangible way, teaching us to trust his kindness and hope for his healing. Beauty is a voice singing into our suffering, beckoning us toward restoration.',
        'We_live_in_a_broken_world_sarah.jpg',
        '978-1-5479-4111-6',
        'This Beautiful Truth: How God''s Goodness Breaks Into Our Darkness',
        10.09,
        '2021-01-01',
        100,
        224);
INSERT INTO book_categories
VALUES (3, 5);

---4 Art
INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (4, 'Austin Kleon',
        'You don’t need to be a genius, you just need to be yourself. That’s the message from Austin Kleon, a young writer and artist who knows that creativity is everywhere, creativity is for everyone. A manifesto for the digital age, Steal Like an Artist is a guide whose positive message, graphic look and illustrations, exercises, and examples will put readers directly in touch with their artistic side',
        'Steal_Like_an_Artist.jpg',
        '978-1-5479-4303-6',
        'Steal Like an Artist: 10 Things Nobody Told You About Being Creative',
        10.09,
        '2012-02-28',
        100,
        160);
INSERT INTO book_categories
VALUES (4, 5);
INSERT INTO book_categories
VALUES (4, 11);
--5

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (5, 'Tracy Chevalier',
        'With precisely 35 canvases to his credit, the Dutch painter Johannes Vermeer represents one of the great enigmas of 17th-century art. The meager facts of his biography have been gleaned from a handful of legal documents. Yet Vermeer''s extraordinary paintings of domestic life, with their subtle play of light and texture, have come to define the Dutch golden age. His portrait of the anonymous Girl with a Pearl Earring has exerted a particular fascination for centuries—and it is this magnetic painting that lies at the heart of Tracy Chevalier''s second novel of the same title.
Girl with a Pearl Earring centers on Vermeer''s prosperous Delft household during the 1660s. When Griet, the novel''s quietly perceptive heroine, is hired as a servant, turmoil follows. First, the 16-year-old narrator becomes increasingly intimate with her master. Then Vermeer employs her as his assistant—and ultimately has Griet sit for him as a model.',
        'Girl_with_a_Pearl_Earring.jpg',
        '978-2-3761-8324-2',
        'Girl with a Pearl Earring',
        10.00,
        '1999-02-28',
        100,
        233);
INSERT INTO book_categories
VALUES (5, 5);
INSERT INTO book_categories
VALUES (5, 11);

--6

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (6, 'Vincent van Gogh, Ronald de Leeuw (Editor), Arnold J. Pomerans (Translator)',
        'A new selection of post-impressionist painter Vincent Van Gough''s letters, The Letters of Vincent van Gogh put a human face on one of the most haunting figures in modern Western culture. In this Penguin Classics edition, the letters are selected and edited by Ronald de Leeuw, and translated by Arnold Pomerans in Penguin Classics.',
        'The_Letters_of_Vincent_van_Gogh.jpg',
        '978-3-4560-2852-1',
        'The Letters of Vincent van Gogh',
        16.42,
        '1914-01-01',
        100,
        233);
INSERT INTO book_categories
VALUES (6, 5);
INSERT INTO book_categories
VALUES (6, 11);

--7
INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (7, 'Hayden Herrera',
        'Hailed by readers and critics across the country, this engrossing biography of Mexican painter Frida Kahlo reveals a woman of extreme magnetism and originality, an artist whose sensual vibrancy came straight from her own experiences: her childhood near Mexico City during the Mexican Revolution; a devastating accident at age eighteen that left her crippled and unable to bear children; her tempestuous marriage to muralist Diego Rivera and intermittent love affairs with men as diverse as Isamu Noguchi and Leon Trotsky; her association with the Communist Party; her absorption in Mexican folklore and culture; and her dramatic love of spectacle.',
        'Frida_Biography_of_Frida_Kahlo.jpg',
        '978-5-5068-6029-7',
        'Frida: A Biography of Frida Kahlo',
        18.18,
        '2015-01-01',
        100,
        233);
INSERT INTO book_categories
VALUES (7, 5);
INSERT INTO book_categories
VALUES (7, 11);
INSERT INTO book_categories
VALUES (7, 16);

--8


INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (8, 'Elizabeth Nyamayaro',
        'When severe draught hit her village in Zimbabwe, Elizabeth, then eight, had no idea that this moment of utter devastation would come to define her life purpose. Unable to move from hunger, she encountered a United Nations aid worker who gave her a bowl of warm porridge and saved her life. This transformative moment inspired Elizabeth to become a humanitarian, and she vowed to dedicate her life to giving back to her community, her continent, and the world.
Grounded by the African concept of ubuntu—“I am because we are”—I Am a Girl from Africa charts Elizabeth’s quest in pursuit of her dream from the small village of Goromonzi to Harare, London, New York, and beyond, where she eventually became a Senior Advisor at the United Nations and launched HeForShe, one of the world’s largest global solidarity movements for gender equality. For over two decades, Elizabeth has been instrumental in creating change in communities all around the world; uplifting the lives of others, just as her life was once uplifted. The memoir brings to vivid life one extraordinary woman’s story of persevering through incredible odds and finding her true calling—while delivering an important message of hope and empowerment in a time when we need it most. ',
        'I Am aGirl_from_Africa.jpg',
        '978-2-8306-4586-6',
        'I Am a Girl from Africa',
        13.18,
        '2021-04-20',
        100,
        272);
INSERT INTO book_categories
VALUES (8, 16);
INSERT INTO book_categories
VALUES (8, 11);

--9

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (9, 'Tara Westover',
        'Tara Westover was 17 the first time she set foot in a classroom. Born to survivalists in the mountains of Idaho, she prepared for the end of the world by stockpiling home-canned peaches and sleeping with her "head-for-the-hills bag". In the summer she stewed herbs for her mother, a midwife and healer, and in the winter she salvaged in her father''s junkyard.
Her father forbade hospitals, so Tara never saw a doctor or nurse. Gashes and concussions, even burns from explosions, were all treated at home with herbalism. The family was so isolated from mainstream society that there was no one to ensure the children received an education and no one to intervene when one of Tara''s older brothers became violent.
', 'educated_Tara_Westover.jpg',
        '978-6-5605-7402-1',
        'Educated',
        18.18,
        '2018-02-20',
        100,
        334);
INSERT INTO book_categories
VALUES (9, 16);
INSERT INTO book_categories
VALUES (9, 11);

--10
INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (10, 'Michelle Obama',
        'In a life filled with meaning and accomplishment, Michelle Obama has emerged as one of the most iconic and compelling women of our era. As First Lady of the United States of America—the first African American to serve in that role—she helped create the most welcoming and inclusive White House in history, while also establishing herself as a powerful advocate for women and girls in the U.S. and around the world, dramatically changing the ways that families pursue healthier and more active lives, and standing with her husband as he led America through some of its most harrowing moments. Along the way, she showed us a few dance moves, crushed Carpool Karaoke, and raised two down-to-earth daughters under an unforgiving media glare.
       In her memoir, a work of deep reflection and mesmerizing storytelling, Michelle Obama invites readers into her world, chronicling the experiences that have shaped her—from her childhood on the South Side of Chicago to her years as an executive balancing the demands of motherhood and work, to her time spent at the world’s most famous address. With unerring honesty and lively wit, she describes her triumphs and her disappointments, both public and private, telling her full story as she has lived it—in her own words and on her own terms. Warm, wise, and revelatory, Becoming is the deeply personal reckoning of a woman of soul and substance who has steadily defied expectations—and whose story inspires us to do the same.',
        'Michelle_Obama_Becoming.jpg',
        '978-8-5551-0227-1',
        'Becoming',
        15.18,
        '2018-11-13',
        100,
        426);
INSERT INTO book_categories
VALUES (10, 16);
INSERT INTO book_categories
VALUES (10, 11);

--11

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (11, 'Jane Austen, Deidre Shauna Lynch (Introduction), James Kinsley (Editor)',
        'Twenty-seven-year old Anne Elliot is Austen''s most adult heroine. Eight years before the story proper begins, she is happily betrothed to a naval officer, Frederick Wentworth, but she precipitously breaks off the engagement when persuaded by her friend Lady Russell that such a match is unworthy. The breakup produces in Anne a deep and long-lasting regret. When later Wentworth returns from sea a rich and successful captain, he finds Anne''s family on the brink of financial ruin and his own sister a tenant in Kellynch Hall, the Elliot estate. All the tension of the novel revolves around one question: Will Anne and Wentworth be reunited in their love?
Jane Austen once compared her writing to painting on a little bit of ivory, 2 inches square. Readers of Persuasion will discover that neither her skill for delicate, ironic observations on social custom, love, and marriage nor her ability to apply a sharp focus lens to English manners and morals has deserted her in her final finished work.',
        'austen_Persuasion_jane.jpg',
        '978-8-3226-0389-5',
        'Persuasion',
        8.99,
        '1817-12-01',
        100,
        249);
INSERT INTO book_categories
VALUES (11, 1);
INSERT INTO book_categories
VALUES (11, 4);
INSERT INTO book_categories
VALUES (11, 9);
INSERT INTO book_categories
VALUES (11, 15);

---12

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (12, 'Jane Austen',
        'Since its immediate success in 1813, Pride and Prejudice has remained one of the most popular novels in the English language. Jane Austen called this brilliant work "her own darling child" and its vivacious heroine, Elizabeth Bennet, "as delightful a creature as ever appeared in print." The romantic clash between the opinionated Elizabeth and her proud beau, Mr. Darcy, is a splendid performance of civilized sparring. And Jane Austen''s radiant wit sparkles as her characters dance a delicate quadrille of flirtation and intrigue, making this book the most superb comedy of manners of Regency England',
        'Pride_and_Prejudice.jpg',
        '978-1-8249-9611-3',
        'Pride and Prejudice',
        14.99,
        '1813-01-28',
        100,
        279);
INSERT INTO book_categories
VALUES (12, 1);
INSERT INTO book_categories
VALUES (12, 4);
INSERT INTO book_categories
VALUES (12, 9);
INSERT INTO book_categories
VALUES (12, 15);

---13
INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (13, 'William Shakespeare',
        'In Romeo and Juliet, Shakespeare creates a violent world, in which two young people fall in love. It is not simply that their families disapprove; the Montagues and the Capulets are engaged in a blood feud.
  In this death-filled setting, the movement from love at first sight to the lovers’ final union in death seems almost inevitable. And yet, this play set in an extraordinary world has become the quintessential story of young love. In part because of its exquisite language, it is easy to respond as if it were about all young lovers',
        'Romeo_and_Juliet_s.jpg',
        '978-3-1755-9081-1',
        'Romeo and Juliet',
        17.99,
        '1813-01-28',
        100,
        301);
INSERT INTO book_categories
VALUES (13, 1);
INSERT INTO book_categories
VALUES (13, 4);
INSERT INTO book_categories
VALUES (13, 9);
INSERT INTO book_categories
VALUES (13, 15);

---14

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (14, 'Jane Austen',
        'Marianne Dashwood wears her heart on her sleeve, and when she falls in love with the dashing but unsuitable John Willoughby she ignores her sister Elinors warning that her impulsive behaviour leaves her open to gossip and innuendo. Meanwhile Elinor, always sensitive to social convention, is struggling to conceal her own romantic disappointment, even from those closest to her. Through their parallel experience of love—and its threatened loss—the sisters learn that sense must mix with sensibility if they are to find personal happiness in a society where status and money govern the rules of love.
        This edition includes explanatory notes, textual variants between the first and second editions, and Tony Tanner''s introduction to the original Penguin Classic edition',
        'Sense_and_Sensibility.jpg',
        '978-4-6406-6521-8',
        'Sense and Sensibility',
        11.99,
        '1813-01-28',
        100,
        281);
INSERT INTO book_categories
VALUES (14, 1);
INSERT INTO book_categories
VALUES (14, 4);
INSERT INTO book_categories
VALUES (14, 9);
INSERT INTO book_categories
VALUES (14, 15);

---15

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (15, 'Jane Austen',
        'Emma Woodhouse is one of Austens most captivating and vivid characters. Beautiful, spoilt, vain and irrepressibly witty, Emma organizes the lives of the inhabitants of her sleepy little village and plays matchmaker with devastating effect.',
        'ja_emma.jpg',
        '978-5-3748-7092-3',
        'Emma',
        9.99,
        '1813-01-28',
        100,
        281);
INSERT INTO book_categories
VALUES (15, 1);
INSERT INTO book_categories
VALUES (15, 4);
INSERT INTO book_categories
VALUES (15, 9);
INSERT INTO book_categories
VALUES (15, 15);

---16

INSERT INTO book (book_id,
                  author,
                  description,
                  image,
                  isbn,
                  title,
                  price,
                  published_date,
                  product_stock,
                  num_of_pages)
VALUES (16, 'Mark Twain',
        'A nineteenth-century boy from a Mississippi River town recounts his adventures as he travels down the river with a runaway slave, encountering a family involved in a feud, two scoundrels pretending to be royalty, and Tom Sawyer''s aunt who mistakes him for Tom',
        'The_Adventures_of_Huckleberry_Finn.jpg',
        '978-7-8700-7887-2',
        'The Adventures of Huckleberry Finn',
        11.99,
        '1813-01-28',
        100,
        281);
INSERT INTO book_categories
VALUES (16, 1);
INSERT INTO book_categories
VALUES (16, 9);
INSERT INTO book_categories
VALUES (16, 15);