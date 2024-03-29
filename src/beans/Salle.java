package beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import dao.ISalleImplDAO;

@Entity
@Table(name = "SALLES")
public class Salle implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "numero")
	private int numero;

	@Column(name = "occupation")
	private boolean occupation;

	@Column(name = "description", length = 120)
	private String description;

	@Column(name = "typesalle")
	@Enumerated(EnumType.STRING)
	private Typesalle typesalle;

	@OneToMany(mappedBy = "salle")
	private List<Reservation> reservations;

	
	public Salle(int numero, boolean occupation, String description, Typesalle typesalle) {
		super();
		this.numero = numero;
		this.occupation = occupation;
		this.description = description;
		this.typesalle = typesalle;
	}

	public Salle() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isOccupation() {
		return occupation;
	}

	public void setOccupation(boolean occupation) {
		this.occupation = occupation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Typesalle getTypesalle() {
		return typesalle;
	}

	public void setTypesalle(Typesalle typesalle) {
		this.typesalle = typesalle;
	}
	public Boolean dispoParCreneau1(String C,int i) {
		ISalleImplDAO isalle=new ISalleImplDAO();
	return 	isalle.dispoParCreneau1(C,i);
		
	}
}