package sasyami.boat.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.geo.Point;

import java.io.Serial;
import java.io.Serializable;
@Builder

public class PortDTO implements Serializable {
    @Serial
    private static final long serialVersionUID =7584932;
    public String country;
    public String town;
    public String portName;
    public Point coordinates;

}
