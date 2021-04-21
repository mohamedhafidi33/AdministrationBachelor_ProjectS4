package beans;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="Matiere")
public class Matiere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nomMatiere")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="module_id",referencedColumnName="id")
	private Module module;
	
	@ManyToMany(mappedBy="matieres")
	private List<Professeur> profs;
	
	//@OneToMany(mappedBy = "matiere")
	//private List<Ternaire_Absence> Ternaire_Absence;
}