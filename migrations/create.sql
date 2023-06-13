-- INSERT FILE
-- We called procedures to insert data to tables. That's why you need to run create.sql file first.


-- time_slots
CALL fill_time_slots();

--user_roles
CALL insert_user_role('Admin');
CALL insert_user_role('User');

-- users
CALL insert_user('Mustafa', 'Çelik', 'mustafaclk253@gmail.com', 'password', '+905555555555', 'Ankara', '2300 Sk', 00006,
                 1);
CALL insert_user('Gökçe', 'Ünal', 'gokceunal6@gmail.com', 'password', '+905555555556', 'Ankara', '2070 Cd', 00601, 1);
CALL insert_user('Ali', 'Yılmaz', 'ali.yilmaz@hotmail.com', 'pass123', '+905551234567', 'İstanbul', 'Atatürk Cd.',
                 34000, 2);
CALL insert_user('Ayşe', 'Kaya', 'ayse.kaya@gmail.com', 'pass123', '+905551234568', 'Ankara', 'Özalp Sk.', 6500, 2);
CALL insert_user('Mehmet', 'Acar', 'mehmet.acar@gmail.com', 'pass123', '+905551234569', 'İzmir', 'Kıvanç Sk.', 3500, 2);
CALL insert_user('Fatma', 'Arslan', 'fatma.arslan@hotmail.com', 'pass123', '+905551234570', 'Bursa', 'Zafer Cd.', 1600,
                 2);
CALL insert_user('Ahmet', 'Öztürk', 'ahmet.ozturk@hotmail.com', 'pass123', '+905551234571', 'Antalya', 'Yıldız Sk.',
                 2090, 2);
CALL insert_user('Seda', 'Koç', 'seda.koc@gmail.com', 'pass123', '+905551234572', 'Adana', 'Ata Sk.', 01000, 2);
CALL insert_user('Mustafa', 'Güneş', 'mustafa.gunes@gmail.com', 'pass123', '+905551234573', 'Eskişehir', 'Özgür Sk.',
                 26000, 2);
CALL insert_user('Gül', 'Can', 'gul.can@gmail.com', 'pass123', '+905551234574', 'Trabzon', 'Cemil Sk.', 61000, 2);
CALL insert_user('Emre', 'Aydın', 'emre.aydin@gmail.com', 'pass123', '+905551234575', 'Diyarbakır', 'Sultan Sk.', 21000,
                 2);
CALL insert_user('Özge', 'Yıldız', 'ozge.yildiz@gmail.com', 'pass123', '+905551234576', 'Kayseri', 'Gazi Cd.', 38000,
                 2);


--rooms
CALL insert_room('Ömer Seyfettin', 10, 1);
CALL insert_room('Nazım Hikmet', 10, 1);
CALL insert_room('Ahmet Hamdi Tanpınar', 10, 1);
CALL insert_room('Yaşar Kemal', 10, 2);
CALL insert_room('Sait Faik Abasıyanık', 15, 2);
CALL insert_room('Cemal Süreya', 15, 2);
CALL insert_room('Halide Edib Adıvar', 15, 3);
CALL insert_room('Attila İlhan', 15, 3);
CALL insert_room('Rıfat Ilgaz', 15, 3);
CALL insert_room('Sabahattin Ali', 15, 4);
CALL insert_room('Orhan Kemal', 15, 4);


--reservations
CALL insert_reservation(1, 2, 3, '2023-05-01');
CALL insert_reservation(2, 1, 4, '2023-05-03');
CALL insert_reservation(3, 3, 2, '2023-05-05');
CALL insert_reservation(4, 4, 1, '2023-05-07');
CALL insert_reservation(5, 1, 3, '2023-05-09');
CALL insert_reservation(6, 2, 4, '2023-05-11');
CALL insert_reservation(7, 3, 1, '2023-05-13');
CALL insert_reservation(8, 4, 2, '2023-05-15');
CALL insert_reservation(9, 1, 4, '2023-05-17');
CALL insert_reservation(10, 2, 3, '2023-05-19');

