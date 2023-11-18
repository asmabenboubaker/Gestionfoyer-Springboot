package esprit.tn.springdemo.repositories;

import esprit.tn.springdemo.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Long> {

}
