package br.com.caelum.avenger.avengercrud.avenger;

import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public interface AvengerRepository {
	
	Set<AvengerEntity> findAll();
	
	void save(AvengerEntity avenger);
	
	void remove(Long avengerId);

}
