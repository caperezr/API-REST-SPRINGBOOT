package org.lesnobot.apirest.entities;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "studens")
public class Studens implements Serializable {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="fname")
    private String fname;
    
    @Column(name="lname")
    private String lname;
    
    @Column(name="username")
    private String userName;
    
    @Column(name="password")
    private String password;
    
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @PrePersist
    public void prePersist(){
        this.created_at = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        this.updated_at = new Date();
    }

}
