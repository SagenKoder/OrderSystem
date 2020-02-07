package app.sagen.ordersystem.backend.initialization;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DatabaseInitializer {

    private PostNummerInitializer postNummerInitializer;
    private CustomerInitializer customerInitializer;

    @Autowired
    public DatabaseInitializer(PostNummerInitializer postNummerInitializer, CustomerInitializer customerInitializer) {
        this.postNummerInitializer = postNummerInitializer;
        this.customerInitializer = customerInitializer;
    }

    @PostConstruct
    private void setup() {
        postNummerInitializer.load();
        customerInitializer.load();
    }

}