--genres
CALL insert_genre('Fiction', 'Imaginative or invented stories');
CALL insert_genre('Romance', 'Love stories or stories with romantic elements');
CALL insert_genre('Mystery', 'Stories where a crime, puzzle or mystery must be solved');
CALL insert_genre('Thriller', 'Suspenseful stories that keep the reader on the edge of their seat');
CALL insert_genre('Horror', 'Stories that aim to scare or unsettle the reader');
CALL insert_genre('Science Fiction', 'Stories that explore scientific and technological advancements');
CALL insert_genre('Fantasy', 'Stories that take place in imaginary worlds or with magical or supernatural elements');
CALL insert_genre('Young Adult', 'Stories with teenage protagonists and themes');
CALL insert_genre('Historical Fiction', 'Stories set in the past with fictional characters and events');
CALL insert_genre('Non-Fiction', 'True stories or accounts of real people, events, or phenomena');
CALL insert_genre('Documentary', 'Informing or educating productions about a particular topic or issue.');
CALL insert_genre('News Magazine',
                  'Magazine publications devoted to current affairs, typically providing more details and analysis than a news report.');
CALL insert_genre('Fashion Magazine', 'About style, culture, beauty, and hair from celebrities or designers.');
CALL insert_genre('Scientific Magazine', 'Magazines about different areas of science.');
CALL insert_genre('Newspaper',
                  'Daily or weekly publications and contains news, articles of opinion, features, and advertising');

--languages
CALL insert_language('English');
CALL insert_language('Turkish');
CALL insert_language('French');
CALL insert_language('German');
CALL insert_language('Italian');
CALL insert_language('Chinese');
CALL insert_language('Japanese');
CALL insert_language('Korean');
CALL insert_language('Arabic');
CALL insert_language('Russian');

--publishers
CALL insert_publisher('Penguin Random House', '1745 Broadway', 'New York', 'USA', '212-782-9000',
                      'info@penguinrandomhouse.com');
CALL insert_publisher('HarperCollins Publishers', '195 Broadway', 'New York', 'USA', '212-207-7000',
                      'feedback@harpercollins.com');
CALL insert_publisher('Simon & Schuster', '1230 Avenue of the Americas', 'New York', 'USA', '212-698-7000',
                      'corporatepublicity@simonandschuster.com');
CALL insert_publisher('Hachette Livre', '58 Rue Jean Bleuzen', 'Vanves', 'France', '+33 (0) 1 43 92 30 00',
                      'contact@hachette-livre.fr');
CALL insert_publisher('Pan Macmillan', '20 New Wharf Road', 'London', 'UK', '+44 (0) 1256 329242',
                      'info@panmacmillan.com');
CALL insert_publisher('Bloomsbury Publishing', '50 Bedford Square', 'London', 'UK', '+44 (0)20 7631 5600',
                      'enquiries@bloomsbury.com');
CALL insert_publisher('Yapı Kredi Yayınları', 'Yapı Kredi Kültür Sanat Yayıncılık A.Ş., Kocatepe Mahallesi', 'Istanbul',
                      'Turkey', '+90 (212) 252 41 00', 'iletisim@ykykultur.com.tr');
CALL insert_publisher('Doğan Kitap', 'Büyükdere Cad. No: 181/A Zincirlikuyu', 'Istanbul', 'Turkey', '+90 212 316 95 00',
                      'iletisim@dogankitap.com.tr');
CALL insert_publisher('Can Yayınları', 'Caferağa Mah. Şahkulu Sok. No:6', 'Istanbul', 'Turkey', '+90 216 330 26 46',
                      'info@can.com.tr');
CALL insert_publisher('İletişim Yayınları', 'Hüseyinağa Mah. İletişim Yayınevi', 'Istanbul', 'Turkey',
                      '+90 212 251 45 00', 'iletisim@iletisim.com.tr');
CALL insert_publisher('Documentary Films Co.', '123 Main St.', 'Los Angeles', 'USA', '+1-555-1234',
                      'info@documentaryfilms.com');
CALL insert_publisher('DocuPro', '456 1st Ave.', 'New York', 'USA', '+1-555-5678', 'contact@docupro.com');
CALL insert_publisher('Magazine Publishers Inc.', '789 Market St.', 'San Francisco', 'USA', '+1-555-9012',
                      'info@magazinepublishers.com');
