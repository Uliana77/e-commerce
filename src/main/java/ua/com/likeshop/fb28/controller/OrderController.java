package ua.com.likeshop.fb28.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.likeshop.fb28.controller.body.OrderBody;
import ua.com.likeshop.fb28.entity.Orders;
import ua.com.likeshop.fb28.entity.Product;
import ua.com.likeshop.fb28.repository.OrderRepository;
import ua.com.likeshop.fb28.repository.ProductRepisitory;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepisitory productRepisitory;

    @PostMapping("/order")
    public String addOrder(@RequestBody OrderBody order, HttpSession session) {
        List<Long> ids = (List<Long>) session.getAttribute(CartController.CART_IDS);
        List<Product> products = productRepisitory.getProductsByIds(ids);
        Orders entity = new Orders(order.getName(), order.getPhone(), products);
        orderRepository.save(entity);
        return "ok";
    }
}



/*
* {
* name:"nam",
* phone: "+3027091423434",
* ids: [1,2,3,4,5,74,3]
* }
*
* */