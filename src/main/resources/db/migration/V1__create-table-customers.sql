create table customers(
    id int not null AUTO_INCREMENT,
    document varchar(10) not null unique,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    address point not null,

    primary key(id)
);