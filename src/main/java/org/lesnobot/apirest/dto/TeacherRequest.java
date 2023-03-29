package org.lesnobot.apirest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherRequest implements Serializable {
    @JsonProperty("fname")
    private String firstNameTeacher;
    @JsonProperty("lname")
    private String lastNameTeacher;
    @JsonProperty("dni")
    private String dniTeacher;
    @JsonProperty("age")
    private int ageTeacher;
}
