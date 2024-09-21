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
@Component(value="GoodsInfo")
@Table(name="goods_info")
public class GoodsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="goods_info_id")
    private Long id;
    private String goods_name;
    private Double goods_cost;
}
