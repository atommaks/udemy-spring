package ru.atom.eventlistener.dao.repository;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.atom.eventlistener.annotation.Transaction;
import ru.atom.eventlistener.dao.entity.User;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
@Transaction
//@Repository
@Slf4j
public class UserRepository implements CrudRepository<Integer, User>{
    private final int batchSize;
    private final String tableName;
    private final List<Object> args;

    @PostConstruct
    private void init() {
        log.info("init user repository");
    }

    @Override

    public Optional<User> findById(Integer id) {
        log.info("Find by id method...");
        return Optional.of(new User(id));
    }

    @Override
    public void delete(User entity) {
        log.info("Delete method...");
    }
}
