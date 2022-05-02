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
 * classe g�rant les interactions entre la vue et le mod�le
 * @author Claire
 *
 */
public class Controle {
	/**
	 * instance de fen�tre Login
	 */
	private Login frmLogin;
	/**
	 * instance de fen�tre Gestion
	 */
	private Gestion frmGestion;

	/**
	 * constructeur permettant d'ouvrir la fen�tre de login
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
	 * ouverture de la fen�tre de gestion demand�e par Login
	 */
	public void evtLanceGestion() {
		this.frmGestion = new Gestion(this) ;
		this.frmGestion.setVisible(true);
		this.frmLogin.setVisible(false);
	}
		
	/**
	 * transf�re au DAL la demande getResponsables() de la vue
	 * @return r�ponse sous forme de ArrayList
	 */
	public ArrayList<Responsable> getResponsables() {
		return AccesDonnees.getResponsables();
	}
	
	/**
	 * transf�re au DAL la demande getPersonnel() de la vue
	 * @return r�ponse sous forme de ArrayList
	 */
	public ArrayList<Personnel> getPersonnel() {
		return AccesDonnees.getPersonnel();
	}
}
