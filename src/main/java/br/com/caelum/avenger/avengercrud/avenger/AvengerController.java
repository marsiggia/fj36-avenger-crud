package br.com.caelum.avenger.avengercrud.avenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.avenger.avengercrud.avenger.dto.input.AvengerInputDto;

@RestController
@RequestMapping("/api/avengers")
public class AvengerController {
	
	@Autowired
	private AvengerRepository avengerRepository;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody AvengerInputDto avengerInputDto) {
		avengerRepository.save(avenger);
	}

}