CALL insert_publisher('Doğan Media Group', 'Trump Towers, Mecidiyeköy', 'Istanbul', 'Turkey', '+90 212 505 61 11',
                      'info@dogan.com.tr');
CALL insert_publisher('Turkuvaz Media Group', 'Eski Büyükdere Cad. Maslak', 'Istanbul', 'Turkey', '+90 212 335 35 35',
                      'info@turkuvazmediagroup.com');
CALL insert_publisher('Demirören Media Group', 'Barbaros Bulvarı', 'Istanbul', 'Turkey', '+90 212 337 45 00',
                      'info@demiroren.com.tr');
CALL insert_publisher('Sözcü Gazetecilik A.Ş.', 'Atatürk Bulvarı No:127 Kat:1', 'İstanbul', 'Turkey',
                      '+90 212 963 30 00', 'info@sozcu.com.tr');
CALL insert_publisher('Cumhuriyet Foundation', 'Şehbender Sokak No:8', 'İstanbul', 'Turkey', '+90 212 252 5100',
                      'iletisim@cumhuriyet.com.tr');
CALL insert_publisher('The New York Times Company', '620 Eighth Avenue', 'New York', 'United States', '+1 212-556-1234',
                      'nytnews@nytimes.com');
CALL insert_publisher('Guardian News & Media', 'Kings Place, 90 York Way', 'London', 'United Kingdom',
                      '+44 (0) 20 3353 2000', 'userhelp@theguardian.com');
CALL insert_publisher('News UK & Ireland Ltd', '1 London Bridge Street', 'London', 'United Kingdom',
                      '+44 (0)20 7782 1010', 'customerhelp@thetimes.co.uk');
CALL insert_publisher('Nash Holdings LLC', '1301 K Street NW', 'Washington D.C.', 'United States', '+1 202-334-6000',
                      'contact@washpost.com');


--authors
CALL insert_author('F. Scott', 'Fitzgerald', '1896-09-24', 'American',
                   'F. Scott Fitzgerald was an American novelist and short story writer.');
CALL insert_author('Harper', 'Lee', '1926-04-28', 'American',
                   'Harper Lee was an American novelist and author of "To Kill a Mockingbird."');
CALL insert_author('Jane', 'Austen', '1775-12-16', 'English',
                   'Jane Austen was an English novelist known for her works of romantic fiction.');
CALL insert_author('George', 'Orwell', '1903-06-25', 'English',
                   'George Orwell was an English novelist, essayist, and critic best known for his works "1984" and "Animal Farm."');
CALL insert_author('J.D.', 'Salinger', '1919-01-01', 'American',
                   'J.D. Salinger was an American author best known for his novel "The Catcher in the Rye."');
CALL insert_author('Aldous', 'Huxley', '1894-07-26', 'English',
                   'Aldous Huxley was an English writer and philosopher, best known for his novel "Brave New World."');
CALL insert_author('Ray', 'Bradbury', '1920-08-22', 'American',
                   'Ray Bradbury was an American author and screenwriter known for his works of science fiction and fantasy.');
CALL insert_author('Emily', 'Bronte', '1818-07-30', 'English',
                   'Emily Bronte was an English novelist and poet, best known for her novel "Wuthering Heights."');
CALL insert_author('William', 'Golding', '1911-09-19', 'English',
                   'William Golding was an English novelist, playwright, and poet, best known for his novel "Lord of the Flies."');
CALL insert_author('Neil', 'Gaiman', '1960-11-10', 'British',
                   'He is best known for his works of fantasy and horror, including "The Sandman" comic book series and the novels "American Gods" and "Coraline." Gaiman has won numerous awards for his writing, including the Hugo, Nebula, and Bram Stoker awards. ');
CALL insert_author('Stephen', 'King', 'September 21, 1947', 'American',
                   'Stephen King is an American author of horror, supernatural fiction, suspense, and fantasy novels.');
CALL insert_author('Stieg', 'Larsson', 'August 15, 1954', 'Swedish',
                   'Stieg Larsson was a Swedish journalist and writer. He is best known for writing the Millennium trilogy of crime novels.');
CALL insert_author('Orson Scott', 'Card', 'August 24, 1951', 'American',
                   'Orson Scott Card is an American novelist, critic, public speaker, essayist, and columnist. He writes in several genres but is known best for his science fiction.');
