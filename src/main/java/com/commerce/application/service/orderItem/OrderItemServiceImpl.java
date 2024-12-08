package com.commerce.application.service.orderItem;

import com.commerce.application.dto.orderItem.CreateOrderItemDto;
import com.commerce.application.dto.orderItem.OrderItemDto;
import com.commerce.application.dto.orderItem.UpdateOrderItemDto;
import com.commerce.application.helpers.DecimalFormatHelper;
import com.commerce.application.model.entity.Order;
import com.commerce.application.model.entity.OrderItem;
import com.commerce.application.model.entity.Product;
import com.commerce.application.repository.OrderItemRepository;
import com.commerce.application.service.order.OrderSearch;
import com.commerce.application.service.product.ProductSearch;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import static com.commerce.application.mapper.OrderItemMapper.orderItemMapper;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;
    private final OrderSearch orderSearch;
    private final ProductSearch productSearch;

    public OrderItemServiceImpl(OrderItemRepository repository, OrderSearch orderSearch, ProductSearch productSearch) {
        this.repository = repository;
        this.orderSearch = orderSearch;
        this.productSearch = productSearch;
    }

    @Override
    public List<OrderItemDto> listAllByOrderId(Integer orderId) {
        checkOrderInDb(orderId);
        List<OrderItem> orderItems = repository.findAllByOrderId(orderId);
        return orderItems.stream()
                .map(orderItemMapper::toOrderItemDto)
                .collect(Collectors.toList());
    }

    private void checkOrderInDb(Integer orderId) {
        if(!orderSearch.orderExistsById(orderId)){
            throw new EntityNotFoundException();
        }
    }

    @Override
    public OrderItemDto listOneOrderItem(Integer id) {
        OrderItem orderItem = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return orderItemMapper.toOrderItemDto(orderItem);
    }

    @Override
    public OrderItemDto createOrderItem(CreateOrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();

        orderItem.setOrder(findOrder(orderItemDto.order_id()));
        orderItem.setProduct(findProduct(orderItemDto.product_id()));
        orderItem.setQuantity(orderItemDto.quantity());
        orderItem.setTotal_price(calculateTotalPrice(orderItem.getProduct(), orderItemDto.quantity()));

        return orderItemMapper.toOrderItemDto(repository.save(orderItem));
    }

    private Order findOrder(Integer id) {
        return orderSearch.findOrderById(id);
    }

    private Product findProduct(Integer id) {
        return productSearch.findProductById(id);
    }

    private Float calculateTotalPrice(Product product, Integer quantity) {
        Float totalPrice = product.getPrice() * quantity;
        return DecimalFormatHelper.formatWithTwoDecimal(totalPrice);
    }

    @Override
    public OrderItemDto updateOrderItem(UpdateOrderItemDto orderItemDto) {
        OrderItem orderItem = repository.findById(orderItemDto.id())
                .orElseThrow(EntityNotFoundException::new);

        Float newPrice = calculateTotalPrice(orderItem.getProduct(), orderItemDto.quantity());
        orderItem.actualizar(orderItemDto, newPrice);

        return orderItemMapper.toOrderItemDto(repository.save(orderItem));
    }

    @Override
    public void deleteOrderItem(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public OrderItem findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}
