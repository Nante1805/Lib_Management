CREATE TABLE IF NOT EXISTS book(
     id VARCHAR(255) PRIMARY KEY,
     book_name VARCHAR(255) NOT NULL,
     page_numbers INT CHECK(page_numbers > 0) NOT NULL,
     release_date DATE NOT NULL,
     topics topic[],
     id_author VARCHAR(255) REFERENCES author(id)
);

INSERT INTO book VALUES ( 'ID001', 'COOL', 20, '2013-05-01', '{ROMANCE}', 'ID003' );
INSERT INTO book VALUES ( 'ID002', 'NICE', 700, '2013-02-01', '{OTHER,COMEDY}', 'ID002');
INSERT INTO book VALUES ( 'ID003', 'LOL', 2, '2003-03-01', '{COMEDY}', 'ID003');