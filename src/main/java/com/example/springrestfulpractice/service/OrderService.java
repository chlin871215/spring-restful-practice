package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.model.Meal;
import com.example.springrestfulpractice.model.Order;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class OrderService {

    private List<Order> orderList;
    private Order order1 = new Order();
    private Order order2 = new Order();
    private List<Meal> meals;

    public OrderService() {
        //訂單1建置
        this.meals = new ArrayList<Meal>();
        this.meals.add(new Meal("hamburger", 100, "this is good"));
        this.meals.add(new Meal("cheeseburger", 520, "this is very good"));
        order1.setMealList(meals);
        order1.setWaiter("andy");
        order1.setSeq(1);
        //訂單2建置
        this.meals = new ArrayList<Meal>();
        this.meals.add(new Meal("chickenburger", 1000, "this is good"));
        this.meals.add(new Meal("beefburger", 500, "this is very good"));
        order2.setMealList(meals);
        order2.setWaiter("julia");
        order2.setSeq(2);
        //加入全部訂單
        this.orderList = new ArrayList<>();
        this.orderList.add(order1);
        this.orderList.add(order2);
    }

    public List<Order> getAllOrders() {
        return this.orderList;
    }

    public Order getOrderById(int seq) {
        for (Order order : this.orderList) {
            if (seq == order.getSeq()) {
                return order;
            }
        }
        return null;
    }

    public Order createOrder(Order order) {
        this.orderList.add(order);
        return order;
    }

    public Order updateOrder(int seq, Order order) {
        for (Order tempUpdateOrder : this.orderList) {
            if (seq == tempUpdateOrder.getSeq()) {
                tempUpdateOrder.setWaiter(order.getWaiter());
                tempUpdateOrder.setMealList(order.getMealList());
                tempUpdateOrder.setMealList(order.getMealList());
                return tempUpdateOrder;
            }
        }
        return null;
    }

    public Order deleteOrder(int seq) {
        for (Order tampDeleteOrder : this.orderList) {
            if (seq == tampDeleteOrder.getSeq()) {
                this.orderList.remove(tampDeleteOrder);
                return tampDeleteOrder;
            }
        }
        return null;
    }
}
