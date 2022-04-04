package com.avinty.instantie.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

/**
 * DB Table Entity Object for Table ALGEMEEN
 */
@Entity
@Table(name = "ALGEMEEN")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"algmTypes"})
@ToString(exclude = {"algmTypes"})
@NoArgsConstructor
@AllArgsConstructor
public class AlgemeenEntity implements Serializable {

    private static final long serialVersionUID = 0L;

    /**
     * Primary Key
     * Column Name : ALGUM_NUMMER
     * Property Name : algumNummer
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALGM_NUMMER", length = 4, nullable = false)
    private Long algmNummer;

    /**
     * Name
     * Column Name : ALGM_NAAM
     * Property Name : algmNaam
     */
    @Column(name = "ALGM_NAAM", length = 32, nullable = false, unique = true)
    private String algmNaam;

    /**
     * Types
     * Property Name: algmTypes
     * Assocaition : OneToMany
     */
    @OneToMany(mappedBy = "incaType", cascade = CascadeType.ALL)
    private Set<InstantieCategorieEntity> algmTypes = new HashSet<>();

    /**
     * Start Date of the record
     * Column Name: ALGM_STARTDATUM
     * Property Name: algmStartDatum
     */
    @Column(name = "ALGM_STARTDATUM", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private Date algmStartDatum;

    /**
     * End Date of the record
     * Column Name: ALGM_ENDDATUM
     * Property Name: algmEndDatum
     */
    @Column(name = "ALGM_ENDDATUM")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private Date algmEndDatum;

}
