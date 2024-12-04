delimiter //

create trigger update_stock_return
    after insert on item_returns
    for each row

    begin
        update products p
        join order_items oi on p.id = oi.product_id
        set p.stock = p.stock + new.quantity
        where oi.id = new.order_item_id;
    end //

delimiter ;