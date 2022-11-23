package com.example.onetoone.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.onetoone.entity.AddressEntity} entity
 */
@Getter
@Setter
public class AddressRequest extends UserResponse implements Serializable {
    private String address1;
    private String address2;
    private String state;
    private String city;
    private String pinCode;
}