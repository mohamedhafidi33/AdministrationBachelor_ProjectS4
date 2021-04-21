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
	
	//@OneToMany(mappedBy = "absence")
	//private List<Ternaire_Absence> ternaire_absences;
}