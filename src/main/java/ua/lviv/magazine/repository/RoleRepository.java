package ua.lviv.magazine.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.magazine.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
