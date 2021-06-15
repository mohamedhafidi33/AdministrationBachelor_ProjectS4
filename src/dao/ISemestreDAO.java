package dao;

public interface ISemestreDAO {
	void saveSemestre(String nomSemestre, int filiere_id );
	public int searchByNom (String nomSemestre);
	public String findName(int id);

}
