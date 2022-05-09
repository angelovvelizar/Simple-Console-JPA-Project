package bg.softuni.web.superMarket.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity{

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    private Seller manager;

    @OneToMany(mappedBy = "manager")
    private Set<Seller> employees;

    public Seller getManager() {
        return manager;
    }

    public void setManager(Seller manager) {
        this.manager = manager;
    }

    public Set<Seller> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Seller> employees) {
        this.employees = employees;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
