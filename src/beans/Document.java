package beans;

import javax.persistence.*;

@Entity
@Table(name="Document")
public class Document {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Doctype type;
	
	@ManyToOne
	@JoinColumn(name="Etudiant_id",referencedColumnName="id")
	private Etudiant etudiant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctype getType() {
		return type;
	}

	public void setType(Doctype type) {
		this.type = type;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	
}
