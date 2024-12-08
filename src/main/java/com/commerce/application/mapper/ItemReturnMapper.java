package com.commerce.application.mapper;

import com.commerce.application.dto.itemReturn.ItemReturnDto;
import com.commerce.application.model.entity.ItemReturn;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemReturnMapper {
    ItemReturnMapper returnMapper = Mappers.getMapper(ItemReturnMapper.class);

    @Mapping(target = "order_item_id", expression = "java(itemReturn.getOrderItem().getId())")
    @Mapping(target = "company_branch_id", expression = "java(itemReturn.getCompanyBranch().getId())")
    ItemReturnDto toReturnDto(ItemReturn itemReturn);
}
