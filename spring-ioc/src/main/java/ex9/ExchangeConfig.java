package ex9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {

	@Bean("ex")
	public ExchangeService getService() {
		return new ExchangeService();
	}
}
