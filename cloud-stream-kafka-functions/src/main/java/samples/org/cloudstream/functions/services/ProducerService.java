package samples.org.cloudstream.functions.services;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import samples.org.cloudstream.functions.domain.CustomMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service("producer")
public class ProducerService implements Supplier<Message<CustomMessage>> {

    public static final String PRODUCER_TIME_HEADER = "producer-time";
    private List<Message<CustomMessage>> messagesList = new ArrayList<>();

    @Override
    public Message<CustomMessage> get() {
        return getAndClearMessage();
    }

    public synchronized void addMessage(CustomMessage customMessage){
        Message<CustomMessage> message = MessageBuilder
                .withPayload(customMessage)
                .setHeader(PRODUCER_TIME_HEADER, Instant.now())
                .build();
        this.messagesList.add(message);
    }

    private synchronized Message<CustomMessage> getAndClearMessage(){
        Message<CustomMessage> currMessage = null;
        if(!CollectionUtils.isEmpty(messagesList)) {
            currMessage = messagesList.get(0);
            messagesList.remove(0);
        }
        return currMessage;
    }
}
