package samples.org.cloudstream.channels.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageStreams {

    String INPUT = "consumer-in";
    String OUTPUT = "producer-out";

    @Input(INPUT)
    SubscribableChannel inboundMessages();

    @Output(OUTPUT)
    MessageChannel outboundMessages();
}
