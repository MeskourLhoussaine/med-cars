package ma.project.models.implemantations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.project.models.GenericEntity;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "clients")
@Builder(toBuilder = true)
public class Client extends GenericEntity {
    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 14)
    private String telephone;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Reservation> reservations;
}
