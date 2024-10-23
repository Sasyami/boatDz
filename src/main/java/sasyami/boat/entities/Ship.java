package sasyami.boat.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sasyami.boat.service.CabinService;

import java.util.List;

@Builder
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component(value="Ship")
public class Ship {
    @Id
    @Column(name="ship_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "constr_year")
    private Integer constrYear;
    private String status;
    @Column(name="ship_type")
    private String shipType;
    @Column(name="ship_name")
    private String shipName;
    private Integer tonns;
    @Column(name ="useable")
    public Boolean isUseable;
    @Column(name = "year_cost")
    private Integer yearCost;
    @Column(name = "ship_class")
    private Character shipClass;
    @OneToMany(targetEntity = Cabin.class, mappedBy = "id")

    private List<Cabin> cabins;

}
