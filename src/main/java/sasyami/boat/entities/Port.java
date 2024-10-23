package sasyami.boat.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CompositeType;
import org.hibernate.annotations.Type;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import sasyami.boat.Types.PointType;


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
    @Column(name = "port_name")
    private String portName;
    @Type(PointType.class)
    private Point coordinates;

}
