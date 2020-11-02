package de.springbootbuch.extconfig;

import static org.assertj.core.api.Assertions.*;

import de.springbootbuch.extconfig.ApplicationConfig.BarService;
import de.springbootbuch.extconfig.ApplicationConfig.FactoredService;
import de.springbootbuch.extconfig.ApplicationConfig.FooService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(properties = "foo.value")
public class ApplicationConfigTest {

	@Autowired
	private ApplicationContext ctx;

	@Test
	public void checkUniqueServices() {
		assertThat(
			ctx.getBeansOfType(FooService.class))
			.hasSize(1);
		assertThat(
			ctx.containsBean("myFooService"))
			.isTrue();
		assertThat(
			ctx.getBeansOfType(BarService.class))
			.hasSize(1);
		assertThat(
			ctx.getBeansOfType(FactoredService.class))
			.hasSize(1);

		final BarService barService 
			= ctx.getBean(BarService.class);
		assertThat(
			barService.fooService)
			.isEqualTo(ctx.getBean(FooService.class));
	}
}
