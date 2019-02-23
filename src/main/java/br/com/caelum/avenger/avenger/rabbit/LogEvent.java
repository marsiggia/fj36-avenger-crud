package br.com.caelum.avenger.avenger.rabbit;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface LogEvent {
	
	String CHANNEL = "created-hero";
	
	@Output(CHANNEL)
	MessageChannel channel();

}
