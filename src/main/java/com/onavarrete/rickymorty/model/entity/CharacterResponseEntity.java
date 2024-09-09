package com.onavarrete.rickymorty.model.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onavarrete.rickymorty.model.EntityResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;


@Builder
@AllArgsConstructor
public class CharacterResponseEntity implements EntityResponse {

	public CharacterResponseEntity(){}

	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private Map<String,String> origin;
	private Map<String,String> location;
	private String image;
	private List<String> episode;
	private String url;
	private String created;

	private HttpStatus responseStatus;

	public HttpStatus getApiResponseStatus(){
		return this.responseStatus;
	}
	public void setApiResponseStatus(HttpStatus httpResponseStatus) {
		this.responseStatus = httpResponseStatus;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Map<String, String> getOrigin() {
		return origin;
	}
	public void setOrigin(HashMap<String, String> origin) {
		this.origin = origin;
	}
	public Map<String, String> getLocation() {
		return location;
	}
	public void setLocation(HashMap<String, String> location) {
		this.location = location;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<String> getEpisode() {
		return episode;
	}
	public void setEpisode(ArrayList<String> episode) {
		this.episode = episode;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}	
	
	
	
	
}
