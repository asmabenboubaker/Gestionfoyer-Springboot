package esprit.tn.springdemo.repositories;

import esprit.tn.springdemo.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
    Etudiant getByCin(long cin);
}
