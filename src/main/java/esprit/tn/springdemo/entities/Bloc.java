package esprit.tn.springdemo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String capacite;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Foyer foyer;

    //@JsonIgnore
    @OneToMany(mappedBy = "bloc")
    //
    //@OneToMany(mappedBy = "bloc", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // FetchType.Lazy : Load only Bloc data
    // FetchType.Eager : Load Bloc data and Chambre data
    // By default, the fetch type for @ManyToOne and @OneToOne relationships is EAGER
    // CascadeType.ALL : Apply all operations on Chambre to Bloc
    // CascadeType.PERSIST : Apply only persist operation on Chambre to Bloc
    // CascadeType.MERGE : Apply only merge operation on Chambre to Bloc
    // CascadeType.REMOVE : Apply only remove operation on Chambre to Bloc
    // CascadeType.REFRESH : Apply only refresh operation on Chambre to Bloc
    private List<Chambre> chambres;

    @Override
    public String toString() {
        return "Bloc{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", capacite='" + capacite + '\'' +
                ", foyer=" + foyer +
                ", chambres=" + chambres +
                '}';
    }

    public void setIdBloc(long idBloc) {
        this.id = idBloc;
    }
}