package dao;
import beans.*;

import java.io.InputStream;
import java.util.List;

public interface IEmploiDAO {
	public void addIdsSchedule( String nomEmploi,Session session, int id_annee, int id_semestre, InputStream emploiFile);
    public int selectByNom(String nomEmploi);
    public int selectById(int id);
    public void deleteById( int id);
    public void updateEmploi(Schedule emploi,int annee_id, int semestre_id);
    public Schedule updateEmploi(Schedule emploi);
    public List<Schedule> listEmplois();
}
