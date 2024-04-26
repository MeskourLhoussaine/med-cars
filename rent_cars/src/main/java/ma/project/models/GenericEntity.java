package ma.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.project.metier.IAbstarct;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public abstract class GenericEntity implements Serializable, IAbstarct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @JsonIgnore
    private Date addDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = true)
    @JsonIgnore
    private Date updateDate = null;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = true)
    @JsonIgnore
    private Date deleteDate = null;
}
