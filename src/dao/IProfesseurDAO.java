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

void addEnseignement(int idProf, int idMatiere);

int getIdProf(String nom, String prenom);

void deleteEnseignement(int profId);

int countProfs();

List<Professeur> listProfsBySemestre(int semestreId);
}
