DROP TABLE IF EXISTS user;

-- 사용자 테이블
CREATE TABLE users (
    id int primary key,
    name varchar(50) not null,
    email varchar(100) not null,
    picture varchar(100),
    role varchar(10)
);

-- 시퀀스 생성하기
CREATE SEQUENCE USER_SEQ START WITH 1 INCREMENT BY 1;

-- 게시판 테이블
CREATE TABLE posts (
    id integer not null auto_increment,
    title varchar(200) not null,
    contents varchar(2000) not null,
    regist_email varchar(100) not null,
    regist_dt timestamp not null,
    update_dt timestamp,
    primary key(id)
);

-- 시퀀스 생성하기
CREATE SEQUENCE POST_SEQ START WITH 10 INCREMENT BY 10;