CALL insert_author('Joe', 'Abercrombie', 'December 31, 1974', 'British',
                   'Joe Abercrombie is a British fantasy writer and film editor. He is the author of the First Law trilogy and the Shattered Sea series.');
CALL insert_author('Patrick', 'Rothfuss', 'June 6, 1973', 'American',
                   'Patrick Rothfuss is an American writer of epic fantasy. He is best known for his Kingkiller Chronicle series of novels.');
CALL insert_author('Donna', 'Tartt', 'December 23, 1963', 'American',
                   'Donna Tartt is an American writer, the author of the novels The Secret History, The Little Friend, and The Goldfinch.');
CALL insert_author('Yaa', 'Gyasi', 'November 2, 1989', 'Ghanaian-American',
                   'Yaa Gyasi is a Ghanaian-American novelist. She is known for her debut novel, Homegoing, which won numerous awards and was a New York Times best-seller.');
CALL insert_author('Michael', 'Punke', 'December 8, 1964', 'American',
                   'Michael Punke is an American author, professor, and policy analyst. He is best known for writing The Revenant.');
CALL insert_author('Cressida', 'Cowell', 'April 15, 1966', 'British',
                   'Cressida Cowell is a British childrens author and illustrator. She is known for writing the How to Train Your Dragon book series.');


--book_origin
CALL insert_book_origin(1, 'The Great Gatsby');
CALL insert_book_origin(2, 'To Kill a Mockingbird');
CALL insert_book_origin(3, 'Pride and Prejudice');
CALL insert_book_origin(4, '1984');
CALL insert_book_origin(5, 'The Catcher in the Rye');
CALL insert_book_origin(4, 'Animal Farm');
CALL insert_book_origin(6, 'Brave New World');
CALL insert_book_origin(7, 'Fahrenheit 451');
CALL insert_book_origin(9, 'Lord of the Flies');
CALL insert_book_origin(8, 'Wuthering Heights');
CALL insert_book_origin(10, 'Ocean at the end of the lane');
CALL insert_book_origin(12, 'The Stand');
CALL insert_book_origin(13, 'The Girl with the Dragon Tattoo');
CALL insert_book_origin(14, 'Enders Game');
CALL insert_book_origin(15, 'The First Law trilogy');
CALL insert_book_origin(16, 'The Name of the Wind ');
CALL insert_book_origin(17, 'The Goldfinch');
CALL insert_book_origin(18, 'Homegoing');
CALL insert_book_origin(19, 'The Revenant');
CALL insert_book_origin(20, 'How to Train Your Dragon');


--publications
CALL insert_publication('The Social Dilemma', 11, 4, 1, NULL, '2020-01-01',
                        'A documentary-drama hybrid exploration of the dangerous human impact of social networking.');
CALL insert_publication('My Octopus Teacher', 11, 5, 1, NULL, '2020-01-01',
                        'A filmmaker forges an unusual friendship with an octopus living in a South African kelp forest, learning as the animal shares the mysteries of her world.');
CALL insert_publication('Fyre', 11, 5, 3, NULL, '2019-01-01',
                        'An exclusive behind the scenes look at the infamous unraveling of the Fyre music festival.');
CALL insert_publication('The Great Hack', 11, 4, 1, NULL, '2019-01-01',
                        'Explores how a data company named Cambridge Analytica came to symbolize the dark side of social media in the wake of the 2016 presidential election.');
CALL insert_publication('American Factory', 11, 5, 1, NULL, '2019-01-01',
                        'In post-industrial Ohio, a Chinese billionaire opens a new factory in the husk of an abandoned General Motors plant, hiring two thousand blue-collar Americans.');
CALL insert_publication('The Ivory Game', 11, 6, 1, NULL, '2016-01-01',
                        'Wildlife activists in take on poachers in an effort to end illegal ivory trade in Africa.');
CALL insert_publication('National Geographic', 14, 12, 1, NULL, '1888-01-01',
                        'The official magazine of the National Geographic Society, has been a monthly publication since 1888.');
CALL insert_publication('Time', 12, 12, 1, NULL, '1923-01-01',
                        'A weekly news magazine featuring world news, entertainment, business, and technology.');
