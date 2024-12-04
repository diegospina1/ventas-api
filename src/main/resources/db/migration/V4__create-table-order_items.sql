create table order_items(
    id int not null auto_increment,
    order_id int not null,
    product_id int not null,
    quantity int not null,
    total_price float not null,

    primary key (id),

    constraint fk_order_items_order_id foreign key (order_id) references orders(id),
    constraint fk_order_items_product_id foreign key (product_id) references products(id)

)