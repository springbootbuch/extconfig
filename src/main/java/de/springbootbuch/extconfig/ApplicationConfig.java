package de.springbootbuch.extconfig;

import de.springbootbuch.extconfig.ApplicationConfig.BarProperties;
import de.springbootbuch.extconfig.ApplicationConfig.FooProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({BarProperties.class, FooProperties.class})
public class ApplicationConfig {

    @ConfigurationProperties("bar")
    public static class BarProperties {

        private String otherValue;

        public String getOtherValue() {
            return otherValue;
        }

        public void setOtherValue(String otherValue) {
            this.otherValue = otherValue;
        }
    }

    @ConfigurationProperties("foo")
    public static class FooProperties {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
