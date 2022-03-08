package perscholas.database.dao;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import perscholas.database.entity.User;
import perscholas.service.AdminService;

import javax.annotation.Resource;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminDAOTest {

    @Resource
    private AdminService repo;
    @Resource
    private AdminDAO adminDAO;

    // Test Save //
    @Test
    @Order(1)
    @Rollback(false)
    public void saveUserTest(){

        User user = User.builder()
                .username("Ramesh")
                .password("Password1!")
                .email("ramesh@gmail.com")
                .build();

        repo.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    // Test Search //
    @Test
    @Order(2)
    public void testFindUserByName() {
        User user = adminDAO.findByUsername("Ramesh");
        Assertions.assertThat(user.getUsername()).isEqualTo("Ramesh");
    }

    // Test Edit //
    @Test
    @Order(3)
    @Rollback(false)
    public void testEditUser(){
        User user = adminDAO.findByUsername("Ramesh");
        user.setPassword("Password1@");

        repo.save(user);

        User updatedUser = adminDAO.findByUsername("Ramesh");

        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("Password1@");
    }

    // Test Delete //
    @Test
    @Order(4)
    @Rollback(false)
    public void testDeleteUser() {
        User user = adminDAO.findByUsername("Ramesh");

        repo.delete(user.getId());

        User deletedUser = adminDAO.findByUsername("Ramesh");

        Assertions.assertThat(deletedUser).isNull();
    }
}