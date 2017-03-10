package de.springbootbuch.extconfig;

import de.springbootbuch.extconfig.PlainConfig.PlainPojo;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
