package org.lesnobot.apirest.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudensDTO implements Serializable {

    private String id;
    private String fname;
    private String lname;
    private String username;
    private Date created_at;
    private Date updated_at;

}
