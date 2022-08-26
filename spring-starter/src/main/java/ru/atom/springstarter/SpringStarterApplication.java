package ru.atom.springstarter;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.atom.springstarter.dao.repository.UserRepository;
import ru.atom.springstarter.service.UserService;

public class SpringStarterApplication {
    public static void main(String[] args) {

        // ClassPathXmlApplicationContext реализует Autoclosable интерфейс,
        // поэтому, чтобы вызывался дестрйо метод нужно оборачивать контект в try-with-resources блок
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var userRepository = context.getBean("pool1", UserRepository.class);
            System.out.println(userRepository);
            System.out.println(userRepository.getArgs().get(0));

            var userService = context.getBean(UserService.class);
            System.out.println(userService.getUserRepository());
        }
    }
}
