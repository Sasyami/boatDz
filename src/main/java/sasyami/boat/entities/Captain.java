package sasyami.boat.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Builder
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component(value="Captain")
@Table(name="captain")
public class Captain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="captain_id")
    private Long id;
    private Integer xp;
    private String passport;
    private Date license_end;
    private Integer age;
    private String fio;



}
