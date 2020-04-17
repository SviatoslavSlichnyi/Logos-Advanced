package ua.lviv.magazine.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

    ROLE_ADMIN(1L, "ROLE_ADMIN"),
    ROLE_USER(2L, "ROLE_USER");

    private Long id;
    private String name;

}
