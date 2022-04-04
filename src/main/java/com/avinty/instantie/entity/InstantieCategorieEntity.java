package com.avinty.instantie.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * DB Table Entity Object for Table INSTANTIE_CATEGORIE
 */
@Entity
@Table(name = "INSTANTIE_CATEGORIE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"instanties", "incaType"})
@ToString(exclude = {"instanties", "incaType"})
@EntityListeners(AuditingEntityListener.class)
public class InstantieCategorieEntity implements Serializable {

    private static final long serialVersionUID = 0L;

    /**
     * Primary Key
     * Column Name : INCA_NUMMER
     * Property Name : incaNummer
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INCA_NUMMER", length = 8, nullable = false)
    private Long incaNummer;

    /**
     * Category Name
     * Property Name: incaNaam
     * Column Name: INCA_NAAM
     */
    @Column(name = "INCA_NAAM", length = 32, nullable = false, unique = true)
    private String incaNaam;

    /**
     * Category Type (Join Column FK)
     * Column Name: INCA_TYPE
     * Property Name: incaType
     * Assocaition : ManyToOne
     */
    @ManyToOne
    @JoinColumn(name = "INCA_TYPE")
    private AlgemeenEntity incaType;

    /**
     * Instanties
     * Property Name: instanties
     * Assocaition : OneToMany
     */
    @OneToMany(mappedBy = "instCategorie", cascade = CascadeType.ALL)
    private Set<InstantieEntity> instanties = new HashSet<>();

    /**
     * Record Creation Date
     * Column Name: INCA_AANGEMAAKT_DATUM
     * Property Name: incaAangeMaaktDatum
     */
    @Column(name = "INCA_AANGEMAAKT_DATUM", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    @CreatedDate
    private Date incaAangeMaaktDatum;

    /**
     * Record Creator Login Name
     * Column Name: INCA_AANGEMAAKT_DOOR
     * Property Name: incaAangeMaaktDoor
     */
    @Column(name = "INCA_AANGEMAAKT_DOOR", length = 32, nullable = false)
    @CreatedBy
    private String incaAangeMaaktDoor;

    /**
     * Record Edit Date
     * Column Name: INCA_GEWIJZIGINGS_DATUM
     * Property Name: incaGewijzigingsDatum
     */
    @Column(name = "INCA_GEWIJZIGINGS_DATUM")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    @LastModifiedDate
    private Date incaGewijzigingsDatum;

    /**
     * Record Editor Login Name
     * Column Name: INCA_GEWIJZIGD_DOOR
     * Property Name: incaGewijzigdDoor
     */
    @Column(name = "INCA_GEWIJZIGD_DOOR", length = 32)
    @LastModifiedBy
    private String incaGewijzigdDoor;


}
