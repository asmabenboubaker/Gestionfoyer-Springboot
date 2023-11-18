package esprit.tn.springdemo.services;

import esprit.tn.springdemo.entities.Chambre;
import esprit.tn.springdemo.entities.Etudiant;
import esprit.tn.springdemo.entities.Reservation;
import esprit.tn.springdemo.repositories.ChambreRepo;
import esprit.tn.springdemo.repositories.EtudiantRepo;
import esprit.tn.springdemo.repositories.ReservationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    private final ReservationRepo reservationRepo;
    private final ChambreRepo chambreRepo;
    private final EtudiantRepo etudiantRepo;
    

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepo.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepo.findById(idReservation);
    }

    @Override
    public Reservation ajouterReservation(Reservation reservation, long idChambre, long cinEtudiant) {
        Chambre chambre = chambreRepo.getById(idChambre);
        Etudiant etudiant = etudiantRepo.getByCin(cinEtudiant);
        return null;
    }

    private String generateId(long idChambre, long cinEtudiant) {
        return null;
    }
}
