package com.devrenno.dscommerce.services;

import com.devrenno.dscommerce.dto.OrderDTO;
import com.devrenno.dscommerce.entities.Order;
import com.devrenno.dscommerce.repositories.OrderRepository;
import com.devrenno.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findByid(Long id){
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
