package bg.softuni.web.superMarket.repositories;

import bg.softuni.web.superMarket.models.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Optional<Town> findTownByName(String name);
}
