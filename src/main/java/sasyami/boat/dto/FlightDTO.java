package sasyami.boat.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;
import sasyami.boat.entities.Port;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Builder
public class FlightDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;
    private List<StopDTO> stopDTOlist;
    private Long flightId;

}
