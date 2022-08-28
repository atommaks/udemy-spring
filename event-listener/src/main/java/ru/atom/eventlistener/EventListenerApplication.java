package ru.atom.eventlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventListenerApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(EventListenerApplication.class, args);
        System.out.println(context.getBeanDefinitionCount());
    }
}