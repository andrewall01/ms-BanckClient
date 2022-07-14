package com.project.ms.client.domain.dto;

import java.util.Date;

import com.project.ms.client.domain.entities.Address;
import com.project.ms.client.domain.entities.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDto {
	private String id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String phoneNumber;
    private String mobileNumber;
    private String email;
    private Gender gender;
    private Address address;
    private char status;
    private Date createdAt;
    private Date updatedAt;

}
