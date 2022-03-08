package perscholas.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscholas.database.entity.User;
import perscholas.database.entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Integer> {

    User findByEmail(@Param("email") String email);

    User findByUsername(@Param("username") String username);

    @Query("select ur from UserRole ur where ur.user.id = :userId")
    List<UserRole> getUserRoles(@Param("userId")  Integer userId);

    @Override
    Optional<User> findById(Integer integer);
}