create table company_branches(
    id int not null auto_increment,
    location point not null,
    name varchar(50) not null,

    primary key (id)
)