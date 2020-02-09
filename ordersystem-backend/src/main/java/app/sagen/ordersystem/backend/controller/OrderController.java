package app.sagen.ordersystem.backend.controller;

import app.sagen.ordersystem.backend.model.OrderPlacement;
import app.sagen.ordersystem.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("customer/{customerId}")
    public List<OrderPlacement> allByCustomerId(@PathVariable long customerId) {
        return orderService.dummyFindAllByCustomer(customerId);
    }

    @GetMapping("")
    public List<OrderPlacement> all() {
        return orderService.findAll();
    }
}
