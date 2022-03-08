package perscholas.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import perscholas.database.entity.Billing;


import java.util.List;


public interface BillingDAO extends JpaRepository<Billing, Integer> {
    @Query("select b from Billing b where b.user.id = ?1")
    List<Billing> findByUser_Id(Integer id);
}
