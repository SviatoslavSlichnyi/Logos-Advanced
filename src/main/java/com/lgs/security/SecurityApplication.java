package com.lgs.security;

import com.lgs.security.entity.Role;
import com.lgs.security.entity.User;
import com.lgs.security.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SecurityApplication.class, args);

		User admin = new User();
		admin.setId(1L);
		admin.setUsername("admin@mail.com");
		admin.setPassword("adminAccess");
		admin.addRole(new Role(1L, "ROLE_ADMIN"));

		try {
			UserService userService = context.getBean(UserService.class);
			userService.save(admin);
		} catch (RuntimeException ignored) { }
	}

}
