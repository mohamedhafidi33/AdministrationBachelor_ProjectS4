package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Etudiant")
public class Etudiant {
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
	
	@Column (name="cne")
	private String cne;
	
	@Column (name="dateInscription")
	private Date dateInscription;
	
	@Column (name="dateNaissance")
	private Date dateNaissance;
	
	@Column (name="email")
	private String email;
	
	@Column (name="etablissement")
	private String etablissement;
	
	@Column (name="lieuNaissance")
	private String lieuNaissance;
	
	@Column (name="lieuBac")
	private String lieuBac;
	
	@Column (name="lycee")
	private String lycee;
	
	@Column (name="mention")
	private String mention;
	
	@Column (name="province")
	private String province;
	
	@Column (name="ville")
	private String ville;
	
	@Column (name="nationalite")
	private String nationalite;
	
	@OneToOne
	@JoinColumn(name="User_id",referencedColumnName="id")
	private User user;
	
	@OneToMany(mappedBy="etudiant")
	private List<Document> documents;
	
	@ManyToOne
	@JoinColumn(name="filiere_id",referencedColumnName="id")
	private Filiere filiere;

	public Etudiant() {
		super();
	}

	public Etudiant(int id, String nom, String prenom, Gender sexe, String cin, String cne, Date dateInscription,
			Date dateNaissance, String email, String etablissement, String lieuNaissance, String lieuBac, String lycee,
			String mention, String province, String ville, String nationalite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.cin = cin;
		this.cne = cne;
		this.dateInscription = dateInscription;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.etablissement = etablissement;
		this.lieuNaissance = lieuNaissance;
		this.lieuBac = lieuBac;
		this.lycee = lycee;
		this.mention = mention;
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

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getLieuBac() {
		return lieuBac;
	}

	public void setLieuBac(String lieuBac) {
		this.lieuBac = lieuBac;
	}

	public String getLycee() {
		return lycee;
	}

	public void setLycee(String lycee) {
		this.lycee = lycee;
	}

	public String getMention() {
		return mention;
	}

	public void setMention(String mention) {
		this.mention = mention;
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
