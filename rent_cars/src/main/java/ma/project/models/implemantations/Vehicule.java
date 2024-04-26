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
@Table(name = "vehicules")
@Builder(toBuilder = true)
public class Vehicule extends GenericEntity {
    @Column(nullable = false)
    private String image;

    @Column(nullable = false, length = 12, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private Integer model;

    @Column(nullable = false, length = 25)
    private String marque;

    @Column(nullable = false, length = 10)
    private String color;

    @Column(nullable = false, length = 1)
    private Character boiteVetisse;

    @Column(nullable = false)
    private Boolean climatiseur;

    @Column(nullable = false, length = 1)
    private Character carburant;

    @Column(nullable = false)
    private Integer placeNumber;

    @Column(nullable = false)
    private Integer nombrePort;

    @Column(nullable = false)
    private Double priceDay;

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Reservation> reservations;
}
