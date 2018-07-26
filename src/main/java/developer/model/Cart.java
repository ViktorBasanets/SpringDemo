package developer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PRODUCT_TO_CART",
            joinColumns = {
                @JoinColumn(name = "FK_CART_ID", nullable = false) },
            inverseJoinColumns = {
                @JoinColumn(name = "FK_PRODUCT_ID", nullable = false) })
    private List<Product> products = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
