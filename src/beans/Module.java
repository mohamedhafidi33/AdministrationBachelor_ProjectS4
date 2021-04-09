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
import javax.persistence.Table;

@Entity
@Table(name="Module")
public class Module {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nomModule")
	private String nom;
	
	@OneToMany(mappedBy="module")
	private List<Matiere> matieres;
	
	@ManyToOne
	@JoinColumn(name="semestre_id",referencedColumnName="id")
	private Semestre semestre;
}