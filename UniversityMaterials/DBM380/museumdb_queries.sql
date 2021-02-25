/*
By: Ricardo L. Ortega UOPric623@phoenix.edu | otgcardo@yahoo.com 
SQL Queries for the art museum database

*/

SELECT * FROM `art_work`;
SELECT * FROM `artist`;
SELECT * FROM `art_location`;
SELECT * FROM `mus_location`;

/*The queries below this block comment are the same as the above queries SELECT * FROM */
SELECT aw_portrait_name, aw_portrait_size, aw_quality, aw_date_created FROM art_work;
SELECT a_fname, a_lname, a_city, a_state, a_phone_num FROM artist;
SELECT mus_id, a_id, aw_id FROM art_location;
SELECT mus_floor, mus_section, aw_id FROM mus_location;

/*Will return any row with the name Leonardo*/
SELECT * FROM artist WHERE a_fname = 'Leonardo';
/*Will return any row with a quality price greater than 5000*/
SELECT * FROM art_work WHERE aw_quality > 5000;

/*Some JOIN queries*/
SELECT * FROM art_work as aw INNER JOIN art_location as al ON aw.aw_id = al.aw_id;
SELECT aw_portrait_name, aw_date_created, mus_id FROM art_work as aw INNER JOIN art_location as al ON aw.aw_id = al.aw_id;
