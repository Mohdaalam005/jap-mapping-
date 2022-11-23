package com.example.onetoone.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.example.onetoone.entity.UserEntity} entity
 */
@Getter
@Setter
public class UserRequest extends UserResponse implements Serializable {
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private AddressRequest address;
}