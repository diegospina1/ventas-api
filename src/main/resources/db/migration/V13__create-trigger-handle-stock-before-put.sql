delimiter //

create trigger handle_stock_before_put_order_item
    before UPDATE on order_items
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

    if old.quantity > new.quantity then
        update products
        set products.stock = stock + (old.quantity - new.quantity)
        where products.id = new.product_id;
    end if;

    if old.quantity < new.quantity then
        update products
        set products.stock = stock - (new.quantity - old.quantity)
        where products.id = new.product_id;
    end if;

end //

delimiter ;