-- Drop tables if they exist
DROP TABLE IF EXISTS wallet CASCADE;
DROP TABLE IF EXISTS profile CASCADE;

CREATE TABLE profile (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE wallet (
    id SERIAL PRIMARY KEY,
    wallet_name VARCHAR(255) UNIQUE NOT NULL,
    active BOOLEAN NOT NULL,
    profile_email VARCHAR(255) REFERENCES profile(email) ON DELETE CASCADE
);

-- Initial data
INSERT INTO profile(email, name) VALUES('AAAAA@email.com', 'Aname');
INSERT INTO profile(email, name) VALUES('BBBBB@email.com', 'Bname');
INSERT INTO profile(email, name) VALUES('CCCCC@email.com', 'Cname');
INSERT INTO wallet(wallet_name, active, profile_email) VALUES('AAAAA', true, 'AAAAA@email.com');
INSERT INTO wallet(wallet_name, active, profile_email) VALUES('BBBBB', false, 'BBBBB@email.com');
INSERT INTO wallet(wallet_name, active, profile_email) VALUES('CCCCC', false, 'CCCCC@email.com');
INSERT INTO wallet(wallet_name, active, profile_email) VALUES('AAAAA2', true, 'AAAAA@email.com');


