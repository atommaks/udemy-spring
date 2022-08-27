package ru.atom.springstarterannotation.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.atom.springstarterannotation.annotation.InjectBean;
import ru.atom.springstarterannotation.dao.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RequiredArgsConstructor
@Getter
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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
