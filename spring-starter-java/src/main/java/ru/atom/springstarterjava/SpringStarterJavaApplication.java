package ru.atom.springstarterjava;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.atom.springstarterjava.config.AppConfiguration;
import ru.atom.springstarterjava.dao.repository.UserRepository;
import ru.atom.springstarterjava.service.UserService;

public class SpringStarterJavaApplication {
    public static void main(String[] args) {

        // ClassPathXmlApplicationContext реализует Autoclosable интерфейс,
        // поэтому, чтобы вызывался дестрой метод нужно оборачивать контекcт в try-with-resources блок
        try (var context = new AnnotationConfigApplicationContext(AppConfiguration.class)) {
            var userRepository = context.getBean(UserRepository.class);
            System.out.println(userRepository);
            System.out.println(userRepository.getArgs().get(0));

            var userService = context.getBean(UserService.class);
            System.out.println(userService.getUserRepository());

            System.out.println("----------------------- Eeeeee бин заинджекчен через кастомную БПП аннотацию");
            System.out.println(userService.getBatchSize());
            System.out.println(userRepository.findById(100));
        }
    }
}
