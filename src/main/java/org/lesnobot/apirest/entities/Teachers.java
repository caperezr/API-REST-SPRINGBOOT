package org.lesnobot.apirest.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "teachers")
public class Teachers implements Serializable {
    @Id
    @Column(name = "PK_ID_TEACHER")
    private int idTeacher;

    @Column(name = "FIRST_NAME_TEACHER ")
    private String firstNameTeacher;
    @Column(name = "LAST_NAME_TEACHER")
    private String lastNameTeacher;
    @Column(name = "DNI_TEACHER")
    private String dniTeacher;
    @Column(name = "AGE_TEACHER")
    private int ageTeacher;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @PrePersist
    public void prePersist(){this.created_at = new Date();}
    @PreUpdate
    public void preUpdate(){this.updated_at = new Date();}



}
