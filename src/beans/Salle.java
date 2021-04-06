package beans;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="SALLES")
public class Salle implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="numero")
private int numero;
@Column(name="occupation")
private boolean occupation;
@Column(name="description")
private String description;
public Salle(int id, int numero, boolean occupation, String description) {
	this.id = id;
	this.numero = numero;
	this.occupation = occupation;
	this.description = description;
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

}