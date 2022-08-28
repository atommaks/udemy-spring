package ru.atom.eventlistener.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "ru.atom.eventlistener")
@Getter
@Setter
public class ApplicationProperties {
    private Integer batchSize;
    private String tableName;
    private List<Object> args = List.of();
}