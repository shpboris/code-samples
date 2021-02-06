package samples.org.cloudstream.functions.services;

import org.springframework.messaging.Message;
import samples.org.cloudstream.functions.domain.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service("consumer")
public class ConsumerService implements Consumer<Message<CustomMessage>> {

    @Override
    public void accept(Message<CustomMessage> message) {
        log.info("Received message: {}", message);
    }
}
