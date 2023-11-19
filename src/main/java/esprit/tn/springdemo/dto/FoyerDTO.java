package esprit.tn.springdemo.dto;

import esprit.tn.springdemo.entities.Bloc;
import esprit.tn.springdemo.entities.Universite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoyerDTO {
    private Long id;
    private String nom;
    private long capacite;
    private Universite universite;
    private List<Bloc> blocs;
}
