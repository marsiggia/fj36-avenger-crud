package br.com.caelum.avenger.avenger;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.caelum.avenger.avenger.dto.input.AvengerInputDto;
import br.com.caelum.avenger.avenger.dto.input.AvengerInputDtoToAvengerEntityConverter;
import br.com.caelum.avenger.avenger.dto.output.AvengerEntityToAvengerOutputDtoConverter;
import br.com.caelum.avenger.avenger.dto.output.AvengerOutputDto;

@RestController
@RequestMapping(AvengerController.DEFAULT_URI)
public class AvengerController {
	
	public static final String DEFAULT_URI = "/api/avengers";
	
	private static final String PATH_VARIABLE_ID = "id";
	
	@Autowired
	private AvengerRepository avengerRepository;
	
	@Autowired
	private AvengerInputDtoToAvengerEntityConverter inputConverter;
	
	@Autowired
	private AvengerEntityToAvengerOutputDtoConverter outputConverter;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AvengerOutputDto>> getAll() {
		List<AvengerOutputDto> foundedAvengers = avengerRepository
															.findAll()
															.stream()
															.map(outputConverter::convert)
															.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(foundedAvengers);
	}
	
	@GetMapping(value="{"+PATH_VARIABLE_ID+"}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvengerOutputDto> getById(@PathVariable(PATH_VARIABLE_ID) Long id) {
		
		AvengerEntity avenger = null;
		try {
			avenger = avengerRepository.findById(id).orElseThrow(() -> new AvengerNotFoundException(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		AvengerOutputDto outputDto = outputConverter.convert(avenger);
		
		return ResponseEntity.ok(outputDto);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody AvengerInputDto avengerInputDto,
						UriComponentsBuilder uriBuilder) {
		AvengerEntity newAvenger = avengerRepository.save(inputConverter.convert(avengerInputDto));
		
		URI uri = uriBuilder
						.path(AvengerController.DEFAULT_URI+"/{"+PATH_VARIABLE_ID+"}")
						.buildAndExpand(newAvenger.getId())
						.toUri();
		
		return ResponseEntity
					.created(uri)
					.build();
	}

}
