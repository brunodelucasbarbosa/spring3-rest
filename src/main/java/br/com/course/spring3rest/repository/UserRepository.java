package br.com.course.spring3rest.repository;

import br.com.course.spring3rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User WHERE u.user_name = :user_name")
    User findByUsername(@Param("user_name") String username);
}
