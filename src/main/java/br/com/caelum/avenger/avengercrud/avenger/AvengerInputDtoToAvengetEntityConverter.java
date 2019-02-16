package br.com.caelum.avenger.avengercrud.avenger;

import br.com.caelum.avenger.avengercrud.avenger.dto.input.AvengerInputDto;

public class AvengerInputDtoToAvengetEntityConverter {
	
	private AvengerInputDto avengerDto;

	public AvengerInputDtoToAvengetEntityConverter(AvengerInputDto avengerDto) {
		this.avengerDto = avengerDto;
	}
	
	public AvengerEntity toEntity() {
		AvengerEntity avengerEntity = new AvengerEntity();
		avengerEntity.setAccepts(avengerDto.getAccepts());
		avengerEntity.setName(avengerDto.getName());
		avengerEntity.setSuperPowers(avengerDto.getSuperPowers());
		return avengerEntity;
	}
}
