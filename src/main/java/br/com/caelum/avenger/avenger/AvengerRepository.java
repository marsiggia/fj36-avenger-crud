package br.com.caelum.avenger.avenger;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface AvengerRepository extends Repository<AvengerEntity, Long> {
	
	List<AvengerEntity> findAll();

	Optional<AvengerEntity> findById(Long id);

	AvengerEntity save(AvengerEntity convert);

}
