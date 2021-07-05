package beans;
import java.io.InputStream;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="Schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="session")
	@Enumerated(EnumType.STRING)
	private Session session;
	
	@OneToOne
	@JoinColumn(name="Semester_id",referencedColumnName="id")
	private Semestre semestre;
	
	@OneToOne
	@JoinColumn(name="AnneeUniversitaire_id",referencedColumnName="id")
	private AnneeUniversitaire anneeuniversitaire;
private String nomEmploi;
	
	public Schedule(int id, Session session, Semestre semestre, AnneeUniversitaire anneeuniversitaire) {
		super();
		this.id = id;
		this.session = session;
		this.semestre = semestre;
		this.anneeuniversitaire = anneeuniversitaire;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Schedule() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomEmploi() {
		return nomEmploi;
	}

	public void setNomEmploi(String nomEmploi) {
		this.nomEmploi = nomEmploi;
	}
	InputStream emploiFile;

	public InputStream getEmploiFile() {
		return emploiFile;
	}

	public void setEmploiFile(InputStream emploiFile) {
		this.emploiFile = emploiFile;
	}
	
}
