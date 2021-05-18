package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

import org.hibernate.Session;
import beans.Salle;

public interface ISalleDAO  extends Serializable{
	public void saveSalle(Salle salle);
    
    public void updateSalle(Salle salle);
     
    public void deleteSalle(int id);
     
    
    
}
