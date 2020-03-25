package ua.lviv.lgs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private int course;

}
