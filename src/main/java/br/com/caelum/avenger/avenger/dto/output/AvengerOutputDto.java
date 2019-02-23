package br.com.caelum.avenger.avenger.dto.output;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.avenger.avenger.CatastrofeType;
import br.com.caelum.avenger.avenger.SuperPowerType;

public class AvengerOutputDto {
	
	private Long id;
	
	private String name;
	
	private Set<SuperPowerType> superPowers = new HashSet<>();
	
	private Set<CatastrofeType> accepts = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SuperPowerType> getSuperPowers() {
		return superPowers;
	}

	public void setSuperPowers(Set<SuperPowerType> superPowers) {
		this.superPowers = superPowers;
	}

	public Set<CatastrofeType> getAccepts() {
		return accepts;
	}

	public void setAccepts(Set<CatastrofeType> accepts) {
		this.accepts = accepts;
	}
	
}
