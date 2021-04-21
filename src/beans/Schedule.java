package beans;
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
}