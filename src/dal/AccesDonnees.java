package dal;

import connexion.ConnexionBDD;
import model.Absence;
import model.Motif;
import model.Personnel;
import model.Responsable;
import model.Service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


/**
 * classe qui fait le lien entre la vue et la classe de connexion
 * @author Claire Stalter
 *
 */
public class AccesDonnees {
	/**
	 * chaîne de connexion à la base de données
	 */
	private static String connectionURL = "jdbc:mysql://localhost:3306/mediatek86";
	/**
	 * login pour accéder à la base de données
	 */
	private static String login = "mtmanager";
	/**
	 * mot de passe pour accéder à la base de données
	 */
	private static String pwd = "Aga,Ajtp86";	
	
	/**
	 * demande à ConnexionBDD la liste d'enregistrements de la table personnel
	 * @return liste du personnel sous forme de ArrayList
	 */
	public static List<Personnel> getPersonnel() {
		ArrayList<Personnel> lePersonnel = new ArrayList<>();
		String req = "select p.idpersonnel as idpersonnel, p.nom as nom, p.prenom as prenom, p.tel as tel, p.mail as mail, s.idservice as idservice, s.nom as service ";
        req += "from personnel p join service s on (p.idservice = s.idservice) ";
        req += "order by nom, prenom;";
        ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
        conn.requeteSelect(req, null);
        while (Boolean.TRUE.equals(conn.lireCurseur()))
        {
            Personnel personnel = new Personnel(
            		(int)conn.champ("idpersonnel"),
            		(String)conn.champ("nom"),
            		(String)conn.champ("prenom"),
            		(String)conn.champ("tel"),
            		(String)conn.champ("mail"),
            		(int)conn.champ("idservice"),
            		(String)conn.champ("service"));
            lePersonnel.add(personnel);
        }
        conn.fermeCurseur();
        return lePersonnel;
	}
	
	/**
	 * demande à ConnexionBDD la liste d'enregistrements de la table responsable
	 * @return liste des responsables sous forme de ArrayList
	 */
	public static List<Responsable> getResponsables() {
		ArrayList<Responsable> lesResponsables = new ArrayList<>();
		String req = "select login, pwd from responsable;";
		ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
		conn.requeteSelect(req, null);
		while (Boolean.TRUE.equals(conn.lireCurseur())) {
			Responsable resp = new Responsable(
					(String)conn.champ("login"),
					(String)conn.champ("pwd"));
			lesResponsables.add(resp);
		}
		conn.fermeCurseur();
		return lesResponsables;
	}
	
	/**
	 * demande à ConnexionBDD la liste d'enregistrements de la table service
	 * @return liste des services sous forme de ArrayList
	 */
	public static List<Service> getServices() {
		ArrayList<Service> lesServices = new ArrayList<>();
		String req = "select idservice, nom from service;";
		ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
		conn.requeteSelect(req, null);
		while (Boolean.TRUE.equals(conn.lireCurseur())) {
			Service service = new Service(
					(int)conn.champ("idservice"),
					(String)conn.champ("nom"));
			lesServices.add(service);
		}
		conn.fermeCurseur();
		return lesServices;
	}
	
	/**
	 * demande à ConnexionBDD la liste d'enregistrements de la table motif
	 * @return liste des motifs sous forme de ArrayList
	 */
	public static List<Motif> getMotifs() {
		ArrayList<Motif> lesMotifs = new ArrayList<>();
		String req = "select idmotif, libelle from motif;";
		ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
		conn.requeteSelect(req, null);
		while (Boolean.TRUE.equals(conn.lireCurseur())) {
			Motif motif = new Motif(
					(int)conn.champ("idmotif"),
					(String)conn.champ("libelle"));
			lesMotifs.add(motif);
		}
		conn.fermeCurseur();
		return lesMotifs;
	}
	
