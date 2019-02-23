package br.com.caelum.avenger.avenger.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rabbits")
@EnableBinding({LogEvent.class})
public class RabbitController {

	@Autowired
	private LogEvent logEvent;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		MessageChannel channel = logEvent.channel();
		
		channel.send(MessageBuilder.withPayload("Helloooooooo").build());
		
		return ResponseEntity.ok().build();
	}
	
}
