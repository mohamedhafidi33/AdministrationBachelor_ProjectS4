package beans;

import javax.persistence.*;

@Entity
@Table(name="Filiere")
public class Filiere {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;

@Column(name="nomFiliere")
private String nom;

}
