package br.com.caelum.avenger.avengercrud.avenger;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="avenger")
@Entity(name="avenger")
public class AvengerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<SuperPowerType> superPowers = new HashSet<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
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
