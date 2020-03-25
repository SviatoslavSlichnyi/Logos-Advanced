package ua.lviv.magazine.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.magazine.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
//    @Query("select u from User u where u.email=?1")
    Optional<User> findByEmail(String email);
}
