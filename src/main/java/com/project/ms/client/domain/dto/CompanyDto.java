package com.project.ms.client.domain.dto;

import java.util.Date;

import com.project.ms.client.domain.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

	private String id;
	private String businessName;
	private String ruc;
	private String phoneNumber;
	private String mobileNumber;
	private String email;
	private Address address;
	private char status;
	private Date createdAt;
	private Date updatedAt;
}
