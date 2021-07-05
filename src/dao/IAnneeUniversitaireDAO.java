package dao;
import java.sql.Date;
import java.util.List;

import beans.AnneeUniversitaire;
public interface IAnneeUniversitaireDAO {
	public int selectByDateDebut(Date dateDebut, Date dateFin);
	public List<AnneeUniversitaire> listAnnees();

}
