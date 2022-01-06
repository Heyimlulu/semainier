LOAD DATA LOCAL INFILE
'C:\\Users\\Lucas\\Documents\\GitHub\\semainier\\commune.csv'
INTO TABLE tbl_localite
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ville, npa, canton);
