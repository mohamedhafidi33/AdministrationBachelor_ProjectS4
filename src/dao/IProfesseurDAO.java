package dao;

import java.util.List;

import beans.Professeur;
import beans.User;

public interface IProfesseurDAO {
Professeur getProf(User user);

Professeur getProfById(int id);

void ajouterProf(Professeur prof);

List<Professeur> listProfs();

void modifierProf(Professeur prof);

void supprimerProf(Professeur prof);
}
