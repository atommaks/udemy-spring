package ru.atom.springstarterjava.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import ru.atom.springstarterjava.dao.repository.UserRepository;

import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "ru.atom.springstarterjava")
public class AppConfiguration {

    @Bean
    @Profile("test")
    public UserRepository testUserRepository(
            @Value("${ru.atom.springstarterjava.test.batch-size}") int size,
            @Value("ru.atom.springstarterjava.test.table-name") String tableName,
            @Value("#{'${ru.atom.springstarterjava.test.args}'.split(',')}") List<Object> args) {
        return new UserRepository(size, tableName, args);
    }

    @Bean
    @Profile("prod")
    public UserRepository userRepository(
            @Value("${ru.atom.springstarterjava.batch-size}") int size,
            @Value("ru.atom.springstarterjava.table-name") String tableName,
            @Value("#{'${ru.atom.springstarterjava.args}'.split(',')}") List<Object> args) {
        return new UserRepository(size, tableName, args);
    }
}
