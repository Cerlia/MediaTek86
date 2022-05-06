package controller;

import view.Login;
import view.Gestion;
import connexion.ConnexionBDD;
import dal.AccesDonnees;
import model.Absence;
import model.Motif;
import model.Personnel;
import model.Responsable;
import model.Service;

import java.util.ArrayList;

/**
 * classe gérant les interactions entre la vue et le modèle
 * @author Claire
 *
 */
public class Controle {
	/**
	 * instance de fenêtre Login
	 */
	private Login frmLogin;
	/**
	 * instance de fenêtre Gestion
	 */
	private Gestion frmGestion;

	/**
	 * constructeur permettant d'ouvrir la fenêtre de login
	 */
	public Controle() {
		// lignes temporaires pour test
		this.frmGestion = new Gestion(this) ;
		this.frmGestion.setVisible(true);
		
		/** 
		* this.frmLogin = new Login(this) ;
		* this.frmLogin.setVisible(true);
		**/
	}
	
	/**
	 * ouverture de la fenêtre de gestion demandée par Login
	 */
	public void evtLanceGestion() {
		this.frmGestion = new Gestion(this) ;
		this.frmGestion.setVisible(true);
		this.frmLogin.setVisible(false);
	}
		
	/**
	 * transfère au DAL la demande getResponsables() de la vue
	 * @return liste des responsables sous forme de ArrayList
	 */
	public ArrayList<Responsable> getResponsables() {
		return AccesDonnees.getResponsables();
	}
	
	/**
	 * transfère au DAL la demande getPersonnel() de la vue
	 * @return liste du personnel sous forme de ArrayList
	 */
	public ArrayList<Personnel> getPersonnel() {
		return AccesDonnees.getPersonnel();
	}
	
	/**
	 * transfère au DAL la demande getServices() de la vue
	 * @return liste des services sous forme de ArrayList
	 */
	public ArrayList<Service> getServices() {
		return AccesDonnees.getServices();
	}
	
	/**
	 * transfère au DAL la demande getAbsences() de la vue
	 * @param idpersonnel identifiant de la personne dont on veut les absences
	 * @return liste des absences d'une personne sous forme de ArrayList
	 */
	public ArrayList<Absence> getAbsences(int idpersonnel) {
		return AccesDonnees.getAbsences(idpersonnel);
	}	
	
	/**
	 * transfère au DAL la demande getMotifs() de la vue
	 * @return liste des motifs sous forme de ArrayList
	 */
	public ArrayList<Motif> getMotifs() {
		return AccesDonnees.getMotifs();
	}
	
	/**
	 * transfère au DAL la demande majPersonnel() de la vue
	 * @param personnel données du personnel à mettre à jour
	 */
	public void majPersonnel(Personnel personnel) {
		AccesDonnees.majPersonnel(personnel);
	}
	
	/**
	 * transfère au DAL la demande creePersonnel() de la vue
	 * @param personnel données du personnel à ajouter
	 */
	public void creePersonnel(Personnel personnel) {
		AccesDonnees.creePersonnel(personnel);
	}
	
	/**
	 * transfère au DAL la demande supprPersonnel() de la vue
	 * @param personnel données du personnel à supprimer
	 */
	public void supprPersonnel(Personnel personnel) {
		AccesDonnees.supprPersonnel(personnel);
	}
}
