package samples.org.cloudstream.functions.services;

import org.springframework.messaging.Message;
import samples.org.cloudstream.functions.domain.CustomMessage;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("processor")
public class ProcessorService implements Function<Message<CustomMessage>, Message<CustomMessage>> {
    @Override
    public Message<CustomMessage> apply(Message<CustomMessage> message) {
        message.getPayload().setValue(message.getPayload().getValue().toUpperCase());
        return message;
    }
}
