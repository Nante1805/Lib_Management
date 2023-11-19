CREATE TABLE IF NOT EXISTS subscriber (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    ref VARCHAR(255) NOT NULL
);

INSERT INTO subscriber values ('ID001', 'Jean', 'REF001');
INSERT INTO subscriber values ('ID002', 'Luis', 'REF002');
INSERT INTO subscriber values ('ID003', 'Victor ', 'REF003');