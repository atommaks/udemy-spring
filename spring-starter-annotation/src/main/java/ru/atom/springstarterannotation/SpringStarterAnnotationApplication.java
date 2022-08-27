package ru.atom.springstarterannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.atom.springstarterannotation.dao.repository.CrudRepository;
import ru.atom.springstarterannotation.dao.repository.UserRepository;
import ru.atom.springstarterannotation.service.UserService;

public class SpringStarterAnnotationApplication {
    public static void main(String[] args) {

        // ClassPathXmlApplicationContext реализует Autoclosable интерфейс,
        // поэтому, чтобы вызывался дестрой метод нужно оборачивать контекcт в try-with-resources блок
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var userRepository = (UserRepository)context.getBean(UserRepository.class);
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
