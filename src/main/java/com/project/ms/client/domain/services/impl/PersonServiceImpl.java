package com.project.ms.client.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ms.client.domain.dto.PersonalDto;
import com.project.ms.client.domain.services.PersonService;
import com.project.ms.client.domain.utils.Utils;
import com.project.ms.client.infrastructure.repositories.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
    private PersonRepository personalDao;

	@Override
    public Flux<PersonalDto> findAll() {
        return personalDao.findAll().map(Utils::entityToDto);
    }

    @Override
    public Mono<PersonalDto> findById(String id) {
        return personalDao.findById(id).map(Utils::entityToDto);
    }

    @Override
    public Mono<PersonalDto> save(Mono<PersonalDto> personalDto) {
        return personalDto.map(Utils::dtoToEntity)
                .flatMap(personalDao::insert)
                .map(Utils::entityToDto);
    }

    @Override
    public Mono<PersonalDto> update(Mono<PersonalDto> personalDto, String id) {
        return personalDao.findById(id)
                .flatMap(p -> personalDto.map(Utils::dtoToEntity)
                .doOnNext(e -> e.setId(id))
                .doOnNext(e -> e.setCreatedAt(p.getCreatedAt())))
                .flatMap(personalDao::save)
                .map(Utils::entityToDto);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return personalDao.deleteById(id);
    }

}
