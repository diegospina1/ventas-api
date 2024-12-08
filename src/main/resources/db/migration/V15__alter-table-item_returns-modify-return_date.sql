alter table item_returns modify return_date datetime not null;
alter table item_returns add status varchar(50) not null;