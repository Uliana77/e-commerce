package ua.com.likeshop.fb28.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.com.likeshop.fb28.entity.Orders;
import ua.com.likeshop.fb28.entity.SalesData;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Long> {
    @Query(value = "SELECT products_id as id, count(*) as sold FROM orders_products group by products_id order by sold desc;", nativeQuery = true)
    List<Object[]> selectSalesData();


}
