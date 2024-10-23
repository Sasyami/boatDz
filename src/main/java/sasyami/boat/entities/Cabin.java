package sasyami.boat.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component(value="Cabin")
@Table(name = "cabin")
public class Cabin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cabin_id")
    private Long id;
    @Column(name = "cabin_class")
    private Short cabinClass;
    private Short places;
    private Integer price;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Ship.class)
    @JoinColumn(name = "ship_id", referencedColumnName = "ship_id")
    private Ship ship;
    @Column(name = "cabin_count")
    private Integer count;

}
