delimiter //

create trigger reduce_final_price_on_return
    after insert on item_returns
    for each row

    begin
        declare price_unit float;

        select price into price_unit
        from order_items
        join products
        on order_items.product_id = products.id
        where order_items.id = new.order_item_id;

        update order_items
        set total_price = (total_price - (new.quantity * price_unit))
        where order_items.id = new.order_item_id;
    end //

delimiter ;