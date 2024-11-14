package sasyami.boat.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
@Data
public class CaptainDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1023;
    private Integer xp;
    private String passport;
    private Date license_end;
    private Integer age;
    private String fio;
}
