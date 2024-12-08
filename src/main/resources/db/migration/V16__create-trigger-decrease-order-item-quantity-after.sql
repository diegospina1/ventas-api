delimiter //

create trigger decrease_order_item_quantity
    after insert on item_returns
    for each row

begin
    declare actual_quantity int;
    declare final_quantity int;

    select order_items.quantity into actual_quantity
    from order_items
    where order_items.id = new.order_item_id;

    set final_quantity = (actual_quantity - new.quantity);

    if final_quantity < 0 then
        signal sqlstate '45000'
            set message_text = 'Error: Not enough quantity to return.';
    end if;

    if final_quantity >= 0 then
        update order_items
        set quantity =  final_quantity
        where order_items.id = new.order_item_id;
    end if;
end //


delimiter ;