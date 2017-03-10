package de.springbootbuch.extconfig;

import org.springframework.context.annotation.Bean;

public class PlainConfig {

	public static class PlainPojo {}

	@Bean
	public PlainPojo plainPojo() {
		return new PlainPojo();
	}
}
