delimiter //

create procedure createOrderItem(
    in id int,
    in order_id int,
    in product_id int,
    in quantity int,
    in total_price float
)
    begin
        INSERT INTO order_items(id, order_id, product_id, quantity, total_price)
        VALUES (id, order_id, product_id, quantity, total_price);
    end //

delimiter ;

