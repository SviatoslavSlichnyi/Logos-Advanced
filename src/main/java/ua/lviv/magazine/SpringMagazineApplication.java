package ua.lviv.magazine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.lviv.magazine.entity.Bucket;
import ua.lviv.magazine.entity.Product;
import ua.lviv.magazine.entity.Role;
import ua.lviv.magazine.entity.User;
import ua.lviv.magazine.enumeration.UserRole;
import ua.lviv.magazine.repository.RoleRepository;
import ua.lviv.magazine.service.BucketService;
import ua.lviv.magazine.service.ProductService;
import ua.lviv.magazine.service.UserService;

import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class SpringMagazineApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringMagazineApplication.class, args);

        Role roleAdmin = new Role(UserRole.ROLE_ADMIN);
        Role roleUser = new Role(UserRole.ROLE_USER);

        RoleRepository roleRepository = context.getBean(RoleRepository.class);
        try {
            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
        } catch (RuntimeException ignored) { }

        User admin = new User();
        admin.setId(1L);
        admin.setEmail("admin@mail.com");
        admin.setPassword("adminAccess");
        admin.addRole(new Role(UserRole.ROLE_ADMIN));

    }
}
