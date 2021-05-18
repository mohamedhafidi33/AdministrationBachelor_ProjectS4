package beans;



import java.io.InputStream;

import javax.persistence.*;



@Entity
@Table(name="Document")
public class Document {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Doctype type;
	
	@Column (name="file")
	private InputStream file;
	
	@ManyToOne
	@JoinColumn(name="Etudiant_id",referencedColumnName="id")
	private Etudiant etudiant;
	
	public Document() {
		super();
	}
	
	public Document(int id, Doctype type, Etudiant etudiant) {
		super();
		this.id = id;
		this.type = type;
		this.etudiant = etudiant;
	}

	public Document(int id, Doctype type, InputStream file, Etudiant etudiant) {
		super();
		this.id = id;
		this.type = type;
		this.file = file;
		this.etudiant = etudiant;
	}

	public Document(Doctype type) {
		super();
		this.type = type;
	}
    
	public Document(InputStream file) {
		super();
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctype getType() {
		return type;
	}

	public void setType(Doctype type) {
		this.type = type;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}

	
	
	
}