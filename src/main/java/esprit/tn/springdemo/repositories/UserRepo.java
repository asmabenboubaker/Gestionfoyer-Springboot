package esprit.tn.springdemo.repositories;

import esprit.tn.springdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    Object findByUsernameAndPassword(String username, String password);
}
