package sasyami.boat.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;



@Builder
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component(value="Port")
@Table(name="port")
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="port_id")
    private Long id;
    private String country;
    private String town;
    private String port_name;
    private Point coordinates;

}
