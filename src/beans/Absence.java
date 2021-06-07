package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Absence")
public class Absence {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="presence")
	private Boolean presence;
	
	@Column(name="creneau")
	@Enumerated(EnumType.STRING)
	private Creneau creneau;
	
	@OneToMany(mappedBy = "absence")
	private List<ME_Absence> me_absences;
	
	private int Etudiant_Id;
	
	private int Matiere_Id;

	
	public int getEtudiant_Id() {
		return Etudiant_Id;
	}

	public void setEtudiant_Id(int etudiant_Id) {
		Etudiant_Id = etudiant_Id;
	}

	public int getMatiere_Id() {
		return Matiere_Id;
	}

	public void setMatiere_Id(int matiere_Id) {
		Matiere_Id = matiere_Id;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	
}