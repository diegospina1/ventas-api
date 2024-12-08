package com.commerce.application.service.itemReturn;

import com.commerce.application.dto.itemReturn.*;
import jakarta.validation.Valid;

import java.util.List;

public interface ItemReturnService {
    List<ItemReturnDto> listAllReturnsByCustomerId(Integer id);

    List<ItemReturnDto> listAllReturnsByProductId(Integer id);

    ItemReturnDto listOneItemReturn(Integer id);

    ItemReturnDto createReturn(@Valid CreateReturnDto returnDto);

    ItemReturnDto updateReturn(@Valid UpdateReturnDto returnDto);

    void deleteReturn(Integer id);
}
