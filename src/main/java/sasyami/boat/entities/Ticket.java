package sasyami.boat.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component(value="Ticket")
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_id")
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Port.class)
    private Port dep_port;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Port.class)
    private Port arr_port;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Client.class)
    private Client client;
    private Short cabin_class;
    private Double ticket_cost;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Flight.class)
    private Flight flight;


}
