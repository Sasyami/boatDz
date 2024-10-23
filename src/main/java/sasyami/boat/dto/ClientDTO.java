package sasyami.boat.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
@Builder
public class ClientDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 3;
    private Long id;
    private Double account;
    private String fio;


}
