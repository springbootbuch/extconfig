package de.springbootbuch.extconfig;

import de.springbootbuch.extconfig.ApplicationConfig.BarService;
import de.springbootbuch.extconfig.ApplicationConfig.FactoredService;
import de.springbootbuch.extconfig.ApplicationConfig.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = "foo.value")
public class ApplicationConfigTest {

	@Autowired
	private ApplicationContext ctx;

	@Test
	public void checkUniqueServices() {
		assertThat(
			ctx.getBeansOfType(FooService.class).size(), 
			is(equalTo(1)));
		assertThat(
			ctx.containsBean("myFooService"), 
			is(true));
		assertThat(
			ctx.getBeansOfType(BarService.class).size(),
			is(equalTo(1)));
		assertThat(
			ctx.getBeansOfType(FactoredService.class).size(), 
			is(equalTo(1)));

		final BarService barService 
			= ctx.getBean(BarService.class);
		assertThat(
			barService.fooService, 
			is(equalTo(ctx.getBean(FooService.class))));
	}
}
