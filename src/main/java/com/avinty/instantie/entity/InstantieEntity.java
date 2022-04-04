package com.avinty.instantie.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * DB Table Entity Object for Table INSTANTIE
 */
@Entity
@Table(name = "INSTANTIE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"instCategorie"})
@ToString(exclude = {"instCategorie"})
@EntityListeners(AuditingEntityListener.class)
public class InstantieEntity implements Serializable {

    private static final long serialVersionUID = 0L;

    /**
     * Primary Key
     * Column Name : INST_NUMMER
     * Property Name : instNummer
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INST_NUMMER", length = 12, nullable = false)
    private Long instNummer;

    /**
     * Name of an Instance
     * Property Name: INST_NAAM
     * Column Name: instNaam
     */
    @Column(name = "INST_NAAM", length = 128, nullable = false)
    private String instNaam;

    /**
     * Category of an Instance (JoinColumn FK)
     * Column Name: INST_CATEGORIE
     * Property Name: instCategorie
     * Assocaition : ManyToOne
     */
    @ManyToOne
    @JoinColumn(name = "INST_CATEGORIE")
    private InstantieCategorieEntity instCategorie;

    /**
     * Order of an Instance
     * Column Name : INST_VOLGNUMMER
     * Property Name : instVolgNummer
     */
    @Column(name = "INST_VOLGNUMMER", length = 3, nullable = false)
    private Long instVolgNummer;


    /**
     * Start Date of an Instance
     * Column Name: INST_STARTDATUM
     * Property Name: instStartDatum
     */
    @Column(name = "INST_STARTDATUM", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private Date instStartDatum;

    /**
     * End Date of an Instance
     * Column Name: INST_ENDDATUM
     * Property Name: instEndDatum
     */
    @Column(name = "INST_ENDDATUM")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private Date instEndDatum;


    /**
     * Record Creation Date
     * Column Name: INST_AANGEMAAKT_DATUM
     * Property Name: instAangeMaaktDatum
     */
    @Column(name = "INST_AANGEMAAKT_DATUM", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    @CreatedDate
    private Date instAangeMaaktDatum;

    /**
     * Record Creator Login Name
     * Column Name: INST_AANGEMAAKT_DOOR
     * Property Name: incaAangeMaaktDoor
     */
    @Column(name = "INST_AANGEMAAKT_DOOR", length = 32, nullable = false)
    @CreatedBy
    private String instAangeMaaktDoor;

    /**
     * Record Edit Date
     * Column Name: INST_GEWIJZIGINGS_DATUM
     * Property Name: instGewijzigingsDatum
     */
    @Column(name = "INST_GEWIJZIGINGS_DATUM")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    @LastModifiedDate
    private Date instGewijzigingsDatum;

    /**
     * Record Editor Login Name
     * Column Name: INST_GEWIJZIGD_DOOR
     * Property Name: instGewijzigdDoor
     */
    @Column(name = "INST_GEWIJZIGD_DOOR", length = 32)
    @LastModifiedBy
    private String instGewijzigdDoor;

}
