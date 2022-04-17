package com.dntech.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping(method = RequestMethod.PUT, path = "/updateOrderJPA")
    public @ResponseBody String updateOrderDetails(@RequestParam String userId, @RequestParam String date){
        Optional<OrderDetails> result = orderRepository.findById(userId);
        if (result.isPresent()){
            OrderDetails orderDetails = result.get();
            orderDetails.setOrderDate(date);
            orderRepository.save(orderDetails);
            return "Order date has been updated";
        }
        return "Failed to find the specified userId";
    }

    @PutMapping(path = "/updateOrderJDBC")
    public @ResponseBody String updateOrderDetailsJDBC(@RequestParam String userId, @RequestParam String date) throws SQLException {
        orderDAO.updateOrderDateByUserId(userId, date);
        System.out.println(TestEnum.STOP_LIMIT.name());
        return "Order date has been updated using JDBC";
    }

    @GetMapping(path = "/addOrder") // TODO: Change this to post mapping with RequestBody
    public @ResponseBody String addOrderDetails(){
        OrderDetails order = new OrderDetails();
        order.setUserId("u0001");
        order.setItemId("i0001");
        order.setOrderDate("22032022");
        orderRepository.save(order);
        return "New order saved " + order.toString();
    }
}
