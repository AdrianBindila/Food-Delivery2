package com.assignment2.service;

import com.assignment2.dtos.OrderDTO;
import com.assignment2.dtos.mapper.OrderMapper;
import com.assignment2.model.Customer;
import com.assignment2.model.Order;
import com.assignment2.model.Restaurant;
import com.assignment2.repository.CustomerRepository;
import com.assignment2.repository.RestaurantRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Email service is responsible for sending emails to restaurant administrators
 * whenever a new order is placed by a user at that restaurant.
 */
@Service
@Log4j2
public class EmailService {
    /**
     * The Restaurant repository.
     */
    @Autowired
    RestaurantRepository restaurantRepository;
    /**
     * The Customer repository.
     */
    @Autowired
    CustomerRepository customerRepository;
    private static final String FROM_ADDRESS = "noreply@fooddelivery.com";
    /**
     * The Email sender.
     */
    @Autowired
    JavaMailSenderImpl emailSender;

    /**
     * Send an email to a specified address.
     * The email contains a subject and a text body with the details of the order.
     *
     * @param to      the address to send to
     * @param subject the subject
     * @param text    the text body
     */
    private void send(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(FROM_ADDRESS);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
            log.error("Mail not sent:\n" + to + "\n" + subject + "\n" + text);
        }
    }
    /**
     * Sends a mail with the order details.
     *
     * @param orderDTO       the order dto
     * @param username       the username
     * @param restaurantName the restaurant name
     */
    public void sendMail(OrderDTO orderDTO, String username, String restaurantName) {
        Customer customer = customerRepository.findByUsername(username).orElseThrow();
        Restaurant restaurant = restaurantRepository.findByName(restaurantName).orElseThrow();
        Order order = OrderMapper.getInstance().convertFromDTO(orderDTO, customer, restaurant);
        log.info("Sent email with order no."+order.getOrderId()+" to restaurant: "+restaurant.getName());
        send(restaurant.getAdmin().getEmail(), customer.getFirstName(), printOrderForMail(order));
    }
    private String printOrderForMail(Order o) {
        StringBuilder s = new StringBuilder();
        s.append("Total: ");
        s.append(o.getTotalPrice());
        s.append("\n");
        s.append("Address: ");
        s.append(o.getDeliveryAddress());
        s.append("\n");
        List<String> itemList = o.getItems().stream().map(item -> item.getName() + ": " + item.getPrice() + "\n").toList();
        s.append(itemList);
        System.out.println(s);
        return s.toString();
    }
}
