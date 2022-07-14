package com.project.ms.client.domain.services;

import com.project.ms.client.domain.dto.PersonalDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
	
	public Flux<PersonalDto> findAll();

	public Mono<PersonalDto> findById(String id);

	public Mono<PersonalDto> save(Mono<PersonalDto> personalDto);

	public Mono<PersonalDto> update(Mono<PersonalDto> personalDto, String id);

	public Mono<Void> deleteById(String id);

}
