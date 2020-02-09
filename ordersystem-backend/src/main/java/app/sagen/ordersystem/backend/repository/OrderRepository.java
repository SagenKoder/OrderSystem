package app.sagen.ordersystem.backend.repository;

import app.sagen.ordersystem.backend.model.Customer;
import app.sagen.ordersystem.backend.model.OrderPlacement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderPlacement, Long> {

    List<OrderPlacement> findAllByCustomerOrderByDate(Customer customer);
    List<OrderPlacement> findAllByOrderByDate();

}