	/**
	 * demande à ConnexionBDD des enregistrements de la table absence
	 * @param idpersonnel identifiant de la personne dont on veut les absences
	 * @return liste des absences sous forme de ArrayList
	 */
	public static List<Absence> getAbsences(int idpersonnel) {
		ArrayList<Absence> lesAbsences = new ArrayList<>();
		String req = "select a.idpersonnel, a.datedebut, a.datefin, a.idmotif, m.libelle from absence a join motif m using (idmotif)";
		req += " where idpersonnel = ? order by (a.datedebut) DESC;";
		ArrayList<Object> lesParametres = new ArrayList<>();
		lesParametres.add(idpersonnel);		
		ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);		
		conn.requeteSelect(req, lesParametres);
		while (Boolean.TRUE.equals(conn.lireCurseur())) {
			Absence absence = new Absence(
					(int)conn.champ("idpersonnel"),
					(Date)conn.champ("datedebut"),
					(Date)conn.champ("datefin"),
					(int)conn.champ("idmotif"),
					(String)conn.champ("libelle"));
			lesAbsences.add(absence);
		}
		conn.fermeCurseur();
		return lesAbsences;
	}	
	
	/**
	 * demande à ConnexionBDD de mettre à jour un enregistrement de la table personnel
	 * @param personnel objet Personnel contenant les données à enregistrer
	 */
	public static void majPersonnel(Personnel personnel) {
		String req = "update personnel set nom = ?, prenom = ?, tel = ?, mail = ?, idservice = ?" +
				" where idpersonnel = ?";
		ArrayList<Object> lesParametres = new ArrayList<>();
		lesParametres.add(personnel.getNom());
		lesParametres.add(personnel.getPrenom());
		lesParametres.add(personnel.getTel());
		lesParametres.add(personnel.getMail());
		lesParametres.add(personnel.getIdservice());
		lesParametres.add(personnel.getIdpersonnel());
        ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
        conn.requeteUpdate(req, lesParametres);
	}
	
	/**
	 * demande à ConnexionBDD d'ajouter un enregistrement dans la table personnel
	 * @param personnel objet Personnel contenant les données à enregistrer
	 */
	public static void creePersonnel(Personnel personnel) {
		String req = "insert into personnel (nom, prenom, tel, mail, idservice)" +
				" values (?, ?, ?, ?, ?)";
		ArrayList<Object> lesParametres = new ArrayList<>();
		lesParametres.add(personnel.getNom());
		lesParametres.add(personnel.getPrenom());
		lesParametres.add(personnel.getTel());
		lesParametres.add(personnel.getMail());
		lesParametres.add(personnel.getIdservice());
        ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
        conn.requeteUpdate(req, lesParametres);
	}
	
	/**
	 * demande à ConnexionBDD de supprimer un enregistrement dans la table personnel
	 * @param personnel objet Personnel contenant les données à supprimer
	 */
	public static void supprPersonnel(Personnel personnel) {
		String req = "delete from personnel where idpersonnel = ?;";
		ArrayList<Object> lesParametres = new ArrayList<>();
		lesParametres.add(personnel.getIdpersonnel());
		ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
        conn.requeteUpdate(req, lesParametres);
	}
	
	/**
	 * demande à ConnexionBDD de mettre à jour un enregistrement de la table absence
	 * @param absence objet Absence contenant les données à enregistrer
	 * @param dateDebOriginale date de début d'absence avant modification potentielle
	 */
	public static void majAbsence(Absence absence, Date dateDebOriginale) {
		String req = "update absence set datedebut = ?, idmotif = ?, datefin = ?" +
				" where idpersonnel = ? and datedebut = ?";
		ArrayList<Object> lesParametres = new ArrayList<>();
		lesParametres.add(absence.getDatedebut());
		lesParametres.add(absence.getIdmotif());
		lesParametres.add(absence.getDatefin());
		lesParametres.add(absence.getIdpersonnel());
		lesParametres.add(dateDebOriginale);
        ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
        conn.requeteUpdate(req, lesParametres);
	}
	
	/**
	 * demande à ConnexionBDD d'ajouter un enregistrement dans la table absence
	 * @param absence objet Absence contenant les données à enregistrer
	 */
	public static void creeAbsence(Absence absence) {
		String req = "insert into absence (idpersonnel, datedebut, idmotif, datefin)" +
				" values (?, ?, ?, ?)";
		ArrayList<Object> lesParametres = new ArrayList<>();
		lesParametres.add(absence.getIdpersonnel());
		lesParametres.add(absence.getDatedebut());
		lesParametres.add(absence.getIdmotif());
		lesParametres.add(absence.getDatefin());
        ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
        conn.requeteUpdate(req, lesParametres);
	}
	
	/**
	 * demande à ConnexionBDD de supprimer un enregistrement dans la table absence
	 * @param absence objet Absence contenant les données à supprimer
	 */
	public static void supprAbsence(Absence absence) {
		String req = "delete from absence where idpersonnel = ? and datedebut = ?;";
		ArrayList<Object> lesParametres = new ArrayList<>();
		lesParametres.add(absence.getIdpersonnel());
		lesParametres.add(absence.getDatedebut());
		ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL, login, pwd);
        conn.requeteUpdate(req, lesParametres);
	}
}
