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
@Component(value="Declaration")
@Table(name="declaration")
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="declaration_id")
    private Long id;
    private String status;
    private Double declaration_cost;
    @ManyToOne( cascade = CascadeType.PERSIST, targetEntity = Port.class)
    private Port dep_port;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Port.class)
    private Port arr_port;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Flight.class)
    private Flight flight;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Client.class)
    private Client client;


}
