package bg.softuni.web.superMarket.repositories;

import bg.softuni.web.superMarket.models.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    Optional<Shop> findShopByName(String name);
    Optional<Shop> findShopByNameAndAddress(String name, String address);
}
