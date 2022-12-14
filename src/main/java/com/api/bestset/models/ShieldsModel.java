package com.api.bestset.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
@Table(name = "TB_SHIELDS")
public class ShieldsModel implements Serializable{
    private static final long serialVersionUID = 1L;    
    
    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String levelMin;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private String createdUser;

    @Column(nullable = true)
    private LocalDateTime lastUpdatedDate;
    
    @Column(nullable = true)
    private String lastUpdatedUser;

}
