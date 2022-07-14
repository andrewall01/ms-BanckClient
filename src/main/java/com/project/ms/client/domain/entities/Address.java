package com.project.ms.client.domain.entities;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Field("description")
    private String description;
	
	@Field("district")
    private String district;
}