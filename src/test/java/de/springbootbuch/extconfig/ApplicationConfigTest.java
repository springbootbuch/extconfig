package de.springbootbuch.extconfig;

import de.springbootbuch.extconfig.ApplicationConfig.BarService;
import de.springbootbuch.extconfig.ApplicationConfig.FactoredService;
import de.springbootbuch.extconfig.ApplicationConfig.FooService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = "foo.value")
public class ApplicationConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void checkUniqueServices() {
        Assert.assertThat(applicationContext.getBeansOfType(FooService.class).size(), is(equalTo(1)));
        Assert.assertThat(applicationContext.containsBean("myFooService"), is(true));
        Assert.assertThat(applicationContext.getBeansOfType(BarService.class).size(), is(equalTo(1)));
        Assert.assertThat(applicationContext.getBeansOfType(FactoredService.class).size(), is(equalTo(1)));      
        
        final BarService barService = applicationContext.getBean(BarService.class);
        Assert.assertThat(barService.fooService, is(equalTo(applicationContext.getBean(FooService.class))));       
    }
}
