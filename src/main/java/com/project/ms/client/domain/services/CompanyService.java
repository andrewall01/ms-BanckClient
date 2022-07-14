package com.project.ms.client.domain.services;

import com.project.ms.client.domain.dto.CompanyDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyService {

	public Flux<CompanyDto> findAll();

	public Mono<CompanyDto> findById(String id);

	public Mono<CompanyDto> save(Mono<CompanyDto> companyDto);

	public Mono<CompanyDto> update(Mono<CompanyDto> companyDto, String id);

	public Mono<Void> deleteById(String id);

}
