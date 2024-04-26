package ma.project.models.implemantations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.project.models.GenericEntity;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "reservations")
@Builder(toBuilder = true)
public class Reservation extends GenericEntity {
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickUpDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date retournDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Client client;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Vehicule vehicule;
}
