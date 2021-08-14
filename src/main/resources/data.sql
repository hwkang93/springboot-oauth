DROP TABLE IF EXISTS user;

CREATE TABLE users (
    id int primary key,
    name varchar(50) not null,
    email varchar(100) not null
);

INSERT INTO users (id, name, email) VALUES
    (1, 'hwkang93', 'k72780462@gmail.com');

CREATE TABLE posts (
    id int primary key,
    title varchar(200) not null,
    contents varchar(2000) not null,
    regist_email varchar(100) not null,
    regist_dt timestamp not null,
    update_dt timestamp
)