delimiter //

create trigger handle_stock_after_delete_order_item
    after DELETE on order_items
    for each row
begin
    update products
    set products.stock = stock + old.quantity
    where products.id = old.product_id;
end //

delimiter ;

