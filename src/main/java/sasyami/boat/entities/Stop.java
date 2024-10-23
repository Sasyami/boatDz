package sasyami.boat.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Builder
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component(value="Stop")
@Table(name="stop")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stop_id")
    private Long id;
    private Double tonns;
    private Date arr_date;
    private Date dep_date;
    private Integer passengers;

    private Boolean visited;
    private Integer stnumber;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Flight.class)
    @JoinColumn(name = "flight_id",referencedColumnName = "flight_id")
    private Flight flight;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Port.class)
    @JoinColumn(name = "port_id", referencedColumnName = "port_id")
    private Port port;
}
