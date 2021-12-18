package com.reto2.controller;

import com.reto2.model.Gadget;
import com.reto2.model.Order;
import com.reto2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id){
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return orderService.delete(id);
    }

    @GetMapping("/zona/{zone}")
    public  List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return orderService.getOrderByZone(zone);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManByID(@PathVariable("id")Integer id){
        return orderService.ordersSalesManByID(id);
    }
    
    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state")String state,@PathVariable("id")Integer id){
        return orderService.ordersSalesManByState(state, id); 
    }
    @GetMapping("/date/{registerDay}/{id}")
    public List<Order>ordersSalesManByDate(@PathVariable("registerDay")String registerDay,@PathVariable("id")Integer id){
        return orderService.ordersSalesManByDate(registerDay, id);
    }
}
