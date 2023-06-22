package pl.lderecki.gusapiconsumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AreaDTO {

    private int id;
    private String nazwa;

    @JsonProperty("id-nadrzedny-element")
    private int idNadrzednyElement;

    @JsonProperty("id-poziom")
    private int idPoziom;

    @JsonProperty("nazwa-poziom")
    private String nazwaPoziom;

    @JsonProperty("czy-zmienne")
    private boolean czyZmienne;
}
