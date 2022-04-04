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
public class AlgemeenDto {

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Long algmNummer;

    @NonNull
    private String algmNaam;

    @NonNull
    private Date algmStartDatum;
    private Date algmEndDatum;
}
