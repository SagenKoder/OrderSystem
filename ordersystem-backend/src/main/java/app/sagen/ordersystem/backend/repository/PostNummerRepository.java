package app.sagen.ordersystem.backend.repository;

import app.sagen.ordersystem.backend.model.PostNummer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostNummerRepository extends JpaRepository<PostNummer, String> {

}
