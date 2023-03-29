package org.lesnobot.apirest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;
@Data
public class CurseRequest implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("credits")
    private int credits;

}
