package ru.atom.eventlistener.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.atom.eventlistener.dao.repository.UserRepository;
import ru.atom.eventlistener.dto.UserEvent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RequiredArgsConstructor
@Getter
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    /**
     * такие методы вызываются только у бинов, у которых скоуп singleton, т.к. бины скоупа prototype не хранятся в мапе
     * ApplicationContext
     */

    //1) Этот метод xml вызывается в последнюю очередь
    @PostConstruct
    private void init() {
        log.info("user service init");
    }

    // Этот метод xml вызывается в последнюю очередь
    @PreDestroy
    private void destroyCustom() {
        log.info("user service destroyed");
    }

    public Integer getBatchSize() {
        return userRepository.getBatchSize();
    }

    public void publishEvent(Integer id) {
        publisher.publishEvent(new UserEvent(id));
    }
}
