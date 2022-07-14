package com.project.ms.client.domain.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "people")
public class Person extends Client {
	
	@Field("firstName")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("gender")
    private Gender gender;

    @Field("id_number")
    private String idNumber;

}