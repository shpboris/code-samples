package samples.org.cloudstream.channels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
public class CloudStreamChannelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamChannelsApplication.class, args);
	}

}
