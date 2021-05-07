package dao;

import beans.Professeur;
import beans.User;

public interface IProfesseurDAO {
Professeur getProf(User user);

Professeur getProfById(int id);

void ajouterProf(Professeur prof);
}
