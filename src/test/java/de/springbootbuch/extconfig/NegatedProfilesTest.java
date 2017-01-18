package de.springbootbuch.extconfig;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("demo2")
public class NegatedProfilesTest {

    @Autowired
    private ExampleProperties exampleConfiguration;
    
    @Value("${someValue}")
    private Integer someValue;

    @Test
    public void negatedProfilesShouldWork() {
        Assert.assertThat(exampleConfiguration.getGreeting(), is(equalTo("Hello, Demo2!")));
        Assert.assertThat(someValue, is(equalTo(4711)));
    }
}
