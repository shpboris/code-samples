package samples.org.cloudstream.functions.services;

import samples.org.cloudstream.functions.domain.Message;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service("processor")
public class ProcessorService implements Function<Message, Message> {
    @Override
    public Message apply(Message message) {
        message.setValue(message.getValue().toUpperCase());
        return message;
    }
}
