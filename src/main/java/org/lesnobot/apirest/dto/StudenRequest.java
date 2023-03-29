package org.lesnobot.apirest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudenRequest implements Serializable {

    @JsonProperty("firstname")
    private String fname;
    @JsonProperty("lastname")
    private String lname;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
}
