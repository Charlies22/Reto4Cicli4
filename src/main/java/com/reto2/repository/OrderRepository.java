package com.reto2.repository;

import com.reto2.interfaces.OrderInterface;
import com.reto2.model.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Repository
public class OrderRepository {
    @Autowired
    private OrderInterface orderCrudRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Order> getAll(){
        return orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order){
        return orderCrudRepository.save(order);
    }

    public void update(Order order){
        orderCrudRepository.save(order);
    }

    public void delete(Order order){
        orderCrudRepository.delete(order);
    }

    public List<Order> getOrderByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }
    
    public List<Order> ordersSalesManByID(Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        List<Order> orders = mongoTemplate.find(query, Order.class);
        
        return orders;
    }
    
    public List<Order> ordersSalesManByState(String state, Integer id){
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id")
                .is(id).and("status").is(state);
        query.addCriteria(criterio);
        List<Order>orders=mongoTemplate.find(query, Order.class);
        return orders;
    }
    
    public List<Order> ordersSalesManByDate(String registerDay, Integer id){
        
     try{
         return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
     }catch(ParseException e){
         e.printStackTrace();
         return null;
     }
        
    }
    
    
}
