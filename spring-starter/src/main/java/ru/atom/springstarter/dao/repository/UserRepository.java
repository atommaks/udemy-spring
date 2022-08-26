package ru.atom.springstarter.dao.repository;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public class UserRepository {
    private final Integer batchSize;
    private final String tableName;
    private final List<Object> args;
    private final Map<String, Object> properties;
}
