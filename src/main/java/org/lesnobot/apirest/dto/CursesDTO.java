package org.lesnobot.apirest.dto;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class CursesDTO implements Serializable {
    private int id;
    private String name;
    private int credits;
    private Date created_at;
    private Date update_at;

}
