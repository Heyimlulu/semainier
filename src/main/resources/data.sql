--LOAD
--DATA LOCAL INFILE
--'src/main/resources/commune.csv'
--INTO TABLE tbllocalite
--FIELDS TERMINATED BY ','
--ENCLOSED BY '"'
--LINES TERMINATED BY '\n'
--IGNORE 1 ROWS
--(ville, npa, canton);

COPY tbllocalite(ville, npa, canton)
FROM 'src/main/resources/commune.csv'
DELIMITER ','
CSV HEADER;

DELETE
FROM tbllocalite
WHERE id IN (SELECT id
             FROM (SELECT id, ROW_NUMBER() OVER (PARTITION BY ville ORDER BY id) AS rnum FROM tbllocalite) t
             WHERE t.rnum > 1);
