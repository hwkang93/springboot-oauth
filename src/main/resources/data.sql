DROP TABLE IF EXISTS user;

CREATE TABLE users (
    id int primary key,
    name varchar(50) not null,
    email varchar(100) not null
);

INSERT INTO users (id, name, email) VALUES
    (1, 'hwkang93', 'k72780462@gmail.com');