package ua.com.likeshop.fb28.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders extends AbstractPersistable<Long> {
    String username;
    String phone;

    @ManyToMany
     //       @JoinColumn(foreignKey =  @javax.persistence.ForeignKey())
   // @ForeignKey( name = "none" )
    //@JoinTable(//name = "order_mapping",
          //  joinColumns = @JoinColumn(name = "order_id", ),
      //      inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)))
    List<Product> products;

    public Orders() {
    }

    public Orders(String username, String phone, List<Product> products) {
        this.username = username;
        this.phone = phone;
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
