package samples.org.cloudstream.functions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class CustomMessage {
    private String value;
    private Instant creationTime;
}
