package samples.org.cloudstream.channels.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import samples.org.cloudstream.channels.streams.MessageStreams;

@EnableBinding(MessageStreams.class)
public class StreamsConfig {
}
