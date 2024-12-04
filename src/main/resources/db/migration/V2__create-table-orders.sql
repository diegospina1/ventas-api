create table orders(
    id int not null auto_increment,
    customer_id int not null,
    order_date datetime not null,
    delivered_date datetime not null,

    primary key (id),
    constraint fk_orders_customer_id foreign key (customer_id) references customers(id)
)