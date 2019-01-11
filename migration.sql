CREATE DATABASE blog;

create user blog_user@localhost identified by "Codeup12!";
grant all on blog.* to blog_user@localhost;