CALL insert_publication('Vogue', 13, 12, 1, NULL, '1892-01-01',
                        'A fashion and lifestyle magazine covering topics including fashion, beauty, culture, living, and runway.');
CALL insert_publication('Science Magazine', 14, 12, 1, NULL, '2022-01-01',
                        'Monthly science magazine covering the latest discoveries and research.');
CALL insert_publication('Hürriyet Gazetesi', 15, 11, 2, null, '2023-04-23',
                        'One of the leading Turkish daily newspapers');
CALL insert_publication('Sabah Gazetesi', 15, 12, 2, null, '2023-04-23', 'Another popular Turkish daily newspaper');
CALL insert_publication('Milliyet Gazetesi', 15, 13, 2, null, '2023-04-23', 'One of the oldest Turkish newspapers');
CALL insert_publication('Sözcü Gazetesi', 15, 14, 2, null, '2023-04-23', 'A popular tabloid newspaper in Turkey');
CALL insert_publication('Posta Gazetesi', 15, 11, 2, null, '2023-04-23',
                        'A daily newspaper with a focus on entertainment and lifestyle');
CALL insert_publication('Cumhuriyet Gazetesi', 15, 15, 2, null, '2023-04-23',
                        'One of the oldest and most prestigious newspapers in Turkey');
CALL insert_publication('The New York Times', 15, 16, 1, null, '2023-04-23',
                        'One of the largest and most influential newspapers in the US');
CALL insert_publication('The Guardian', 15, 17, 1, null, '2023-04-23', 'A leading British daily newspaper');
CALL insert_publication('The Times', 15, 18, 1, null, '2023-04-23',
                        'A daily newspaper that is widely considered to be the most authoritative in the UK');
CALL insert_publication('The Washington Post', 15, 19, 1, null, '2023-04-23', 'A major American daily newspaper');
CALL insert_publication('The Great Gatsby', 1, 1, 1, NULL, '1925-04-10',
                        'A story about love, wealth and excess.');
CALL insert_publication('To Kill a Mockingbird', 1, 1, 1, NULL, '1960-07-11',
                        'A story about racial injustice and loss of innocence in the South.');
CALL insert_publication('Pride and Prejudice', 2, 1, 1, NULL, '1813-01-28',
                        'A novel of manners set in early 19th century England.');
CALL insert_publication('1984', 7, 1, 1, NULL, '1949-06-08',
                        'A dystopian novel set in a totalitarian society.');
CALL insert_publication('The Catcher in the Rye', 8, 1, 1, NULL, '1951-07-16',
                        'A story about a teenager who is disillusioned with society and struggles with growing up.');
CALL insert_publication('Animal Farm', 7, 1, 1, NULL, '1945-08-17',
                        'A political fable about revolution and the corruption of power.');
CALL insert_publication('Brave New World', 7, 1, 1, NULL, '1932-06-18',
                        'A dystopian novel about a future society that has achieved stability and happiness through the suppression of individuality and emotion.');
CALL insert_publication('Fahrenheit 451', 7, 1, 1, NULL, '1953-10-19',
                        'A novel about a future society where books are banned and "firemen" burn any that are found.');
CALL insert_publication('Lord of the Flies', 7, 1, 1, NULL, '1954-09-17',
                        'A novel about a group of boys stranded on an uninhabited island and their descent into savagery.');
CALL insert_publication('Wuthering Heights', 2, 1, 1, NULL, '1847-12-19',
                        'A Gothic novel set in Yorkshire about the passionate love between Catherine and Heathcliff.');

CALL insert_publication('Ocean at the end of the lane', 7, 1, 1, NULL, '2013-06-18',
                        'A story of memory, magic and survival.');
CALL insert_publication('The Stand', 5, 3, 1, NULL, '1978-10-03',
                        'A post-apocalyptic horror/fantasy novel about a plague that wipes out most of humanity.');
CALL insert_publication('The Girl with the Dragon Tattoo', 7, 3, 1, NULL, '2005-08-19',
                        'A crime thriller about a journalist and a computer hacker who investigate a wealthy family.');
CALL insert_publication('Enders Game', 7, 3, 1, NULL, '1985-01-15',
                        'A military science fiction novel about a child prodigy who is trained to lead the Earths forces against an alien invasion.');
