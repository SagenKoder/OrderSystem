package app.sagen.ordersystem.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String line1;
    private String line2;
    @ManyToOne(optional = false)
    private PostNummer zip;

//    @JsonIgnore
//    @Version
//    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
//    private long version = 0L;

}
