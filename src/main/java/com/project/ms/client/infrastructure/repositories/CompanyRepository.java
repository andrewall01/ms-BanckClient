package com.project.ms.client.infrastructure.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.project.ms.client.domain.entities.Company;

@Repository
public interface CompanyRepository extends ReactiveMongoRepository<Company, String>{

}