CALL insert_publication('The First Law trilogy', 7, 3, 1, NULL, '2006-05-04',
                        'A dark fantasy trilogy set in a world of magic, war and politics.');
CALL insert_publication('Rüzgarın Adı', 7, 7, 2, 'Hakan Özdemir', '2012-04-25', 'Fantastik roman');
CALL insert_publication('Sarı Kuş', 9, 7, 2, 'Hakan Özdemir', '2016-09-01', 'Bir zenginlik portresi');
CALL insert_publication('Evden Gidenler', 9, 8, 2, 'Hakan Özdemir', '2018-11-30',
                        'Ganada bir aileden başlayıp Amerikaya uzanan bir yolculuk');
CALL insert_publication('Diriliş', 5, 8, 2, 'Hakan Özdemir', '2016-02-19',
                        '1823 yılında geçen Hugh Glass adlı bir kürk tüccarının gerçek hikayesi');
CALL insert_publication('Ejderhanı Nasıl Eğitirsin', 7, 9, 2, 'Hakan Özdemir', '2010-06-11',
                        'Vikingler ve ejderhalar arasındaki dostluğu konu alan bir roman');

CALL insert_publication('Yolun Sonundaki Okyanus', 7, 1, 2, 'Neil Gaiman', '2013-06-18',
                        'Hafıza, büyü ve hayatta kalma hikayesi.');
CALL insert_publication('Mahşer', 5, 3, 2, 'Gökçe Ünalmış', '1978-10-03',
                        'İnsanlığın çoğunu yok eden bir veba hakkında kıyamet sonrası bir korku/fantezi romanı.');
CALL insert_publication('Ejderha Dövmeli Kız', 5, 3, 2, 'Engin Akıllı', '2005-08-19',
                        'Zengin bir aileyi araştıran bir gazeteci ve bilgisayar korsanı hakkında bir polisiye gerilim.');
CALL insert_publication('Enders Game', 7, 3, 1, 'Zafer Kutlu', '1985-01-15',
                        'A military science fiction novel about a child prodigy who is trained to lead the Earths forces against an alien invasion.');
CALL insert_publication('Birinci Kanun Üçlemesi', 7, 3, 2, 'Nesli Işık', '2006-05-04',
                        'Sihir, savaş ve politika dünyasında geçen karanlık bir fantezi üçlemesi.');
CALL insert_publication('Name of the Wind', 7, 7, 1, NULL, '2007-03-27', 'Fantasy novel');
CALL insert_publication('The Goldfinch', 9, 7, 1, NULL, '2013-10-22', 'A portrait of wealth');
CALL insert_publication('The Revenant', 5, 8, 1, NULL, '2002-04-29',
                        'A historical novel based on the true story of Hugh Glass, a fur trapper in the 1820s.');
CALL insert_publication('How to Train Your Dragon', 7, 9, 1, NULL, '2003-02-01',
                        'A childrens novel about the friendship between Vikings and dragons.');

UPDATE publications
SET image_name = ((id%7) + 1)::text
WHERE true;


--physical publication
CALL insert_physical_publication(1, 1, 1, 1);
CALL insert_physical_publication(2, 3, 2, 2);
CALL insert_physical_publication(3, 2, 1, 3);
CALL insert_physical_publication(1, 4, 3, 4);
CALL insert_physical_publication(2, 1, 2, 5);
CALL insert_physical_publication(3, 5, 1, 6);
CALL insert_physical_publication(1, 2, 4, 7);
CALL insert_physical_publication(2, 4, 3, 8);
CALL insert_physical_publication(3, 1, 2, 9);
CALL insert_physical_publication(1, 3, 1, 10);

CALL insert_physical_publication(1, 1, 1, 11);
CALL insert_physical_publication(1, 1, 2, 12);
CALL insert_physical_publication(1, 1, 3, 13);
CALL insert_physical_publication(1, 2, 1, 14);
CALL insert_physical_publication(1, 2, 2, 15);
CALL insert_physical_publication(1, 2, 3, 16);
CALL insert_physical_publication(2, 1, 1, 17);
CALL insert_physical_publication(2, 1, 2, 18);
CALL insert_physical_publication(2, 1, 3, 19);
CALL insert_physical_publication(2, 2, 1, 20);

