COPY tbllocalite(ville, npa, canton)
FROM 'src/main/resources/commune.csv'
DELIMITER ','
CSV HEADER;

DELETE
FROM tbllocalite
WHERE id IN (SELECT id
             FROM (SELECT id, ROW_NUMBER() OVER (PARTITION BY ville ORDER BY id) AS rnum FROM tbllocalite) t
             WHERE t.rnum > 1);
