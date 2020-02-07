package app.sagen.ordersystem.backend.controller;

import app.sagen.ordersystem.backend.model.Customer;
import app.sagen.ordersystem.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*
     * GET /customer
     * Returns 200 and an array of all Customers
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> all() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    /*
     * GET /customer/{id}
     * Returns 404 if not found
     * Returns 202 and the Customer if OK
     */
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> oneById(@PathVariable long id) {
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isEmpty()) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    /*
     * PUT /customer/{id}
     * Return 404 if not found
     * Returns 200 and the updated Customer if OK
     */
    @PutMapping(value = "{id}")
    public ResponseEntity<Customer> put(@PathVariable long id, @RequestBody Customer newCustomer) {
        Optional<Customer> oldCustomer = customerService.findById(id);
        if(oldCustomer.isEmpty()) return ResponseEntity.notFound().build();
        Customer customer = oldCustomer.get();
        customer.setEmail(newCustomer.getEmail());
        customer.setPhone(newCustomer.getPhone());
        customer.setName(newCustomer.getName());
        return new ResponseEntity<>(customerService.update(customer, id), HttpStatus.OK);
    }

    /*
     * DELETE /customer/{id}
     * Returns 404 if not found
     * Returns 200 and the deleted Customer if OK
     */
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Customer> delete(@PathVariable long id) {
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isEmpty()) return ResponseEntity.notFound().build();
        customerService.delete(id);
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }
}