CALL insert_physical_publication(4, 2, 3, 21);
CALL insert_physical_publication(1, 5, 2, 22);
CALL insert_physical_publication(2, 3, 4, 23);
CALL insert_physical_publication(4, 1, 1, 24);
CALL insert_physical_publication(3, 2, 5, 25);
CALL insert_physical_publication(2, 1, 3, 26);
CALL insert_physical_publication(1, 4, 2, 27);
CALL insert_physical_publication(5, 3, 1, 28);
CALL insert_physical_publication(2, 4, 5, 29);
CALL insert_physical_publication(3, 1, 4, 30);

--materials
CALL insert_material(1, 'DVD');
CALL insert_material(2, 'Blu-ray');
CALL insert_material(3, 'DVD');
CALL insert_material(4, 'DVD');
CALL insert_material(5, 'DVD');
CALL insert_material(6, 'DVD');
CALL insert_material(7, 'Print');
CALL insert_material(8, 'Print');
CALL insert_material(9, 'Print');
CALL insert_material(10, 'Print');

--newspapers
CALL insert_newspaper(11, 'Daily', '5000');
CALL insert_newspaper(12, 'Daily', '3500');
CALL insert_newspaper(13, 'Daily', '2000');
CALL insert_newspaper(14, 'Daily', '2500');
CALL insert_newspaper(15, 'Daily', '4000');
CALL insert_newspaper(16, 'Daily', '100');
CALL insert_newspaper(17, 'Daily', '2400');
CALL insert_newspaper(18, 'Daily', '1300');
CALL insert_newspaper(19, 'Daily', '4000');
CALL insert_newspaper(20, 'Daily', '6500');


--physical_book
CALL insert_physical_book(21, 1, 50);
CALL insert_physical_book(22, 2, 75);
CALL insert_physical_book(23, 3, 100);
CALL insert_physical_book(24, 4, 125);
CALL insert_physical_book(25, 5, 150);
CALL insert_physical_book(26, 6, 175);
CALL insert_physical_book(27, 7, 200);
CALL insert_physical_book(28, 8, 225);
CALL insert_physical_book(29, 9, 250);
CALL insert_physical_book(30, 10, 275);


--electronic_publication
CALL insert_electronic_publication('https://www.example.com/book1.epub', 1024, 31);
CALL insert_electronic_publication('https://www.example.com/book2.pdf', 2048, 32);
CALL insert_electronic_publication('https://www.example.com/book3.mobi', 4096, 33);
CALL insert_electronic_publication('https://www.example.com/book4.epub', 8192, 34);
CALL insert_electronic_publication('https://www.example.com/book5.pdf', 16384, 35);
CALL insert_electronic_publication('https://www.example.com/book6.mobi', 32768, 36);
CALL insert_electronic_publication('https://www.example.com/book7.epub', 65536, 37);
CALL insert_electronic_publication('https://www.example.com/book8.pdf', 131072, 38);
CALL insert_electronic_publication('https://www.example.com/book9.mobi', 262144, 39);
CALL insert_electronic_publication('https://www.example.com/book10.epub', 524288, 40);
CALL insert_electronic_publication('https://example.com/book11.mp4', 1000000, 41);
CALL insert_electronic_publication('https://example.com/book12.mp4', 2000000, 42);
CALL insert_electronic_publication('https://example.com/book13.mp4', 3000000, 43);
CALL insert_electronic_publication('https://example.com/book14.mp4', 4000000, 44);
CALL insert_electronic_publication('https://example.com/book15.mp4', 5000000, 45);
CALL insert_electronic_publication('https://example.com/book16.mp4', 6000000, 46);
CALL insert_electronic_publication('https://example.com/book17.mp4', 7000000, 47);
CALL insert_electronic_publication('https://example.com/book18.mp4', 8000000, 48);
CALL insert_electronic_publication('https://example.com/book19.mp4', 9000000, 49);
CALL insert_electronic_publication('https://example.com/book20.mp4', 10000000, 50);


--e_books
CALL insert_e_book(1, 10);
CALL insert_e_book(2, 11);
CALL insert_e_book(3, 12);
CALL insert_e_book(4, 13);
CALL insert_e_book(5, 14);
CALL insert_e_book(6, 15);
CALL insert_e_book(7, 16);
CALL insert_e_book(8, 17);
CALL insert_e_book(9, 18);
CALL insert_e_book(10, 19);


