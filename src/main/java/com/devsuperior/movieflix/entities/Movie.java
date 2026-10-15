package com.devsuperior.movieflix.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_movie")
public class Movie implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String subTitle;
	
	@Column(name = "movie_year")
	private Integer year;
	private String imgUrl;
	private String synopsis;
	
	
	@OneToMany(mappedBy = "movies")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	public Movie() {}


	public Movie(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis) {
		super();
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubTitle() {
		return subTitle;
	}


	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public String getSynopsis() {
		return synopsis;
	}


	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}


	
	public List<Review> getReviews() {
		return reviews;
	}


	public Genre getGenre() {
		return genre;
	}
	
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
