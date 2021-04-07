package beans;

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
}
