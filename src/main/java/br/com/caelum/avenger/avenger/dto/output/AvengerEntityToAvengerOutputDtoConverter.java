package br.com.caelum.avenger.avenger.dto.output;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.caelum.avenger.avenger.AvengerEntity;

@Component
public class AvengerEntityToAvengerOutputDtoConverter implements Converter<AvengerEntity, AvengerOutputDto> {

	@Override
	public AvengerOutputDto convert(AvengerEntity source) {
		AvengerOutputDto dto = new AvengerOutputDto();
		dto.setId(source.getId());
		dto.setAccepts(source.getAccepts());
		dto.setName(source.getName());
		dto.setSuperPowers(source.getSuperPowers());
		return dto;
	}

}
