/*By: Ricardo L. Ortega UOPric623@phoenix.edu | otgcardo@yahoo.com */
CREATE DATABASE IF NOT EXISTS `museumdb`;
/**/
CREATE TABLE IF NOT EXISTS `art_work` (
  `aw_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `aw_portrait_name` VARCHAR(60) NOT NULL,
  `aw_portrait_size` INT NOT NULL,
  `aw_quality` FLOAT NOT NULL,
  `aw_date_created` DATE NOT NULL
);
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('Monalisa', 25, 9000.50, '1990-06-23'); /*Leonardo*/
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('The Kiss', 23, 100.50, '1918-06-02'); /*Gustav Klimt*/
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('The Sleeping Gypsy', 20, 2500.50, '1897-02-10'); /*Henri Rousseau*/
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('The Birth of Venus', 28, 1500.50, '1486-08-19'); /*Sandro Botticelli*/
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('Guernica', 22, 700.00, '1937-01-28'); /*Pablo Picasso*/
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('American Gothic', 20, 6300.00, '1930-11-16'); /*Grant Wood*/
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('Night Hawks', 27, 1000.50, '1942-03-11'); /*Edward Hopper*/
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('Anunciation', 15, 900.50, '1436-06-15'); /* Jan van Eyck*/
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('Man at the Cross Roads', 21, 3200.50, '1934-04-14'); /*Diego Rivera*/
INSERT INTO art_work(aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created) VALUES('Impression, Sunrise', 20, 2500.50, '1872-07-15'); /* Claude Monet*/

CREATE TABLE IF NOT EXISTS `artist` (
  `a_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `a_fname` VARCHAR(30) NOT NULL,
  `a_lname` VARCHAR(30) NOT NULL,
  `a_city` VARCHAR(16) NOT NULL,
  `a_state` VARCHAR(20) NOT NULL,
  `a_phone_num` INT(10) NOT NULL
);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Claude', 'Monet', 'Tampa', 'Florida', 8901239491);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Leonardo', 'Da Vinci', 'Bronx', 'New York', 3475593232);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Pablo', 'Picasso', 'Newark', 'New Jersey', 8787965693);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Grant', 'Wood', 'Bronx', 'New York', 6751132010);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Edward', 'Hopper', 'Queens', 'New York', 9872947862);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Jan van', 'Eyck', 'Los Angeles', 'California', 1230010390);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Diego', 'Rivera', 'Tampa', 'Florida', 3456199012);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Gustav', 'Klimt', 'Tampa', 'Florida', 1034682345);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Henri', 'Rousseau', 'Boston', 'Connecticut', 6250104403);
INSERT INTO artist(a_fname, a_lname, a_city, a_state, a_phone_num) VALUES('Sandro', 'Botticelli', 'Hoboken', 'New Jersey', 2128690912);

CREATE TABLE IF NOT EXISTS `mus_location` (
  `mus_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `mus_floor` VARCHAR(10) NOT NULL,
  `mus_section` VARCHAR(10) NOT NULL,
  `aw_id` INT REFERENCES art_work(aw_id) /*FK*/
);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 1', 'section a', 9);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 1', 'section b', 4);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 1', 'section c', 1);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 1', 'section d', 8);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 1', 'section e', 2);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 2', 'section a', 5);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 2', 'section b', 7);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 2', 'section c', 3);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 2', 'section d', 6);
INSERT INTO mus_location(mus_floor, mus_section, aw_id) VALUES('floor 2', 'section e', 10);

CREATE TABLE IF NOT EXISTS `art_location` (
  `al_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `mus_id` INT REFERENCES mus_location(mus_id), /*FK*/
  `a_id` INT REFERENCES artist(a_id), /*FK*/
  `aw_id` INT REFERENCES art_work(aw_id) /*FK*/
);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(1, 7, 9);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(2, 10, 4);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(3, 2, 1);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(4, 6, 8);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(5, 8, 2);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(6, 3, 5);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(7, 5, 7);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(8, 9, 3);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(9, 4, 6);
INSERT INTO art_location(mus_id, a_id, aw_id) VALUES(10, 1, 10);

/*A set of SQL Statements that returns all rows and all data for each table in your database.
Two SQL Statements that return a subset of columns and a subset of rows using the WHERE clause.
Two SQL Statements that join two or more tables in one query.  Look for primary and foreign keys 
to help you determine join points. Use the JOIN clause as a part of your queries.
*/
SELECT * FROM `art_work`;
SELECT * FROM `artist`;
SELECT * FROM `art_location`;
SELECT * FROM `mus_location`;

SELECT aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created FROM art_work;
SELECT a_fname, a_lname, a_city, a_state, a_phone_num FROM artist;
SELECT mus_id, a_id, aw_id FROM art_location;
SELECT mus_floor, mus_section, aw_id FROM mus_location;

SELECT * FROM artist WHERE a_fname = 'Leonardo';
SELECT * FROM art_work WHERE aw_quality > 5000;

SELECT * FROM art_work as aw INNER JOIN art_location as al ON aw.aw_id = al.aw_id;
SELECT aw_portrait_name, aw_date_created, mus_id FROM art_work as aw INNER JOIN art_location as al ON aw.aw_id = al.aw_id;





