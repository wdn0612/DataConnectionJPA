package com.dntech.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//
//public interface OrderRepository extends CrudRepository<OrderDetails, String> {
//}

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, String> {
}
