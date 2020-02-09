package app.sagen.ordersystem.backend.repository;

import app.sagen.ordersystem.backend.model.OrderPlacement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderPlacement, Long> {
}
