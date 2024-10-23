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
@Component(value="Goods")
@Table(name="goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="goods_id")
    private Long id;
    private Long tonns;
    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Declaration.class)
    private Declaration declaration;
    @ManyToOne( cascade = CascadeType.PERSIST, targetEntity = GoodsInfo.class)
    private GoodsInfo goodsInfo;


}
