package ru.atom.eventlistener.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.atom.eventlistener.dao.repository.UserRepository;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {
    private final ApplicationProperties properties;

    @Bean
    public UserRepository userRepository() {
        return new UserRepository(
                properties.getBatchSize(),
                properties.getTableName(),
                properties.getArgs());
    }
}
