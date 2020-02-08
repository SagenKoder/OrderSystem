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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public ServiceType getService() {
        return service;
    }

    public void setService(ServiceType service) {
        this.service = service;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