--audio_books
CALL insert_audio_book(11, 10, 'Melike Aydoğmuş', 720);
CALL insert_audio_book(12, 11, 'Ezgi Can', 1290);
CALL insert_audio_book(13, 12, 'Yılmaz Doğuş', 660);
CALL insert_audio_book(14, 13, 'Murat Ünal', 870);
CALL insert_audio_book(15, 14, 'Gökçe Yılmaz', 1250);
CALL insert_audio_book(16, 15, 'Simon Vance', 960);
CALL insert_audio_book(17, 16, 'Donna Tartt', 880);
CALL insert_audio_book(18, 17, 'Adjoa Andoh', 1120);
CALL insert_audio_book(19, 18, 'Jeff Harding', 660);
CALL insert_audio_book(20, 19, 'David Tennant', 960);


--notification_request
CALL insert_notification_request(1, 1);
CALL insert_notification_request(2, 2);
CALL insert_notification_request(3, 3);
CALL insert_notification_request(4, 4);
CALL insert_notification_request(5, 5);
CALL insert_notification_request(6, 6);
CALL insert_notification_request(7, 7);
CALL insert_notification_request(8, 8);
CALL insert_notification_request(9, 9);
CALL insert_notification_request(10, 10);

--borrowings
CALL insert_borrowing(1, 1, '2022-01-24 12:00:00+00', '2023-02-28 12:00:00+00');
CALL insert_borrowing(2, 1, '2022-01-24 13:00:00+00', '2023-03-01 13:00:00+00');
CALL insert_borrowing(3, 1, '2022-01-24 14:00:00+00', '2023-03-02 14:00:00+00');
CALL insert_borrowing(4, 2, '2022-01-25 10:00:00+00', '2023-03-01 10:00:00+00');
CALL insert_borrowing(5, 2, '2022-01-26 11:00:00+00', '2023-03-03 11:00:00+00');
CALL insert_borrowing(6, 3, '2022-01-27 12:00:00+00', '2023-03-04 12:00:00+00');
CALL insert_borrowing(7, 4, '2022-01-28 13:00:00+00', '2023-03-05 13:00:00+00');
CALL insert_borrowing(8, 5, '2022-01-29 14:00:00+00', '2023-03-06 14:00:00+00');
CALL insert_borrowing(9, 6, '2022-01-30 15:00:00+00', '2023-03-07 15:00:00+00');
CALL insert_borrowing(10, 7, '2023-01-01 16:00:00+00', '2023-02-08 16:00:00+00');

--ratings
CALL insert_rating(1, 1, 4, '2023-03-01');
CALL insert_rating(2, 1, 5, '2023-02-01');
CALL insert_rating(3, 1, 3, '2023-02-15');
CALL insert_rating(4, 2, 4, '2023-03-01');
CALL insert_rating(5, 2, 5, '2023-03-15');
CALL insert_rating(6, 3, 3, '2023-04-01');
CALL insert_rating(7, 4, 2, '2023-03-01');
CALL insert_rating(8, 5, 5, '2023-06-01');
CALL insert_rating(9, 6, 4, '2023-04-01');
CALL insert_rating(10, 7, 2, '2023-03-01');

--reviews
CALL insert_review(1, 1, 'Great book, highly recommend it!');
CALL insert_review(2, 1, 'This book was a bit disappointing, the characters were not very well-developed.');
CALL insert_review(3, 1, 'Loved the writing style and the plot twists but the language use was not very effective.');
CALL insert_review(4, 2, 'Interesting concept, but the execution was lacking.');
CALL insert_review(5, 2, 'A thought-provoking read, it really made me reflect on my own life choices.');
CALL insert_review(6, 3, 'One of my all-time favorites, I have read it multiple times!');
CALL insert_review(7, 4, 'The book was okay, but it did not live up to the hype.');
CALL insert_review(8, 5, 'A thrilling adventure story with a great protagonist!');
CALL insert_review(9, 6, 'A heartwarming and emotional read, I was in tears by the end.');
CALL insert_review(10, 7, 'Not a well written novel');
