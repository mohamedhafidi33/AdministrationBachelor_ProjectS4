package beans;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Filiere")
public class Filiere {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;

@Column(name="nomFiliere")
private String nom;

@OneToMany(mappedBy="filiere")
private List<Etudiant> etudiants;

@OneToMany(mappedBy="filiere")
private List<Semestre> semestres;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}


}
