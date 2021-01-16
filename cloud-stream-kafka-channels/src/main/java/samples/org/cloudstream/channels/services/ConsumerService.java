package samples.org.cloudstream.channels.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import samples.org.cloudstream.channels.domain.Message;
import samples.org.cloudstream.channels.streams.MessageStreams;

@Component
@Slf4j
public class ConsumerService {

    @StreamListener(MessageStreams.INPUT)
    public void handleGreetings(@Payload Message message) {
        log.info("Received message: {}", message);
    }

}
