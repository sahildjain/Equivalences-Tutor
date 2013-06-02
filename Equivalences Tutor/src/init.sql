DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS equivalence CASCADE;

CREATE TABLE accounts
(
  id SERIAL PRIMARY KEY,
  username VARCHAR(12) NOT NULL,
  password VARCHAR(100) NOT NULL
);

CREATE TABLE equivalence
(
	id SERIAL PRIMARY KEY,
	account INTEGER REFERENCES accounts (id),
	lefteq VARCHAR(300) NOT NULL,
	righteq VARCHAR(300) NOT NULL
);