LOAD DATA LOCAL INFILE
'/Users/lucas/Documents/GitHub/semainier/commune.csv'
INTO TABLE tbl_localite
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ville, npa, canton);
DELETE FROM tbl_localite WHERE id IN (SELECT id FROM (SELECT id, ROW_NUMBER() OVER (PARTITION BY ville ORDER BY id) AS rnum FROM tbl_localite) t WHERE t.rnum > 1);
