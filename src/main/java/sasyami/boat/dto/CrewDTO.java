package sasyami.boat.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
@Data
@Builder
public class CrewDTO implements Serializable {
    @Serial
    private static final long serialVersionUID =1;
    private Long crewId;
    private Long flightId;
    private Long shipId;
    private Long captainId;

}
