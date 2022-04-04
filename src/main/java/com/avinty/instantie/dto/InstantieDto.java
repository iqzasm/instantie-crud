package com.avinty.instantie.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class    InstantieDto {

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long instNummer;

    @NonNull
    private String instNaam;

    @NonNull
    private Long instCategorie;

    @NonNull
    private Long instVolgNummer;

    @NonNull
    private Date instStartDatum;
    private Date instEndDatum;

    @NonNull
    private Date instAangeMaaktDatum;
    private String instAangeMaaktDoor;

    private Date instGewijzigingsDatum;
    private String instGewijzigdDoor;

}
