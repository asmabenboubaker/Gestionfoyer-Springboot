package esprit.tn.springdemo.services;

import esprit.tn.springdemo.entities.Chambre;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IChambreService {

    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c); // ajouter l’équipe avec son détail

    Chambre updateChambre(Chambre c);

    Chambre retrieveChambre(long idChambre);

    List<Chambre> getChambreByReservationAnneeUniversitaire(LocalDate dateDebut, LocalDate dateFin);

    List<Chambre> getCChambresByNomBloc(String nom);

    Chambre afftecterChambreABloc(long idChambre, String nomBloc);
}
