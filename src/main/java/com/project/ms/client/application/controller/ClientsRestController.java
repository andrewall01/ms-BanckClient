package com.project.ms.client.application.controller;

import java.util.HashMap;
import java.util.Map;
import java.net.URI;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.project.ms.client.domain.dto.CompanyDto;
import com.project.ms.client.domain.dto.PersonalDto;
import com.project.ms.client.domain.services.CompanyService;
import com.project.ms.client.domain.services.PersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clients")
public class ClientsRestController {
	
	@Autowired
    private PersonService personService;

    @Autowired
    private CompanyService companyService;
    
    // Personal clients endpoints
    @GetMapping("/personal")
    public Flux<PersonalDto> getAllPeople() {
        return personService.findAll();
    }

    @GetMapping("/personal/{id}")
    public Mono<PersonalDto> getPerson(@PathVariable String id) {
        return personService.findById(id);
    }

	@PostMapping("/personal/save")
	public Mono<PersonalDto> savePerson(@RequestBody Mono<PersonalDto> personalDto) {
		 return personService.save(personalDto);
		/*Map<String, Object> response = new HashMap<>();

		return personService.save(personalDto).map(p -> {
			response.put("cliente", p);
			response.put("mensaje", "Cliente guardado con exito");
			response.put("timestamp", new Date());
			return ResponseEntity.created(URI.create("/api/clients/".concat(p.getId())))
					.contentType(MediaType.APPLICATION_JSON_UTF8).body(response);
		}).onErrorResume(t -> {
			return Mono.just(t).cast(WebExchangeBindException.class).flatMap(e -> Mono.just(e.getFieldErrors()))
					.flatMapMany(Flux::fromIterable)
					.map(fieldError -> "El campo: " + fieldError.getField() + " " + fieldError.getDefaultMessage())
					.collectList().flatMap(list -> {
						response.put("errors", list);
						response.put("timestamp", new Date());
						response.put("status", HttpStatus.BAD_REQUEST.value());

						return Mono.just(ResponseEntity.badRequest().body(response));
					});
		});*/

	}

    @PutMapping("/personal/update/{id}")
    public Mono<PersonalDto> updatePerson(@RequestBody Mono<PersonalDto> personalDto, @PathVariable String id) {
        return personService.update(personalDto, id);
    }

    @DeleteMapping("/personal/delete/{id}")
    public Mono<Void> deletePerson(@PathVariable String id) {
        return personService.deleteById(id);
    }
    
 // Business clients endpoints
    @GetMapping("/company")
    public Flux<CompanyDto> getAllCompanys() {
        return companyService.findAll();
    }

    @GetMapping("/company/{id}")
    public Mono<CompanyDto> getCompany(@PathVariable String id) {
        return companyService.findById(id);
    }

    @PostMapping("/company/save")
    public Mono<CompanyDto> saveCompany(@RequestBody Mono<CompanyDto> companyDto) {
        return companyService.save(companyDto);
    }

    @PutMapping("/company/update/{id}")
    public Mono<CompanyDto> updateCompany(@RequestBody Mono<CompanyDto> companyDto, @PathVariable String id) {
        return companyService.update(companyDto, id);
    }

    @DeleteMapping("/company/delete/{id}")
    public Mono<Void> deleteCompany(@PathVariable String id) {
        return companyService.deleteById(id);
    }      

}

