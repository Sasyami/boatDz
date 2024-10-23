package sasyami.boat.dto;

import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import sasyami.boat.entities.Port;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;


@Builder
public class StopDTO implements Serializable {
    @Serial
    private static final long serialVersionUID =1;

    public PortDTO port;

    public Date arr_date;

    public Date dep_date;

}