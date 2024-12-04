delimiter //

create procedure return_report()
    begin
        select
            year(return_date) as year,
            month(return_date) as month,
            order_items.product_id,
            sum(item_returns.quantity) as total_quantity,
            group_concat(distinct reason) as reasons
        from item_returns
        join order_items on item_returns.order_item_id = order_items.id
        group by year, month, order_items.product_id
        order by year, month, order_items.product_id;
    end //
delimiter ;