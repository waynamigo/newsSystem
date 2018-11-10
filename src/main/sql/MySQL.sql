
create table if not exists news (
  id int primary key not null,
  title varchar(255),
  content varchar(1023),
  publisherid int,
  reviewed boolean
);
CREATE TABLE if not exists user(
  id int primary key not null ,
  username varchar(255),
  passwd varchar(255),
  salt varchar(127)
);

