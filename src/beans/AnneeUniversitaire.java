package beans;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AnneUniversitaire")
public class AnneeUniversitaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date_debut")
	private Date date_debut;
	
	@Column(name="date_fin")
	private Date date_fin;
	
	@OneToOne(mappedBy="anneeuniversitaire")
	private Schedule schedule;
	
	@ManyToMany(mappedBy="annees")
	private List<Etudiant> etudiants;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public AnneeUniversitaire() {
		super();
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public AnneeUniversitaire(int id, Date date_debut, Date date_fin, Schedule schedule, List<Etudiant> etudiants) {
		super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.schedule = schedule;
		this.etudiants = etudiants;
	}

	public AnneeUniversitaire(int id, Date date_debut, Date date_fin) {
		super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	
	
	
}
