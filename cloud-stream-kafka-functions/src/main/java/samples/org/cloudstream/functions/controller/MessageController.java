package samples.org.cloudstream.functions.controller;

import samples.org.cloudstream.functions.domain.CustomMessage;
import samples.org.cloudstream.functions.services.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private final ProducerService producerService;

    @GetMapping("/messages")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void messages(@RequestParam("msg") String msg) {

        CustomMessage message = CustomMessage.builder()
            .value(msg)
            .creationTime(Instant.now())
            .build();

        producerService.addMessage(message);
    }
}
