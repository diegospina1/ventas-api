create table item_returns(
    id int not null auto_increment,
    order_item_id int not null,
    company_branch_id int not null,
    reason varchar(255) not null,
    quantity int not null,
    return_date int not null,

    primary key (id),

    constraint fk_item_returns_order_item_id foreign key (order_item_id) references order_items(id),
    constraint fk_item_returns_company_branch_id foreign key (company_branch_id) references company_branches(id)
)