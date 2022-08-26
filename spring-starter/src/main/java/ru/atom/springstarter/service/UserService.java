package ru.atom.springstarter.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import ru.atom.springstarter.dao.repository.UserRepository;

@RequiredArgsConstructor
@Getter
public class UserService implements InitializingBean, DisposableBean {
    private final UserRepository userRepository;

    /**
     * такие методы вызываются только у бинов, у которых скоуп singleton, т.к. бины скоупа prototype не хранятся в мапе
     * ApplicationContext
     */

    //1) Этот метод xml вызывается в последнюю очередь
    private void init() {
        System.out.println("user service init");
    }

    //2) Сначала вызовется этот метод, если нет @PostConstruct
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Properties set");
    }

    // Этот метод xml вызывается в последнюю очередь
    private void destroyCustom() {
        System.out.println("user service destroyed");
    }

    // Сначала вызывается этот медо, если нет @PreDestroy
    @Override
    public void destroy() throws Exception {
        System.out.println("user service disposed");
    }
}
