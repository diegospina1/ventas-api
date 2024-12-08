package com.commerce.application.service.itemReturn;

import com.commerce.application.dto.itemReturn.*;
import static com.commerce.application.mapper.ItemReturnMapper.returnMapper;

import com.commerce.application.model.entity.CompanyBranch;
import com.commerce.application.model.entity.ItemReturn;
import com.commerce.application.model.entity.OrderItem;
import com.commerce.application.repository.ItemReturnRepository;
import com.commerce.application.service.companyBranch.CompanyBranchSearch;
import com.commerce.application.service.customer.CustomerSearch;
import com.commerce.application.service.orderItem.OrderItemSearch;
import com.commerce.application.service.product.ProductSearch;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemReturnServiceImpl implements ItemReturnService {

    private final ItemReturnRepository repository;
    private final OrderItemSearch itemSearch;
    private final CompanyBranchSearch branchSearch;
    private final ProductSearch productSearch;
    private final CustomerSearch customerSearch;

    public ItemReturnServiceImpl(ItemReturnRepository repository, OrderItemSearch itemSearch, CompanyBranchSearch branchSearch, ProductSearch productSearch, CustomerSearch customerSearch) {
        this.repository = repository;
        this.itemSearch = itemSearch;
        this.branchSearch = branchSearch;
        this.productSearch = productSearch;
        this.customerSearch = customerSearch;
    }

    @Override
    public List<ItemReturnDto> listAllReturnsByCustomerId(Integer id) {
        checkCustomerInDb(id);
        return repository.findAllByCustomerId(id).stream()
                .map(returnMapper::toReturnDto)
                .collect(Collectors.toList());
    }

    private void checkCustomerInDb(Integer id) {
        if (!customerSearch.customerExistsById(id))
            throw new EntityNotFoundException();
    }

    @Override
    public List<ItemReturnDto> listAllReturnsByProductId(Integer id) {
        checkProductInDb(id);
        return repository.findAllByProductId(id).stream()
                .map(returnMapper::toReturnDto)
                .collect(Collectors.toList());
    }

    private void checkProductInDb(Integer id) {
        if (!productSearch.productExistsById(id))
            throw new EntityNotFoundException();
    }

    @Override
    public ItemReturnDto listOneItemReturn(Integer id) {
        ItemReturn itemReturn = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return returnMapper.toReturnDto(itemReturn);
    }

    @Override
    public ItemReturnDto createReturn(CreateReturnDto returnDto) {
        ItemReturn itemReturn = new ItemReturn();

        itemReturn.setReturn_date(returnDto.return_date());
        itemReturn.setReason(returnDto.reason());
        itemReturn.setQuantity(returnDto.quantity());
        itemReturn.setStatus(returnDto.status());
        itemReturn.setOrderItem(findOrderItem(returnDto.order_item_id()));
        itemReturn.setCompanyBranch(findCompanyBranch(returnDto.company_branch_id()));

        return returnMapper.toReturnDto(repository.save(itemReturn));
    }

    private OrderItem findOrderItem(Integer id){
        return itemSearch.findById(id);
    }

    private CompanyBranch findCompanyBranch(Integer id){
        return branchSearch.findById(id);
    }

    @Override
    public ItemReturnDto updateReturn(UpdateReturnDto returnDto) {
        ItemReturn itemReturn = repository.findById(returnDto.id())
                .orElseThrow(EntityNotFoundException::new);
        itemReturn.actualizar(returnDto);
        return returnMapper.toReturnDto(repository.save(itemReturn));
    }

    @Override
    public void deleteReturn(Integer id) {

    }
}
