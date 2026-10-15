package com.devsuperior.movieflix.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	private final MovieService service;

	MovieController(MovieService service) {
		this.service = service;
	} 
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("title"));
		Page<MovieDTO> list = service.findAllPaged(pageRequest);		
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		MovieDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
