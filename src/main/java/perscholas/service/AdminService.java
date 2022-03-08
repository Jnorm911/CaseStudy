package perscholas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import perscholas.database.dao.AdminDAO;
import perscholas.database.entity.User;

import java.util.List;

@Component
public class AdminService {
    private final AdminDAO repo;
    @Autowired
    public AdminService(AdminDAO repo) {
        this.repo = repo;
    }

    public void save(User user) {
        repo.save(user);
    }

    public List<User> listAll() {
        return repo.findAll();
    }

    public User get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<User> search(String keyword) {
        return repo.search(keyword);
    }
}
