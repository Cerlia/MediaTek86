package controller;

import view.Login;
import view.Gestion;
import dal.AccesDonnees;
import model.Absence;
import model.Motif;
import model.Personnel;
import model.Responsable;
import model.Service;

import java.util.Date;
import java.util.List;

/**
 * classe g�rant les interactions entre la vue et le mod�le
 * @author Claire Stalter
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
		this.frmLogin = new Login(this);
		this.frmLogin.setVisible(true);
	}
	
	/**
	 * ouverture de la fen�tre de gestion demand�e par Login
	 */
	public void evtLanceGestion() {
		this.frmGestion = new Gestion(this);
		this.frmGestion.setVisible(true);
		this.frmLogin.setVisible(false);
	}
		
	/**
	 * transf�re au DAL la demande getResponsables() de la vue
	 * @return liste des responsables sous forme de ArrayList
	 */
	public List<Responsable> getResponsables() {
		return AccesDonnees.getResponsables();
	}
	
	/**
	 * transf�re au DAL la demande getPersonnel() de la vue
	 * @return liste du personnel sous forme de ArrayList
	 */
	public List<Personnel> getPersonnel() {
		return AccesDonnees.getPersonnel();
	}
	
	/**
	 * transf�re au DAL la demande getServices() de la vue
	 * @return liste des services sous forme de ArrayList
	 */
	public List<Service> getServices() {
		return AccesDonnees.getServices();
	}
	
	/**
	 * transf�re au DAL la demande getAbsences() de la vue
	 * @param idpersonnel identifiant de la personne dont on veut les absences
	 * @return liste des absences d'une personne sous forme de ArrayList
	 */
	public List<Absence> getAbsences(int idpersonnel) {
		return AccesDonnees.getAbsences(idpersonnel);
	}	
	
	/**
	 * transf�re au DAL la demande getMotifs() de la vue
	 * @return liste des motifs sous forme de ArrayList
	 */
	public List<Motif> getMotifs() {
		return AccesDonnees.getMotifs();
	}
	
	/**
	 * transf�re au DAL la demande majPersonnel() de la vue
	 * @param personnel donn�es du personnel � mettre � jour
	 */
	public void majPersonnel(Personnel personnel) {
		AccesDonnees.majPersonnel(personnel);
	}
	
	/**
	 * transf�re au DAL la demande creePersonnel() de la vue
	 * @param personnel donn�es du personnel � ajouter
	 */
	public void creePersonnel(Personnel personnel) {
		AccesDonnees.creePersonnel(personnel);
	}
	
	/**
	 * transf�re au DAL la demande supprPersonnel() de la vue
	 * @param personnel donn�es du personnel � supprimer
	 */
	public void supprPersonnel(Personnel personnel) {
		AccesDonnees.supprPersonnel(personnel);
		AccesDonnees.supprToutesAbsences(personnel);
	}
	
	/**
	 * transf�re au DAL la demande majAbsence() de la vue
	 * @param absence donn�es de l'absence � mettre � jour
	 * @param dateDebOriginale date de d�but d'absence avant modification potentielle
	 */
	public void majAbsence(Absence absence, Date dateDebOriginale) {
		AccesDonnees.majAbsence(absence, dateDebOriginale);
	}
	
	/**
	 * transf�re au DAL la demande creeAbsence() de la vue
	 * @param absence donn�es de l'absence � mettre � jour
	 */
	public void creeAbsence(Absence absence) {
		AccesDonnees.creeAbsence(absence);
	}
	
	/**
	 * transf�re au DAL la demande supprAbsence() de la vue
	 * @param absence donn�es de l'absence � mettre � jour
	 */
	public void supprAbsence(Absence absence) {
		AccesDonnees.supprAbsence(absence);
	}
}
