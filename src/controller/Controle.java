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
 * classe gérant les interactions entre la vue et le modèle
 * @author Claire Stalter
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
		this.frmLogin = new Login(this);
		this.frmLogin.setVisible(true);
	}
	
	/**
	 * ouverture de la fenêtre de gestion demandée par Login
	 */
	public void evtLanceGestion() {
		this.frmGestion = new Gestion(this);
		this.frmGestion.setVisible(true);
		this.frmLogin.setVisible(false);
	}
		
	/**
	 * transfère au DAL la demande getResponsables() de la vue
	 * @return liste des responsables sous forme de ArrayList
	 */
	public List<Responsable> getResponsables() {
		return AccesDonnees.getResponsables();
	}
	
	/**
	 * transfère au DAL la demande getPersonnel() de la vue
	 * @return liste du personnel sous forme de ArrayList
	 */
	public List<Personnel> getPersonnel() {
		return AccesDonnees.getPersonnel();
	}
	
	/**
	 * transfère au DAL la demande getServices() de la vue
	 * @return liste des services sous forme de ArrayList
	 */
	public List<Service> getServices() {
		return AccesDonnees.getServices();
	}
	
	/**
	 * transfère au DAL la demande getAbsences() de la vue
	 * @param idpersonnel identifiant de la personne dont on veut les absences
	 * @return liste des absences d'une personne sous forme de ArrayList
	 */
	public List<Absence> getAbsences(int idpersonnel) {
		return AccesDonnees.getAbsences(idpersonnel);
	}	
	
	/**
	 * transfère au DAL la demande getMotifs() de la vue
	 * @return liste des motifs sous forme de ArrayList
	 */
	public List<Motif> getMotifs() {
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
		AccesDonnees.supprToutesAbsences(personnel);
	}
	
	/**
	 * transfère au DAL la demande majAbsence() de la vue
	 * @param absence données de l'absence à mettre à jour
	 * @param dateDebOriginale date de début d'absence avant modification potentielle
	 */
	public void majAbsence(Absence absence, Date dateDebOriginale) {
		AccesDonnees.majAbsence(absence, dateDebOriginale);
	}
	
	/**
	 * transfère au DAL la demande creeAbsence() de la vue
	 * @param absence données de l'absence à mettre à jour
	 */
	public void creeAbsence(Absence absence) {
		AccesDonnees.creeAbsence(absence);
	}
	
	/**
	 * transfère au DAL la demande supprAbsence() de la vue
	 * @param absence données de l'absence à mettre à jour
	 */
	public void supprAbsence(Absence absence) {
		AccesDonnees.supprAbsence(absence);
	}
}
