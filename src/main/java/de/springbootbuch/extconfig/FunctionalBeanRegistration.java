package de.springbootbuch.extconfig;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

public class FunctionalBeanRegistration implements ApplicationContextInitializer<GenericApplicationContext> {

    @Override
    public void initialize(GenericApplicationContext ctx) {
        ctx.registerBean(Greeter.class, Greeter::new);
    }

}
