use blog;

-- create table users (
-- id long not null AUTO_INCREMENT,
-- username varchar(255) not null,
-- email varchar(255) not null,
-- password varchar(255) not null,
-- primary key (id),
-- foreign key (post_id) references posts(id)
-- );

insert into users (username, email, password) 
values('admin', 'admin@gmail.com', 'password');