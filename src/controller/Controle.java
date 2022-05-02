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
	 * @return réponse sous forme de ArrayList
	 */
	public ArrayList<Responsable> getResponsables() {
		return AccesDonnees.getResponsables();
	}
	
	/**
	 * transfère au DAL la demande getPersonnel() de la vue
	 * @return réponse sous forme de ArrayList
	 */
	public ArrayList<Personnel> getPersonnel() {
		return AccesDonnees.getPersonnel();
	}
}
