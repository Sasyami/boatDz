package sasyami.boat.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class ShipDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;
    private Integer constr_year;
    private String status;
    private String shipType;
    private String shipName;
    private Integer tonns;
    private Integer places1;
    private Integer places2;
    private Integer places3;
    private Boolean useable;


}
