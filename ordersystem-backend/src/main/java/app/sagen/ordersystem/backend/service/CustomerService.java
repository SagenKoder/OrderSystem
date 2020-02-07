package app.sagen.ordersystem.backend.service;

import app.sagen.ordersystem.backend.model.Customer;
import app.sagen.ordersystem.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public long count() {
        return customerRepository.count();
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmailIgnoreCase(email);
    }

    public Optional<List<Customer>> findByName(String name) {
        return customerRepository.findByNameIgnoreCaseContaining(name);
    }

    public List<Customer> saveAll(Collection<Customer> data) {
        return customerRepository.saveAll(data);
    }

    public Customer create(Customer customer) {
        customer.setId(-1);
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer, long id) {
        customer.setId(id);
        customerRepository.save(customer);
        return customer;
    }

    public void delete(long id) {
        customerRepository.deleteById(id);
    }

}
