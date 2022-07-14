package com.project.ms.client.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ms.client.domain.dto.CompanyDto;
import com.project.ms.client.domain.services.CompanyService;
import com.project.ms.client.domain.utils.Utils;
import com.project.ms.client.infrastructure.repositories.CompanyRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
    private CompanyRepository companyDao;

	@Override
    public Flux<CompanyDto> findAll() {
        return companyDao.findAll().map(Utils::entityToDto);
    }

    @Override
    public Mono<CompanyDto> findById(String id) {
        return companyDao.findById(id).map(Utils::entityToDto);
    }
    
    @Override
    public Mono<CompanyDto> save(Mono<CompanyDto> companyDto) {
        return companyDto.map(Utils::dtoToEntity)
                .flatMap(companyDao::insert)
                .map(Utils::entityToDto);
    }

    @Override
    public Mono<CompanyDto> update(Mono<CompanyDto> companyDto, String id) {
        return companyDao.findById(id)
                .flatMap(p -> companyDto.map(Utils::dtoToEntity)
                        .doOnNext(e -> e.setId(id))
                        .doOnNext(e -> e.setCreatedAt(p.getCreatedAt())))
                .flatMap(companyDao::save)
                .map(Utils::entityToDto);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return companyDao.deleteById(id);
    }

    

}
