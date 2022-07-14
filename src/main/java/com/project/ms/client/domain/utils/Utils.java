package com.project.ms.client.domain.utils;

import org.springframework.beans.BeanUtils;

import com.project.ms.client.domain.dto.CompanyDto;
import com.project.ms.client.domain.dto.PersonalDto;
import com.project.ms.client.domain.entities.Company;
import com.project.ms.client.domain.entities.Person;

public class Utils {

	// Personal utils
	public static PersonalDto entityToDto(Person person) {
		PersonalDto personalDto = new PersonalDto();
		BeanUtils.copyProperties(person, personalDto);
		return personalDto;
	}

	public static Person dtoToEntity(PersonalDto personalDto) {
		Person person = new Person();
		BeanUtils.copyProperties(personalDto, person);
		return person;
	}

	// Company utils
	public static CompanyDto entityToDto(Company company) {
		CompanyDto companyDto = new CompanyDto();
		BeanUtils.copyProperties(company, companyDto);
		return companyDto;
	}

	public static Company dtoToEntity(CompanyDto companyDto) {
		Company company = new Company();
		BeanUtils.copyProperties(companyDto, company);
		return company;
	}

}
