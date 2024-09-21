package sasyami.boat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceRequest implements Serializable {
    @Serial
    private static final long serialVersionUID =1;
    private Character shipClass;
}
