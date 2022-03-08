package perscholas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perscholas.database.dao.BillingDAO;
import perscholas.database.entity.Billing;

import java.util.List;

@Service
public class BillingService {

    private final BillingDAO repo;
    @Autowired
    public BillingService(BillingDAO repo) {
        this.repo = repo;
    }

    public Billing get(Integer id) {
        return repo.findById(id).get();
    }

    public List<Billing> findByUserId(Integer id) {
        return repo.findByUser_Id(id);
    }

    public void save(Billing details) {
        repo.save(details);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
