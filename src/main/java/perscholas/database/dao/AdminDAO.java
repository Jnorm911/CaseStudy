package perscholas.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import perscholas.database.entity.User;
import perscholas.database.entity.UserRole;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminDAO extends JpaRepository<User, Integer> {

    @Query(value = "SELECT c FROM User c WHERE c.username LIKE '%' || :keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'"
            + " OR c.password LIKE '%' || :keyword || '%'")
    public List<User> search(@Param("keyword") String keyword);

    public Optional<User> findById(@Param("id") Integer id);

    public User findByEmail(@Param("email") String email);

    @Query("select u from User u where u.username = :username")
    public User findByUsername(@Param("username") String uname);

    @Query("select ur from UserRole ur where ur.user.id = :userId")
    List<UserRole> getUserRoles(@Param("userId")  Integer userId);
}
