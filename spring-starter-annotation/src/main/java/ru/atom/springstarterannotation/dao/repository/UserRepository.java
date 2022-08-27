package ru.atom.springstarterannotation.dao.repository;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import ru.atom.springstarterannotation.annotation.Transaction;
import ru.atom.springstarterannotation.dao.entity.User;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
@Transaction
//@Repository
public class UserRepository implements CrudRepository<Integer, User>{
    private final Integer batchSize;
    private final String tableName;
    private final List<Object> args;
    private final Map<String, Object> properties;

    @PostConstruct
    private void init() {
        System.out.println("init user repository");
    }

    @Override
    public Optional<User> findById(Integer id) {
        System.out.println("Find by id method...");
        return Optional.of(new User(id));
    }

    @Override
    public void delete(User entity) {
        System.out.println("Delete method...");
    }
}
