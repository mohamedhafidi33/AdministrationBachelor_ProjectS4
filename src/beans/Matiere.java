package beans;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="Matiere")
public class Matiere {
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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Professeur> getProfs() {
		return profs;
	}

	public void setProfs(List<Professeur> profs) {
		this.profs = profs;
	}

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
	
	@OneToMany(mappedBy = "matiere")
	private List<ME_Absence> me_absences;
}
