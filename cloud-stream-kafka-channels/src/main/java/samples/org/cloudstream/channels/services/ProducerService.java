package samples.org.cloudstream.channels.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import samples.org.cloudstream.channels.domain.Message;
import samples.org.cloudstream.channels.streams.MessageStreams;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {

    private final MessageStreams messageStreams;

    public void sendMessage(Message message) {
        log.info("Sending message: {}", message);

        MessageChannel messageChannel = messageStreams.outboundMessages();
        messageChannel.send(MessageBuilder
                .withPayload(message)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
