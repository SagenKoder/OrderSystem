package app.sagen.ordersystem.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class OrderPlacement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    private Customer customer;

    @ManyToOne(optional = false)
    private Address address;

    @ManyToOne // optional
    private Address destination;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType service;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateTime;

//    @JsonIgnore
//    @Version
//    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
//    private long version = 0L;

}
