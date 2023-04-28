# Assignment UF2P1 - DB generation with DDL

DROP DATABASE IF EXISTS series;
CREATE DATABASE series;
USE series;

CREATE TABLE IF NOT EXISTS actor(
	id_actor MEDIUMINT AUTO_INCREMENT, 
    dni CHAR(9) NOT NULL,
	name VARCHAR (50) NOT NULL,
	lastname VARCHAR(50),
	email VARCHAR(50),
    number CHAR(9),
    address VARCHAR (50),
    sex ENUM('M','F') NOT NULL,
    origin_country VARCHAR (50) DEFAULT ('EE.UU'),
    date_born DATE NOT NULL,
		PRIMARY KEY (id_actor),
        CONSTRAINT ck_actor_date_born CHECK (date_born > '1900/01/01'),
        CONSTRAINT uk_actor_dni UNIQUE(dni),
        CONSTRAINT uk_actor_email UNIQUE(email),
        CONSTRAINT uk_actor_number UNIQUE(number)
) ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS producer(
    id_producer MEDIUMINT AUTO_INCREMENT,
    dni CHAR(9) NOT NULL,
	name VARCHAR (50) NOT NULL,
	lastname VARCHAR(50),
	email VARCHAR(50),
    number CHAR(9),
    sex ENUM('M','F') NOT NULL,
    origin_country VARCHAR (50) DEFAULT ('EE.UU'),
    address VARCHAR (50),
    date_born DATE NOT NULL,
    description VARCHAR(150),
		PRIMARY KEY (id_producer),
        CONSTRAINT uk_producer_dni UNIQUE(dni),
        CONSTRAINT ck_producer_date_born CHECK (date_born > '1900/01/01'),
        CONSTRAINT uk_producer_email UNIQUE(email),
        CONSTRAINT uk_producer_number UNIQUE(number)
)ENGINE=INNODB; 
CREATE TABLE IF NOT EXISTS serie (
	id_serie MEDIUMINT AUTO_INCREMENT,
	category VARCHAR(50) NOT NULL,
    title VARCHAR (50) NOT NULL,
    year VARCHAR (50) NOT NULL,
    language VARCHAR(50),
    descritpion VARCHAR(200),
    producer_id MEDIUMINT, 
		PRIMARY KEY (id_serie),
		CONSTRAINT fk_serie_producer FOREIGN KEY (producer_id) REFERENCES producer(id_producer)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS season (
    number_season SMALLINT NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    serie_id MEDIUMINT,
		PRIMARY KEY (number_season, serie_id),
		CONSTRAINT fk_season_serie FOREIGN KEY (serie_id) REFERENCES serie(id_serie)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS chapter(
    number_chapter SMALLINT NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    season_number SMALLINT NOT NULL,
    season_title VARCHAR(50),
     serie_id MEDIUMINT,
		PRIMARY KEY (number_chapter,season_number, serie_id),
		CONSTRAINT fk_chapter_season FOREIGN KEY (season_number) REFERENCES season(number_season),
        CONSTRAINT fk_chapter_serie FOREIGN KEY (serie_id) REFERENCES serie(id_serie)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS serie_producer(
	serie_id MEDIUMINT NOT NULL,
    title VARCHAR(50),
    producer_id MEDIUMINT NOT NULL,
    producer_name VARCHAR(50),
    producer_lastname VARCHAR (50),
		PRIMARY KEY (serie_id,producer_id),
		CONSTRAINT fk_serie_producer_serie FOREIGN KEY (serie_id) REFERENCES serie(id_serie),
		CONSTRAINT fk_serie_producer_actor FOREIGN KEY (producer_id) REFERENCES producer(id_producer)
)ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS serie_actor(
	serie_id MEDIUMINT NOT NULL,
    title VARCHAR(50),
    actor_id MEDIUMINT NOT NULL,
    actor_name VARCHAR(50),
    actor_lastname VARCHAR (50),
		PRIMARY KEY (serie_id,actor_id),
		CONSTRAINT fk_serie_actor_serie FOREIGN KEY (serie_id) REFERENCES serie(id_serie),
		CONSTRAINT fk_serie_actor_actor FOREIGN KEY (actor_id) REFERENCES actor(id_actor)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS platform (
	id_platform CHAR(1) NOT NULL,
    name VARCHAR (50) NOT NULL,
		PRIMARY KEY(id_platform)
)ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS issue(
	serie_id MEDIUMINT NOT NULL,
    platform_id CHAR(1) NOT NULL,
		PRIMARY KEY (serie_id,platform_id),
        CONSTRAINT fk_issue_serie FOREIGN KEY (serie_id) REFERENCES serie(id_serie),
		CONSTRAINT fk_issue_platform FOREIGN KEY (platform_id) REFERENCES platform(id_platform)
		)ENGINE=INNODB;


#Assignment UF2P2 - DB information
-- Task 1
INSERT INTO actor (dni, name, lastname, number, sex, date_born) VALUE ('00588673B', 'Tom', 'Hanks', '674982345', 'M', '1956/07/09');
INSERT INTO actor (dni, name, lastname, number, sex, date_born) VALUE ('92714608K', 'Denzel', 'Washington', '632127890', 'M', '1954/12/28');
INSERT INTO actor (dni, name, lastname, number, sex, date_born, email, address) VALUE ('53755279R', 'Leonardo', 'DiCaprio', '651239874', 'M', '1974/11/11','leonardodicaprio@gmail.com','789 Pine Road');
INSERT INTO actor (dni, name, lastname, number, sex, date_born, email, address) VALUE ('61781690X', 'Meryl', 'Streep', '689562789', 'F', '1949/06/22','merylstreep@gmail.com','321 Birch Boulevard');
INSERT INTO actor (dni, name, lastname, number, sex, date_born) VALUE ('92768022Y', 'Brad', 'Pitt', '657842756', 'M', '1963/12/18');
INSERT INTO actor (dni, name, lastname, number, sex, date_born) VALUE ('89321377A', 'Sandra', 'Bullock', '64397285', 'F', '1964/07/26');
INSERT INTO actor (dni, name, lastname, number, sex, date_born, email, address) VALUE ('54940939B', 'Angelina', 'Jolie', '622587963', 'F', '1975/06/04','angelinajolie@gmail.com','456 Oak Avenue');
INSERT INTO actor (dni, name, lastname, number, sex, date_born) VALUE ('56845731N', 'Johnny', 'Depp', '618972654', 'M', '1963/06/09');
INSERT INTO actor (dni, name, lastname, number, sex, date_born, email, address) VALUE ('42723872S', 'Will', 'Smith', '612347856', 'M', '1968/09/25','willsmith@gmail.com','123 Elm Street');
INSERT INTO actor (dni, name, lastname, number, sex, date_born, address) VALUE ('49843789D', 'Tom', 'Cruise', '633689870', 'M', '2013/11/15','654 Maple Lane');


INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("15616097V","Michael","Hirst","M","759296894","1952/07/21");
INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("54939920G","Shawn","Levy","M","327774450","1968/07/23");
INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("56770627A","Miguel","Sapochnik","M","107839342","1974/07/1");
INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("78568994M","Otto","Bathurst","M","508528218","1959/1/13");
INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("15657097V","Ryan","Murphy","M","654321000","1965/11/09");
INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("87939922H","Shonda","Rhimes","F","987654321","1961/06/09");
INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("90143627A","Aaron","Sorkin","M","123456789","1961/06/09");
INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("78829434M","Vince","Gilligan","M","555666777","1967/02/10");
INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("92140397M","Marta","Kauffman","F","888999000","1956/09/21");
INSERT INTO producer (dni, name, lastname, sex, number, date_born) VALUE ("60193292E","Greg","Berlanti","M","765432198","1972/05/24");


INSERT INTO serie (category, title, year, producer_id) VALUE ("Historical drama","Vikings","2013","1");
INSERT INTO serie (category, title, year, producer_id) VALUE ("Period crime drama","Peaky Blinders","2013","4");
INSERT INTO serie (category, title, year, producer_id) VALUE ("Fantasy drama","House of the Dragons","2022","3");
INSERT INTO serie (category, title, year, producer_id) VALUE ("Science fiction","Stranger Things","2016","2");
INSERT INTO serie (category, title, year, producer_id) VALUE ("Fantasy","The Rings of Power","2022","6");
INSERT INTO serie (category, title, year, producer_id) VALUE ("Fantasy","Game of Thrones","2022","7");
INSERT INTO serie (category, title, year, producer_id) VALUE ("Apocaliptic","The Walking Dead","2010","5");


INSERT INTO season (number_season, title, serie_id) VALUE ('1', 'Vikings: Season 1', '1');
INSERT INTO season (number_season, title, serie_id) VALUE ('1', 'Peaky Blinders: Season 1', '2');
INSERT INTO season (number_season, title, serie_id) VALUE ('1', 'House of the Dragons', '3');
INSERT INTO season (number_season, title, serie_id) VALUE ('1', 'Stranger Things: Season 1', '4');
INSERT INTO season (number_season, title, serie_id) VALUE ('1', 'The Rings of Power', '5');
INSERT INTO season (number_season, title, serie_id) VALUE ('1', 'Game of Thrones: Season 1', '6');
INSERT INTO season (number_season, title, serie_id) VALUE ('1', 'The Walking Dead: Season 1', '7');

INSERT INTO season (number_season, title, serie_id) VALUE ('2', 'Vikings: Season 2', '1');
INSERT INTO season (number_season, title, serie_id) VALUE ('2', 'Peaky Blinders: Season 2', '2');
INSERT INTO season (number_season, title, serie_id) VALUE ('2', 'Stranger Things: Season 2', '4');
INSERT INTO season (number_season, title, serie_id) VALUE ('2', 'Game of Thrones: Season 2', '6');
INSERT INTO season (number_season, title, serie_id) VALUE ('2', 'The Walking Dead: Season 2', '7');

INSERT INTO season (number_season, title, serie_id) VALUE ('3', 'Vikings: Season 3', '1');
INSERT INTO season (number_season, title, serie_id) VALUE ('3', 'Peaky Blinders: Season 3', '2');
INSERT INTO season (number_season, title, serie_id) VALUE ('3', 'Stranger Things: Season 3', '4');
INSERT INTO season (number_season, title, serie_id) VALUE ('3', 'Game of Thrones: Season 3', '6');
INSERT INTO season (number_season, title, serie_id) VALUE ('3', 'The Walking Dead: Season 3', '7');

INSERT INTO season (number_season, title, serie_id) VALUE ('4', 'Vikings: Season 4', '1');
INSERT INTO season (number_season, title, serie_id) VALUE ('4', 'Peaky Blinders: Season 4', '2');
INSERT INTO season (number_season, title, serie_id) VALUE ('4', 'Stranger Things: Season 4', '4');
INSERT INTO season (number_season, title, serie_id) VALUE ('4', 'Game of Thrones: Season 4', '6');
INSERT INTO season (number_season, title, serie_id) VALUE ('4', 'The Walking Dead: Season 4', '7');


INSERT INTO season (number_season, title, serie_id) VALUE ('5', 'Vikings: Season 5', '1');
INSERT INTO season (number_season, title, serie_id) VALUE ('5', 'Peaky Blinders: Season 5', '2');
INSERT INTO season (number_season, title, serie_id) VALUE ('5', 'Game of Thrones: Season 5', '6');
INSERT INTO season (number_season, title, serie_id) VALUE ('5', 'The Walking Dead: Season 5', '7');

INSERT INTO season (number_season, title, serie_id) VALUE ('6', 'Peaky Blinders: Season 6', '2');
INSERT INTO season (number_season, title, serie_id) VALUE ('6', 'Game of Thrones: Season 6', '6');
INSERT INTO season (number_season, title, serie_id) VALUE ('6', 'The Walking Dead: Season 6', '7');

INSERT INTO season (number_season, title, serie_id) VALUE ('7', 'Game of Thrones: Season 7', '6');
INSERT INTO season (number_season, title, serie_id) VALUE ('7', 'The Walking Dead: Season 7', '7');

INSERT INTO season (number_season, title, serie_id) VALUE ('8', 'Game of Thrones: Season 8', '6');



INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Rites of Passage','1', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Wrath of the Northmen','1', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Dispossessed','1', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Trial','1', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Raid','1', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Burial of the Death','1', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', "A King's Ransom",'1', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Sacrifice','1', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'All Change','1', '1');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', "Brother's War", "2", '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Invasion','2', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Treachery','2', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Eye for an Eye','2', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Answers in Blood','2', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Unforgiven','2', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', "Blood Eagle",'2', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Boneless','2', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'The Choice','2', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', "The Lord's Prayer",'2', '1');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', "Mercancy", "3", '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The Wanderer','3', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', "Warrior's Fate",'3', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Scarred','3', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Ururp','3', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Born Again','3', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', "Paris",'3', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'To the Gats!','3', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'Breaking Point','3', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', "The Dead",'3', '1');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', "A Good Treason", "4", '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Kill the Queen','4', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', "Mercy",'4', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Yoi','4', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Prom','4', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Waht Might Have Been','4', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', "The Profit and the Loss",'4', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Portage','4', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'Death All Round','4', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', "The Last Ship",'4', '1');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', "The Outsider", "5", '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The vision','5', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', "The Journeys",'5', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'In the Uncertain Hour Before the Morning','5', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'All His Angels','5', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Crossing','5', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', "The Grat Army",'5', '1');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Revenge','5', '1');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Chapter 1','1', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Chapter 2','1', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Chapter 3','1', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Chapter 4','1', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Chapter 5','1', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Chapter 6','1', '2');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Chapter 1','2', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Chapter 2','2', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Chapter 3','2', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Chapter 4','2', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Chapter 5','2', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Chapter 6','2', '2');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Chapter 1','3', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Chapter 2','3', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Chapter 3','3', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Chapter 4','3', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Chapter 5','3', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Chapter 6','3', '2');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'The Noose','4', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Heathens','4', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Blackbird','4', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Dangerous','4', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Duel','4', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'The Company','4', '2');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Black Tuesday','5', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Black Cats','5', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Strategy','5', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'The Loop','5', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Shock','5', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Mr Jones','5', '2');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Black Day','6', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Black Shirt','6', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Gold','6', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Sapphire','6', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Road to Hell','6', '2');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Lock and Key','6', '2');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'The Heirs of the Dragon','1', '3');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The Rogue Prince','1', '3');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Second of His Name','1', '3');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'King of the Narrow Sea','1', '3');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'We light the way','1', '3');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'The Princess and the Queen','1', '3');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'Driftmark','1', '3');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'The Lord of the Tides','1', '3');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'The Green Council','1', '3');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'The Black Queen','1', '3');


INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', "The Vanishing of Will Byersr", "1", '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The Weirdo on Maple Street','1', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', "Holly, Jolly",'1', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'The Body','1', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Flea and the Acrobat','1', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'The Monster','1', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', "The Bathtub",'1', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'The Upside Down','1', '4');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', "MADMAX", "2", '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Trick or Treat','2', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', "The Pollywog",'2', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Will the Wise','2', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Dig Dug','2', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'The Spy','2', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', "Lost Sister",'2', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'The Mind Flayer','2', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'The Gate', '2', '4');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Suzie, Do You Copy?','3', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The Mall Rats','3', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'The Case of the Missing Lifeguard','3', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'The Sauna Test','3', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Flayed','3', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'E Pluribus Unum','3', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'The Bite','3', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'The Battle of Starcourt','3', '4');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'The Hellfire Club','4', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Vecnas Curse','4', '4');	
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'The Monster and the Superhero','4', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Dear Billy','4', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Nina Project','4', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'The Dive','4', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'The Massacre at Hawkins Lab','4', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Papa','4', '4');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'The Piggyback','4', '4');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Shadow of the Past','1', '5');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Adrift','1', '5');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Adar','1', '5');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'The Great Wave','1', '5');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Partings','1', '5');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Udûn','1', '5');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'The Eye','1', '5');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Alloyed','1', '5');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Winter Is Coming','1', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The Kingsroad','1', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Lord Snow','1', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Cripples, Bastards, and Broken Things','1', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Wolf and the Lion','1', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'A Golden Crown','1', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'You Win or You Die','1', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'The Pointy End','1', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'Baelor','1', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'Fire and Blood','1', '6');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'The North Remembers','2', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The Night Lands','2', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'What Is Dead May Never Die','2', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Garden of Bones','2', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Ghost of Harrenhal','2', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'The Old Gods and the New','2', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'A Man Without Honor','2', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'The Prince of Winterfell','2', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'Blackwater','2', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'Valar Morghulis»','2', '6');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Valar Dohaeris','3', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Dark Wings, Dark Words','3', '6'); 	
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Walk of Punishment','3', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'And Now His Watch is Ended','3', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Kissed by Fire','3', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'The Climb','3', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'The Bear and the Maiden Fair','3', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Second Sons','3', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'The Rains of Castamere','3', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'Mhysa','3', '6');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Two Swords','4', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The Lion and the Rose','4', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Breaker of Chains','4', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Oathkeeper','4', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'First of His Name','4', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'The Laws of Gods and Men','4', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'Mockingbird','4', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'The Mountain and the Viper','4', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'The Watchers on the Wall','4', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'The Children','4', '6');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'The Wars to Come','5', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The House of Black and White','5', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'High Sparrow','5', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Sons of the Harpy','5', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Kill the Boy','5', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Unbowed, Unbent, Unbroken','5', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'The Gift','5', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Hardhome','5', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'The Dance of Dragons','5', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'Mothers Mercy','5', '6');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'The Red Woman','6', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Home','6', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Oathbreaker','6', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Book of the Stranger','6', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Door','6', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Blood of My Blood','6', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'The Broken Man','6', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'No One','6', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'Battle of the Bastards','6', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'The Winds of Winter','6', '6');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Dragonstone','7', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Stormborn','7', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'The Queens Justice','7', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'The Spoils of War','7', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Eastwatch','7', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Beyond the Wall','7', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'The Dragon and the Wolf','7', '6');

INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Winterfell','8', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'A Knight of the Seven Kingdoms','8', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'The Long Night','8', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'The Last of the Starks','8', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'The Bells','8', '6');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'The Iron Throne','8', '6');



INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Days Gone Bye','1', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Guts','1', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Tell It to the Frogs','1', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Vatos','1', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Wildfire','1', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'TS-19','1', '7');


INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'What Lies Ahead','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Bloodletting','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Save the Last One','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Cherokee Rose','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Chupacabra','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Secrets','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'Pretty Much Dead Already','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Nebraska','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'Triggerfinge','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', '18 Miles Out','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('11', 'Judge, Jury, Executioner','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('12', 'Better Angels','2', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('13', 'Beside the Dying Fire.','2', '7');


INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'Seed','3', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Sick','3', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Walk with Me','3', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Killer Within','3', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Say the Word','3', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Hounded','3', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'When the Dead Come Knocking','3', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Made to Suffer','3', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'The Suicide King','3', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'Home','3', '7');



INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', '30 Days Without an Accident','4', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Infected','4', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Isolation','4', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Indifference','4', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Internment','4', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Live Bait','4', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'Dead Weight','4', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Too Far Gone','4', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'After','4', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'Inmates',"4", '7');


INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'No Sanctuary','5', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'Strangers','5', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Four Walls and a Roof','5', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Slabtown','5', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Self Help','5', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Consumed','5', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'Crossed','5', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Coda','5', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'What Happened and Whats Going On','5', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'Them','5', '7');


INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'First Time Again','6', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'JSS','6', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'Thank You','6', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Heres Not Here','6', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Now','6', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Always Accountable','6', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'Heads Up','6', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Start to Finish','6', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'No Way Out','6', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'The Next World','6', '7');


INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('1', 'The Day Will Come When You Wont Be','7', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('2', 'The Well','7', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('3', 'The Cell','7', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('4', 'Service','7', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('5', 'Go Getters','7', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('6', 'Swear','7', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('7', 'Sing Me a Song','7', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('8', 'Hearts Still Beating','7', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('9', 'Rock in the Road','7', '7');
INSERT INTO chapter (number_chapter, title, season_number, serie_id) VALUE ('10', 'New Best Friends','7', '7');


INSERT INTO serie_producer (serie_id, title,  producer_id, producer_name, producer_lastname) VALUE ("1","Vikings","1","Michael","Hirst");
INSERT INTO serie_producer (serie_id, title,  producer_id, producer_name, producer_lastname) VALUE ("2","Peaky Blinders", "4","Otto","Bathusrt");
INSERT INTO serie_producer (serie_id, title,  producer_id, producer_name, producer_lastname) VALUE ("3","House of the Dragons", "3","Miguel","Sapochnik");
INSERT INTO serie_producer (serie_id, title,  producer_id, producer_name, producer_lastname) VALUE ("4","Stranger Things","2","Shawn","Levy");
INSERT INTO serie_producer (serie_id, title, producer_id, producer_name, producer_lastname) VALUE ("5","The Rings of Power", "6","Shonda","Rhimes");
INSERT INTO serie_producer (serie_id, title,  producer_id, producer_name, producer_lastname) VALUE ("6","Game of Thrones", "7","Aaron","Sorkin");
INSERT INTO serie_producer (serie_id, title,  producer_id, producer_name, producer_lastname) VALUE ("7","The Walking Dead","5","Ryan","Murphy");


INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("1","Vikings","2","Denzel","Washington");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("1","Vikings","7","Angelina","Jolie");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("1","Vikings","9","WIll","Smith");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("2","Peaky Blinders","1","Tom","Hanks");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("2","Peaky Blinders","3","Leonardo","Dicaprio");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("2","Peaky Blinders","4","Meryl","Streep");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("3","House of the Dragons","5","Brad","Pitt");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("3","House of the Dragons","10","Tom","Cruise");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("4","Stranger Things","8","Johnny","Depp");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("4","Stranger Things","7","Angelina","Jolie");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("5","The Rings of Power","3","Sandra","Bullock");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("3","House of the Dragons","3","Sandra","Bullock");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("5","The Rings of Power","1","Tom","Hanks");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("6","Game of Thrones","10","Tom","Cruise");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("7","The Walking Dead","9","Will","Smith");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("6","Game of Thrones","7","Angelina","Jolie");
INSERT INTO serie_actor (serie_id, title, actor_id, actor_name, actor_lastname) VALUE ("7","The Walking Dead","4","Meryl","Streep");


INSERT INTO platform (name, id_platform) VALUE ("Netflix","N");
INSERT INTO platform (name, id_platform) VALUE ("HBO Max","H");
INSERT INTO platform (name, id_platform) VALUE ("Disney+","D");
INSERT INTO platform (name, id_platform) VALUE ("Amazon Prime Video","A");

INSERT INTO issue (serie_id, platform_id) VALUE ('1', 'N');
INSERT INTO issue (serie_id, platform_id) VALUE ('2', 'N');
INSERT INTO issue (serie_id, platform_id) VALUE ('3', 'H');
INSERT INTO issue (serie_id, platform_id) VALUE ('4', 'N');
INSERT INTO issue (serie_id, platform_id) VALUE ('5', 'A');
INSERT INTO issue (serie_id, platform_id) VALUE ('6', 'H');
INSERT INTO issue (serie_id, platform_id) VALUE ('7', 'H');
INSERT INTO issue (serie_id, platform_id) VALUE ('1', 'H');
INSERT INTO issue (serie_id, platform_id) VALUE ('1', 'A');
INSERT INTO issue (serie_id, platform_id) VALUE ('2', 'A');
INSERT INTO issue (serie_id, platform_id) VALUE ('7', 'N');

-- 11
SELECT name, lastname FROM actor
WHERE address IS NOT NULL AND email IS NOT NULL;
-- 12
SELECT title, year FROM serie WHERE title LIKE '%Vikings%';
-- 13
SELECT name, lastname FROM actor
WHERE id_actor BETWEEN 8 AND 11;
-- 14
SELECT * FROM actor
WHERE name LIKE '%John%';
-- 15
SELECT COUNT(*) FROM actor
WHERE origin_country = 'EE.UU' AND (sex = 'M' OR sex = 'F');
-- 16
SELECT SUM(id_actor) FROM actor
WHERE id_actor > 2;
-- 17
SELECT * FROM actor
WHERE MOD(id_actor, 2) = 0;
-- 18
SELECT name, lastname, address FROM actor
WHERE SUBSTR(name, 1, 1) = 'J' AND sex = 'M' AND origin_country = 'EE.UU';
-- 19
SELECT name, lastname FROM actor
WHERE UPPER(lastname) LIKE '%SMITH%';
-- 20
SELECT * FROM producer
WHERE YEAR(date_born) = '1952/07/21';


