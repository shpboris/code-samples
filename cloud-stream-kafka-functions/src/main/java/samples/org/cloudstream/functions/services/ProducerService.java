package samples.org.cloudstream.functions.services;

import samples.org.cloudstream.functions.domain.Message;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service("producer")
public class ProducerService implements Supplier<Message> {

    private List<Message> messagesList = new ArrayList<>();

    @Override
    public Message get() {
        return getAndClearMessage();
    }

    public synchronized void addMessage(Message message){
        this.messagesList.add(message);
    }

    private synchronized Message getAndClearMessage(){
        Message currMessage = null;
        if(!CollectionUtils.isEmpty(messagesList)) {
            currMessage = messagesList.get(0);
            messagesList.remove(0);
        }
        return currMessage;
    }
}
