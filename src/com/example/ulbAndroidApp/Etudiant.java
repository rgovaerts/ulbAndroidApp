package com.example.ulbAndroidApp;

import java.util.List;

public class Etudiant {
	
	private String Nom;
	private String Prenom;
	private String UserName;
	private String Password;
	private String Faculte;
	private String Cycle;
	private int annee;
	private int matricule;
	private List<Cours> ListCours;
	
	public Etudiant(){
		
		
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public List<Cours> getListCours() {
		return ListCours;
	}

	public void setListCours(List<Cours> listCours) {
		ListCours = listCours;
	}

	public String getFaculte() {
		return Faculte;
	}

	public void setFaculte(String faculte) {
		Faculte = faculte;
	}

	public String getCycle() {
		return Cycle;
	}

	public void setCycle(String cycle) {
		Cycle = cycle;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	
	
	

}
