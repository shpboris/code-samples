package samples.org.cloudstream.functions.services;

import samples.org.cloudstream.functions.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service("consumer")
public class ConsumerService implements Consumer<Message> {

    @Override
    public void accept(Message message) {
        log.info("Received message: {}", message);
    }
}
