package com.lgs.loader.entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
public class Media {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String type;

    @Lob
    private byte[] data;

}
