package beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Semestre")
public class Semestre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nomSemestre")
	private String nom;
	
	@OneToOne(mappedBy="semestre")
	private Schedule schedule;
	
	@ManyToOne
	@JoinColumn(name="filiere_id",referencedColumnName="id")
	private Filiere filiere;
	
	@OneToMany(mappedBy="semestre")
	private List<Module> modules;
}