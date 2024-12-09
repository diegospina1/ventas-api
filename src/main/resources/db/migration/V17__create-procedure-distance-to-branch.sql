delimiter //

create procedure distanceToBranch(in refPoint point)
    begin
        select id
        from company_branches
        order by ST_Distance(location, refPoint)
        limit 1;
    end //
delimiter ;