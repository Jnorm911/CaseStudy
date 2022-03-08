package perscholas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDAO repo;
    @Autowired
    public UserService(UserDAO repo) {
        this.repo = repo;
    }

    public void save(User user) {
        repo.save(user);
    }

    public Optional<User> get(Integer id) {
        return repo.findById(id);
    }

    public List<User> listAll() {
        return repo.findAll();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public User getEmail(String email) { return repo.findByEmail(email); }

    public User getUsername(String username) { return repo.findByUsername(username); }

}
