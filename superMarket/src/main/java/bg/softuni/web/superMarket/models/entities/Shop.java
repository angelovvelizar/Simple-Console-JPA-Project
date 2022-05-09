package bg.softuni.web.superMarket.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String address;

    @Column
    private String name;

    @ManyToOne
    private Town town;

    @OneToMany(mappedBy = "shop")
    private Set<Seller> sellers;

    @ManyToMany
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(Set<Seller> sellers) {
        this.sellers = sellers;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
