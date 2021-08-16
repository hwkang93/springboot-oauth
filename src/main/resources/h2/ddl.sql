DROP TABLE IF EXISTS user;

CREATE TABLE users (
    id int primary key,
    name varchar(50) not null,
    email varchar(100) not null,
    picture varchar(100),
    role varchar(10)
);

CREATE TABLE posts (
    id integer not null auto_increment,
    title varchar(200) not null,
    contents varchar(2000) not null,
    regist_email varchar(100) not null,
    regist_dt timestamp not null,
    update_dt timestamp,
    primary key(id)
);