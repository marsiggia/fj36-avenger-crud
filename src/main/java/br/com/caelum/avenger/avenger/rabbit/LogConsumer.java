package br.com.caelum.avenger.avenger.rabbit;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class LogConsumer {

	@StreamListener(LogEvent.CHANNEL)
	public void all(Message<String> log) {
		System.out.println(log);
	}
	
}
