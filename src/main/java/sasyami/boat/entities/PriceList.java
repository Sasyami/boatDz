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
@Component(value="PriceList")
@Table(name="price_list")
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="price_list_id")
    private Long id;
    private String goods;
    private Double load_cost;
    private Double unload_cost;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Port.class)
    private Port port;

}
