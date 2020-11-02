package de.springbootbuch.extconfig;

import static org.junit.jupiter.api.Assertions.*;

import de.springbootbuch.extconfig.PlainConfig.PlainPojo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlainConfigTest {

	@Autowired
	PlainPojo plainPojo;

	@Configuration
	@Import(PlainConfig.class)
	static class TestConfig {
	}

	@Test
	public void plainPojoShouldBeThere() {
		assertNotNull(plainPojo);
	}
}
