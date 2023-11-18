package esprit.tn.springdemo.repositories;

import esprit.tn.springdemo.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository

public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    Reservation findById(String idReservation);

    List<Reservation> findReservationsByAnneeUniversitaireBetween(Date anneeUniversitaire1, Date anneeUniversitaire2);

    long countReservationsByAnneeUniversitaireBetween(Date anneeUniversitaire1, Date anneeUniversitaire2);
}
