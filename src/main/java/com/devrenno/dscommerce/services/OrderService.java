package com.devrenno.dscommerce.services;

import com.devrenno.dscommerce.dto.OrderDTO;
import com.devrenno.dscommerce.dto.OrderItemDTO;
import com.devrenno.dscommerce.entities.*;
import com.devrenno.dscommerce.repositories.OrderItemRepository;
import com.devrenno.dscommerce.repositories.OrderRepository;
import com.devrenno.dscommerce.repositories.ProductRepository;
import com.devrenno.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public OrderDTO findByid(Long id){
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticatedUser();
        order.setClient(user);

        for (OrderItemDTO itemDTO : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem orderItem = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getOrderItems().add(orderItem);
        }

        order = repository.save(order);
        orderItemRepository.saveAll(order.getOrderItems());
        return new OrderDTO(order);
    }
}
