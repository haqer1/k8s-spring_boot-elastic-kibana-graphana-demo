package ch.martin.k8s.be;

import com.adazes.k8s.demo.be.dto.SpringInfoDto;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.info.BuildProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.time.LocalDateTime;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

@RestController
@RefreshScope
@Slf4j
public class GreetingController {
	private static final String MESSAGE_PATTERN = "{0} to {1} from the K8S demo backend!";
	private final String appName;
	private final String message;
	private int messageId = 1000;
	private final String env;
	private final BuildProperties buildProperties;

	public GreetingController(@Autowired @NonNull BuildProperties buildProperties,
		  	@Value("${spring.application.name}") @NonNull String appName,
			@Value("${k8s-demo.be.message}") @NonNull String message,
			@Value("${spring.profiles.active}") String env) {
		this.buildProperties = buildProperties;
		this.appName = appName;
		this.message = message;
		this.env = env;
	}

	@GetMapping("/")
	public GreetingDto getGreeting(@RequestParam("name") String name) {
		String returnedMessage = MessageFormat.format(MESSAGE_PATTERN, message, name);
		log.error("Just another ugly error in {}. But the stack trace will save your day. {}"
				, appName, keyValue("messageId", messageId++), new Exception("An Exception"));
		return new GreetingDto(returnedMessage, buildProperties.getVersion(), LocalDateTime.now()
			, new SpringInfoDto(SpringVersion.getVersion(), env, SpringBootVersion.getVersion()));
	}
}
