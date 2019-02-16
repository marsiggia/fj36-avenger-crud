package br.com.caelum.avenger.avengercrud.avenger.dto.input;

import java.util.HashSet;
import java.util.Set;

import br.com.caelum.avenger.avengercrud.avenger.CatastrofeType;
import br.com.caelum.avenger.avengercrud.avenger.SuperPowerType;

public class AvengerInputDto {
	
	private String name;
	
	private Set<SuperPowerType> superPowers = new HashSet<>();
	
	private Set<CatastrofeType> accepts = new HashSet<>();

	public AvengerInputDto(String name, Set<SuperPowerType> superPowers, Set<CatastrofeType> accepts) {
		this.name = name;
		this.superPowers = superPowers;
		this.accepts = accepts;
	}

	public String getName() {
		return name;
	}

	public Set<SuperPowerType> getSuperPowers() {
		return superPowers;
	}

	public Set<CatastrofeType> getAccepts() {
		return accepts;
	}

}
