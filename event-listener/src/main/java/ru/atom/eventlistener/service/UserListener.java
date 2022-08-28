package ru.atom.eventlistener.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.atom.eventlistener.dto.UserEvent;

@Component
@Slf4j
public class UserListener {
    @EventListener
    public void onEvent(UserEvent event) {
        log.info("Event: {}", event.id());
    }
}
