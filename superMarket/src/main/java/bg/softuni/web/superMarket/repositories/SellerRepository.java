package bg.softuni.web.superMarket.repositories;

import bg.softuni.web.superMarket.models.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    Optional<Seller> findSellerByFirstNameAndLastName(String firstName, String lastName);
}
