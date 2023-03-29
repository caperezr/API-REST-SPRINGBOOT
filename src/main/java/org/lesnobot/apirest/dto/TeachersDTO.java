package org.lesnobot.apirest.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TeachersDTO implements Serializable {
    private int id;
    private String firstNameTeacher;
    private String lastNameTeacher;
    private String dniTeacher;
    private int ageTeacher;
    private Date created_at;
    private Date updated_at;
}
