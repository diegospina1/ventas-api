package com.commerce.application.service.order;

import com.commerce.application.dto.order.CreateOrderDto;
import com.commerce.application.dto.order.OrderDto;
import com.commerce.application.dto.order.UpdateOrderDto;
import com.commerce.application.model.entity.Customer;
import com.commerce.application.model.entity.Order;
import static com.commerce.application.mapper.OrderMapper.orderMapper;
import com.commerce.application.repository.OrderRepository;
import com.commerce.application.service.customer.CustomerSearch;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository repository;
    private final CustomerSearch customerSearch;

    public OrderServiceImpl(OrderRepository repository, CustomerSearch customerSearch) {
        this.repository = repository;
        this.customerSearch = customerSearch;
    }

    @Override
    public List<OrderDto> listAllOrdersByCustomerId(Integer customerId) {
        checkCustomerInDb(customerId);
        List<Order> orders = repository.findAllByCustomerId(customerId);
        return orders.stream()
                .map(orderMapper::toOrderDto)
                .collect(Collectors.toList());
    }

    private void checkCustomerInDb(Integer id){
        if(!customerSearch.customerExistsById(id)){
            throw new EntityNotFoundException();
        }
    }

    @Override
    public OrderDto listOneOrder(Integer id) {
        Order order = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return orderMapper.toOrderDto(order);
    }

    @Override
    public OrderDto createOrder(CreateOrderDto orderDto) {
        Order order = new Order();

        order.setCustomer(findCustomer(orderDto.customer_id()));
        order.setOrder_date(orderDto.order_date());
        order.setDelivered_date(orderDto.delivered_date());

        return orderMapper.toOrderDto(repository.save(order));
    }

    private Customer findCustomer(Integer id){
        return customerSearch.findCustomerById(id);
    }

    @Override
    public OrderDto updateOrder(UpdateOrderDto orderDto) {
        Order order = repository.findById(orderDto.id())
                .orElseThrow(EntityNotFoundException::new);
        order.actualizar(orderDto);
        return orderMapper.toOrderDto(repository.save(order));
    }

    @Override
    public void deleteOrder(Integer id) {

    }

    @Override
    public Order findOrderById(Integer id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Boolean orderExistsById(Integer id) {
        return repository.existsById(id);
    }
}
