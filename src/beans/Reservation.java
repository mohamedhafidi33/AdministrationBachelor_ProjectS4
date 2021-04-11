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

}
