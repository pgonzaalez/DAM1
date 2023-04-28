CREATE DATABASE IF NOT EXISTS series;

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
); 


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
); 
CREATE TABLE IF NOT EXISTS serie (
	id_serie MEDIUMINT AUTO_INCREMENT NOT NULL,
	category VARCHAR(50) NOT NULL,
    title VARCHAR (50) NOT NULL,
    year DATE NOT NULL NOT NULL,
    language VARCHAR(50),
    descritpion VARCHAR(200),
    producer_id MEDIUMINT NOT NULL, 
		PRIMARY KEY (id_serie),
		CONSTRAINT fk_serie_producer FOREIGN KEY (producer_id) REFERENCES producer(id_producer)
);

CREATE TABLE IF NOT EXISTS season (
	number_season SMALLINT NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    serie_id MEDIUMINT NULL NOT NULL,
		PRIMARY KEY (number_season),
		CONSTRAINT fk_season_serie FOREIGN KEY (serie_id) REFERENCES serie(id_serie)
);

CREATE TABLE IF NOT EXISTS chapter(
    number_chapter SMALLINT NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    season_number SMALLINT NOT NULL,
		PRIMARY KEY (number_chapter,season_number),
		CONSTRAINT fk_chapter_season FOREIGN KEY (season_number) REFERENCES season(number_season)
);
CREATE TABLE IF NOT EXISTS participate(
	serie_id MEDIUMINT NOT NULL,
    actor_id MEDIUMINT NOT NULL,
		PRIMARY KEY (serie_id,actor_id),
		CONSTRAINT fk_participate_serie FOREIGN KEY (serie_id) REFERENCES serie(id_serie),
		CONSTRAINT fk_participate_actor FOREIGN KEY (actor_id) REFERENCES actor(id_actor)
);

CREATE TABLE IF NOT EXISTS platform (
	id_platform MEDIUMINT AUTO_INCREMENT NOT NULL,
    name VARCHAR (50) NOT NULL,
		PRIMARY KEY(id_platform)
);
CREATE TABLE IF NOT EXISTS issue(
	serie_id MEDIUMINT NOT NULL,
    platform_id MEDIUMINT NOT NULL,
		PRIMARY KEY (serie_id,platform_id),
        CONSTRAINT fk_issue_serie FOREIGN KEY (serie_id) REFERENCES serie(id_serie),
		CONSTRAINT fk_issue_platform FOREIGN KEY (platform_id) REFERENCES platform(id_platform)
		);

DROP INDEX name ON actor;
CREATE INDEX name ON actor (name);
SHOW INDEX FROM actor;

DROP INDEX name ON producer;
DROP INDEX email ON producer;
DROP INDEX number ON producer;
CREATE INDEX name ON producer (name);
CREATE INDEX email ON producer (email);
CREATE INDEX number ON producer (number);
SHOW INDEX FROM producer;

DROP INDEX title ON serie;
CREATE INDEX title ON serie (title);
SHOW INDEX FROM serie;

DROP INDEX title ON season;
CREATE INDEX title ON season (title);
SHOW INDEX FROM season;

SHOW INDEX FROM chapter;

SHOW INDEX FROM participate;

DROP INDEX name ON platform; 
CREATE INDEX name ON platform (name);
SHOW INDEX FROM platform;

SHOW INDEX FROM issue;
