package org.lesnobot.apirest.entities;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "curses")
public class Curses implements Serializable {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "credits")
    private int credits;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "update_at")
    private Date update_at;
    @PrePersist
    public void prePersist() {this.created_at = new Date();}
    @PreUpdate
    public void preUpdate() {this.update_at =new Date();}
}
