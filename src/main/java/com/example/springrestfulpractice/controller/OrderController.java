package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.model.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {
        List<Order> orderList = this.orderService.getAllOrders();
        return orderList;
    }

    @GetMapping("/{seq}")
    public Order getOrderById(@PathVariable int seq) {
        Order order = this.orderService.getOrderById(seq);
        return order;
    }

    @PostMapping()
    public Order createOrder(@RequestBody Order order) {
        Order tempCreateOrder = this.orderService.createOrder(order);
        return tempCreateOrder;
    }

    @PutMapping("/{seq}")
    public Order updateOrder(@PathVariable int seq, @RequestBody Order order) {
        Order tempUpdateOrder = this.orderService.updateOrder(seq, order);
        return tempUpdateOrder;
    }


    @DeleteMapping("/{seq}")
    public Order deleteOrder(@PathVariable int seq) {
        Order tempDeleteOrder = this.orderService.deleteOrder(seq);
        return tempDeleteOrder;
    }

}
