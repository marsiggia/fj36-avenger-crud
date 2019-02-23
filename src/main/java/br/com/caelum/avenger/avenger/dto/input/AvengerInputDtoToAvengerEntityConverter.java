package br.com.caelum.avenger.avenger.dto.input;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.caelum.avenger.avenger.AvengerEntity;

@Component
public class AvengerInputDtoToAvengerEntityConverter implements Converter<AvengerInputDto, AvengerEntity> {

	@Override
	public AvengerEntity convert(AvengerInputDto source) {
		AvengerEntity entity = new AvengerEntity();
		entity.setAccepts(source.getAccepts());
		entity.setName(source.getName());
		entity.setSuperPowers(source.getSuperPowers());
		return entity;
	}

}
