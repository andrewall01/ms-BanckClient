package com.project.ms.client.domain.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Client {
	
	@Id
    private String id;

    @Field("phone_number")
    private String phoneNumber;

    @Field("mobile_number")
    private String mobileNumber;

    @Field("email")
    private String email;

    @Field("address")
    private Address address;

    @Field("status")
    private char status;

    @Field("created_at")
    @CreatedDate
    private Date createdAt;

    @Field("updated_at")
    @LastModifiedDate
    private Date updatedAt;
}
