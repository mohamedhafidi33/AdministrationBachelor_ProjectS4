package beans;

import javax.persistence.*;

@Entity
public class ME_Absence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="absence_Id")
	private Absence absence;
	
	@ManyToOne
	@JoinColumn(name="etudiant_Id")
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(name="Matiere_Id")
	private Matiere matiere;
}
