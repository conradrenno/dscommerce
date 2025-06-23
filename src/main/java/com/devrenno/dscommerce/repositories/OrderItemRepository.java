package com.devrenno.dscommerce.repositories;

import com.devrenno.dscommerce.entities.OrderItem;
import com.devrenno.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {


}
