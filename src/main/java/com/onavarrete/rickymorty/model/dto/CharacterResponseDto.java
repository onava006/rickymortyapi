package com.onavarrete.rickymorty.model.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onavarrete.rickymorty.model.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;



@Builder
@AllArgsConstructor
public class CharacterResponseDto implements ResponseDto{

	public CharacterResponseDto() {};
	
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
