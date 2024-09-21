package sasyami.boat.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

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
    private Long id;
    @Column(name = "constr_year")
    private Integer constrYear;
    private String status;
    @Column(name="ship_type")
    private String shipType;
    @Column(name="ship_name")
    private String shipName;
    private Integer tonns;
    private Boolean useable;
    @Column(name = "year_cost")
    private Integer yearCost;
    @Column(name = "ship_class")
    private Character shipClass;

}
