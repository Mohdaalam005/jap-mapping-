package com.example.onetoone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address1 ;
    private String address2 ;
    private String state ;
    private String city ;
    private String pinCode ;
    @OneToOne(mappedBy = "address")
    private UserEntity user;

}
