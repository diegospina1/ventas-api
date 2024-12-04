delimiter //

create trigger check_stock_before_order_item
    before insert on order_items
    for each row

    begin
        declare stock_actual int;

        select stock into stock_actual
        from products
        where id = new.product_id;

        if stock_actual < new.quantity then
            signal sqlstate '45000'
            set message_text = 'Error: Not enough stock for the order.';
        end if;
    end //

delimiter ;