package app.sagen.ordersystem.backend.initialization;

import app.sagen.ordersystem.backend.model.Customer;
import app.sagen.ordersystem.backend.service.CustomerService;
import app.sagen.ordersystem.backend.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerInitializer {

    private CustomerService customerService;

    @Autowired
    public CustomerInitializer(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Async("threadPoolTaskExecutor")
    public void load() {
        if(customerService.count() > 0) {
            return;
        }

        log.info("Creating customers....");

        for(int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            customer.setEmail(StringUtils.getRandomString((int)(Math.random() * 10 + 5)) + "@gmail.com");
            customer.setName(StringUtils.getRandomString((int)(Math.random() * 10 + 5)) + " " + StringUtils.getRandomString((int)(Math.random() * 10 + 5)));
            customer.setPhone(StringUtils.getRandomNumberString(8));
            customerService.create(customer);
        }

        log.info("Completed!");
    }
}
