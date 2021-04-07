package beans;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Matiere")
public class Matiere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nomMatiere")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="module_id",referencedColumnName="id")
	private Module module;
}
