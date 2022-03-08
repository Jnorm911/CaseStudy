package perscholas.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import perscholas.database.entity.Product;

import java.util.List;

public interface ProductDAO extends JpaRepository <Product, Integer> {
    @Query("select p from Product p where p.card.user.id = ?1")
    List<Product> findByCard_User_Id(Integer id);

}
