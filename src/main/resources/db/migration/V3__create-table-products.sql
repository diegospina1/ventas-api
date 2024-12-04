create table products(
    id int not null auto_increment,
    category varchar(25) not null,
    stock int not null,
    price float not null,

    primary key (id)
)