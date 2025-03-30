package ch.martin.k8s.be;

import com.adazes.k8s.demo.be.dto.SpringInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GreetingDto {

	private String message;
	private String appVersion;
	private LocalDateTime now;
	private SpringInfoDto spring;
}
