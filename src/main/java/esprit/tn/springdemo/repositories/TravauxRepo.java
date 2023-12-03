package esprit.tn.springdemo.repositories;

import esprit.tn.springdemo.entities.Travaux;
import org.springframework.data.repository.CrudRepository;

public interface TravauxRepo extends CrudRepository<Travaux, Integer> {

}
