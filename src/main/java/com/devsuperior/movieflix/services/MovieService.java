package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	private final MovieRepository repository;

	MovieService(MovieRepository repository) {
		this.repository = repository;
	}

	@Transactional (readOnly = true)
	public Page<MovieDTO> findAllPaged(Pageable pageable) {
			Page<Movie> list = repository.findAll(pageable);
			return list.map(x -> new MovieDTO(x));
		}
	
	
	@Transactional (readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDTO(entity);
	}

}
