package app.sagen.ordersystem.backend.service;

import app.sagen.ordersystem.backend.model.*;
import app.sagen.ordersystem.backend.repository.OrderRepository;
import app.sagen.ordersystem.backend.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private PostNummerService postNummerService;
    private CustomerService customerService;

    @Autowired
    public OrderService(OrderRepository orderRepository, PostNummerService postNummerService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.postNummerService = postNummerService;
        this.customerService = customerService;
    }

    public List<OrderPlacement> findAll() {
        return dummyFindAll();
//        return orderRepository.findAllByOrderByDate();
    }

    public List<OrderPlacement> findAllBy(Customer customer) {
        return orderRepository.findAllByCustomerOrderByDate(customer);
    }

    public OrderPlacement create(OrderPlacement orderPlacement) {
        orderPlacement.setId(-1);
        return orderRepository.save(orderPlacement);
    }

    public OrderPlacement update(OrderPlacement orderPlacement, long id) {
        orderPlacement.setId(id);
        return orderRepository.save(orderPlacement);
    }

    public Optional<OrderPlacement> findById(long id) {
        return orderRepository.findById(id);
    }

    public Optional<OrderPlacement> delete(long id) {
        Optional<OrderPlacement> order = orderRepository.findById(id);
        order.ifPresent(orderPlacement -> orderRepository.delete(orderPlacement));
        return order;
    }

    // return dummy data
    public List<OrderPlacement> dummyFindAll() {
        List<OrderPlacement> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {

            Customer customer = new Customer();
            customer.setId((int)(Math.random() * 1000));
            customer.setEmail(StringUtils.getRandomString((int)(Math.random() * 10 + 5)) + "@gmail.com");
            customer.setName(StringUtils.getRandomString((int)(Math.random() * 10 + 5)) + " " + StringUtils.getRandomString((int)(Math.random() * 10 + 5)));
            customer.setPhone(StringUtils.getRandomNumberString(8));

            OrderPlacement orderPlacement = new OrderPlacement();
            orderPlacement.setId((int)(Math.random() * 1000));
            orderPlacement.setCustomer(customer);
            orderPlacement.setAddress(new Address() {{
                setId((int)(Math.random() * 1000));
                setLine1(StringUtils.getRandomString((int)(Math.random() * 10 + 5)) + " " + StringUtils.getRandomString((int)(Math.random() * 10 + 5)));
                setLine2(null);
                setZip(postNummerService.find("0854").get());
            }});
            orderPlacement.setDestination(new Address() {{
                setId((int)(Math.random() * 1000));
                setLine1(StringUtils.getRandomString((int)(Math.random() * 10 + 5)) + " " + StringUtils.getRandomString((int)(Math.random() * 10 + 5)));
                setLine2(null);
                setZip(postNummerService.find("0854").get());
            }});

            orderPlacement.setDate(new Date());
            orderPlacement.setService(ServiceType.MOVING);

            list.add(orderPlacement);
        }

        return list;
    }

    public List<OrderPlacement> dummyFindAllByCustomer(long customerId) {
        List<OrderPlacement> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {

            Customer customer = customerService.findById(customerId).get();

            OrderPlacement orderPlacement = new OrderPlacement();
            orderPlacement.setId((int)(Math.random() * 1000));
            orderPlacement.setCustomer(customer);
            orderPlacement.setAddress(new Address() {{
                setId((int)(Math.random() * 1000));
                setLine1(StringUtils.getRandomString((int)(Math.random() * 10 + 5)) + " " + StringUtils.getRandomString((int)(Math.random() * 10 + 5)));
                setLine2(null);
                setZip(postNummerService.find("0854").get());
            }});
            orderPlacement.setDestination(new Address() {{
                setId((int)(Math.random() * 1000));
                setLine1(StringUtils.getRandomString((int)(Math.random() * 10 + 5)) + " " + StringUtils.getRandomString((int)(Math.random() * 10 + 5)));
                setLine2(null);
                setZip(postNummerService.find("0854").get());
            }});

            orderPlacement.setDate(new Date());
            orderPlacement.setService(ServiceType.MOVING);

            list.add(orderPlacement);
        }

        return list;
    }

}
