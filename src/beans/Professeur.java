package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Professeur")
public class Professeur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column (name="nom")
	private String nom;
	
	@Column (name="prenom")
	private String prenom;
	
	@Column (name="sexe")
	private Gender sexe ;
	
	@Column (name="cin")
	private String cin;
	
	@Column (name="email")
	private String email;
	
	@Column (name="province")
	private String province;
	
	@Column (name="ville")
	private String ville;
	
	@Column (name="nationalite")
	private String nationalite;

	public Professeur() {
		super();
	}

	public Professeur(int id, String nom, String prenom, Gender sexe, String cin, String email, String province,
			String ville, String nationalite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cin = cin;
		this.email = email;
		this.province = province;
		this.ville = ville;
		this.nationalite = nationalite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Gender getSexe() {
		return sexe;
	}

	public void setSexe(Gender sexe) {
		this.sexe = sexe;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	
}
