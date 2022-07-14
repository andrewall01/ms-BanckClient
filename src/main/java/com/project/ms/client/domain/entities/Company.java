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
@Document(collection = "companies")
public class Company extends Client {
	
	@Field("business_name")
    private String businessName;

    @Field("ruc")
    private String ruc;
}