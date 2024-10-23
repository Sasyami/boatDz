package sasyami.boat.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
@Builder
public class FlightAddUpdateRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;
    private Long id;
    private Integer distance;
    private Short guards;
    private Short ships;
}
