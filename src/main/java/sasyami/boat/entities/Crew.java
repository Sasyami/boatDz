package sasyami.boat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component(value="Crew")
@Table(name="crew")
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="crew_id")
    private Long id;
    @JsonIgnore
    @JoinColumn(name = "flight_id")
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Flight.class)
    private Flight flight;
    @JsonIgnore
    @JoinColumn(name = "captain_id")
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Captain.class)
    private Captain captain;
    @JsonIgnore
    @JoinColumn(name = "ship_id")
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Ship.class)
    private Ship ship;
}
