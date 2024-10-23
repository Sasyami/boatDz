package sasyami.boat.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Data
public class ShipNameResponse implements Serializable {
    @Serial private static final long serialVersionUID =1;
    private Long id;
    private String name;
    private Integer constr_year;
    private Integer tonns;
    private String ship_type;


}
