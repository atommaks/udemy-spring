package ru.atom.springstarterjava.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.atom.springstarterjava.dao.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RequiredArgsConstructor
@Getter
@Service
public class UserService {
    private final UserRepository userRepository;

    /**
     * такие методы вызываются только у бинов, у которых скоуп singleton, т.к. бины скоупа prototype не хранятся в мапе
     * ApplicationContext
     */

    //1) Этот метод xml вызывается в последнюю очередь
    @PostConstruct
    private void init() {
        System.out.println("user service init");
    }

    // Этот метод xml вызывается в последнюю очередь
    @PreDestroy
    private void destroyCustom() {
        System.out.println("user service destroyed");
    }


    public Integer getBatchSize() {
        return userRepository.getBatchSize();
    }
}
