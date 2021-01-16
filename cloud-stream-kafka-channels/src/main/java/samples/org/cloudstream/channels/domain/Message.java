package samples.org.cloudstream.channels.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class Message {
    private String value;
    private Instant creationTime;
}
