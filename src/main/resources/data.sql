LOAD
DATA LOCAL INFILE
'/Users/lucas/Documents/GitHub/semainier/commune.csv'
INTO TABLE tbllocalite
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(ville, npa, canton);

DELETE
FROM tbllocalite
WHERE id IN (SELECT id
             FROM (SELECT id, ROW_NUMBER() OVER (PARTITION BY ville ORDER BY id) AS rnum FROM tbllocalite) t
             WHERE t.rnum > 1);

INSERT INTO `tblusers` (`username`, `password`, `role`, `enabled`)
VALUES ('admin',
        '$2a$10$niqpnfWviYjdHM2wDvViaejUt0aPbfQUkNYTSe1Sbwc7uyf1X6ihy',
        'ROLE_ADMIN', 1);

DELETE
FROM tblusers
WHERE id IN (SELECT id
             FROM (SELECT id, ROW_NUMBER() OVER (PARTITION BY username ORDER BY id) AS rnum FROM tblusers) t
             WHERE t.rnum > 1);
