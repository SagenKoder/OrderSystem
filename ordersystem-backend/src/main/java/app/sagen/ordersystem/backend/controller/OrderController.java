package app.sagen.ordersystem.backend.controller;

import app.sagen.ordersystem.backend.model.OrderPlacement;
import app.sagen.ordersystem.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*
     * GET /order/customer/{customerId}
     * Returns all orders by a user with a given id as JSON array if OK
     */
    @GetMapping("customer/{customerId}")
    public List<OrderPlacement> allByCustomerId(@PathVariable long customerId) {
        return orderService.dummyFindAllByCustomer(customerId);
    }

    /*
     * GET /order/
     * Returns 200 and an array of all orders as JSON if OK
     */
    @GetMapping("")
    public List<OrderPlacement> all() {
        return orderService.findAll();
    }

    /*
     * POST /order/
     * Expects a valid Order object in body
     * Returns 200 and the created order as JSON if OK
     */
    @PostMapping("")
    public ResponseEntity<OrderPlacement> create(@RequestBody OrderPlacement orderPlacement) {
        OrderPlacement order = orderService.create(orderPlacement);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*
     * GET /order/date/{date}
     * Expects date in ISO DATE format
     * Returns 200 and all orders for the given date as JSON array if OK
     */
    @GetMapping("date/{date}")
    public ResponseEntity<List<OrderPlacement>> allByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return new ResponseEntity<>(orderService.findAllByDate(date), HttpStatus.OK);
    }

    /*
     * GET /order/{id}
     * Returns 404 if not found
     * Returns 200 and the requested order as JSON if OK
     */
    @GetMapping("{orderId}")
    public ResponseEntity<OrderPlacement> one(@PathVariable long orderId) {
        Optional<OrderPlacement> byId = orderService.findById(orderId);
        if(byId.isEmpty()) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }

    /*
     * PUT /order/{id}
     * Returns 404 if not found
     * Returns 200 and the updated order as JSON if OK
     */
    @PutMapping("{orderId}")
    public ResponseEntity<OrderPlacement> update(@PathVariable long orderId, @RequestBody OrderPlacement orderPlacement) {
        Optional<OrderPlacement> old = orderService.findById(orderId);
        if(old.isEmpty()) return ResponseEntity.notFound().build();

        OrderPlacement oldOrder = old.get();
        oldOrder.setService(orderPlacement.getService());
        oldOrder.setDate(orderPlacement.getDate());
        oldOrder.setCustomer(orderPlacement.getCustomer());
        oldOrder.setAddress(orderPlacement.getAddress());
        oldOrder.setDestination(orderPlacement.getDestination());

        OrderPlacement update = orderService.update(oldOrder, orderId);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    /*
     * DELETE /order/{id}
     * Returns 404 if not found
     * Returns 200 and the deleted order as JSON if OK
     */
    @DeleteMapping("{orderId}")
    public ResponseEntity<OrderPlacement> delete(@PathVariable long orderId) {
        Optional<OrderPlacement> byId = orderService.findById(orderId);
        if(byId.isEmpty()) return ResponseEntity.notFound().build();
        orderService.delete(orderId);
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }
}
