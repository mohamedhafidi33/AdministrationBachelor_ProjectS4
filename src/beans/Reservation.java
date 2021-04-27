package beans;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="Professeur_Id")
	private Professeur professeur;
	
	@ManyToOne
	@JoinColumn(name="Salle_Id")
	private Salle salle;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Creneau crenau;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Date date;

	
	public Reservation() {
		super();
	}

	public Reservation(Professeur professeur, Salle salle, Creneau crenau, Date date) {
		super();
		this.professeur = professeur;
		this.salle = salle;
		this.crenau = crenau;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Creneau getCrenau() {
		return crenau;
	}

	public void setCrenau(Creneau crenau) {
		this.crenau = crenau;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
