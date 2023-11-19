CREATE TABLE IF NOT EXISTS author (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sex CHAR(1) CHECK (sex IN ('M', 'F')) NOT NULL
);

INSERT INTO author values ('ID001', 'Mick', 'M');
INSERT INTO author values ('ID002', 'Kail', 'F');
INSERT INTO author values ('ID003', 'Michel', 'M');
