package ru.atom.eventlistener.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.atom.eventlistener.config.condition.JpaCondition;

import javax.annotation.PostConstruct;

@Configuration
@Conditional(JpaCondition.class)
@Slf4j
public class JpaConfiguration {

    @PostConstruct
    public void init() {
        log.info("Jpa config is enabled");
    }
}
