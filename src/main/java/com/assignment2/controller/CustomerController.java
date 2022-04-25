package com.assignment2.controller;

import com.assignment2.dtos.UserDTO;
import com.assignment2.dtos.OrderDTO;
import com.assignment2.dtos.RegisterDTO;
import com.assignment2.model.Customer;
import com.assignment2.service.CustomerService;
import com.assignment2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @GetMapping
    public ResponseEntity<Customer> getCustomer(UserDTO loginDTO) {
        Customer customer = customerService.getCustomer(loginDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CustomerController");
        return ResponseEntity.accepted().headers(headers).body(customer);
    }

    @PostMapping
    public void insertCustomer(@RequestBody RegisterDTO customer) {
        customerService.insertCustomer(customer);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDTO>> getOrders(@Param("username") String username){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CustomerController");
        List<OrderDTO> orderDTOS=orderService.getCustomerOrders(username);
        return ResponseEntity.accepted().headers(headers).body(orderDTOS);
    }
    @GetMapping("/order/pending")
    public ResponseEntity<List<OrderDTO>> getPendingOrders(@Param("username") String username){
        List<OrderDTO> orders=orderService.getPendingOrders(username);
        return ResponseEntity.ok(orders);
    }
}
