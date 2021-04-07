package beans;
import java.util.Date;

import javax.persistence.Column;
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
}
