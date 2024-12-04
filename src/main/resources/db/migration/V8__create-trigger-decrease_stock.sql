delimiter //

create trigger decreaseStock
    after insert on order_items
    for each row

    begin
        update products
        set products.stock = stock - new.quantity
        where products.id = new.product_id;
    end //

delimiter ;