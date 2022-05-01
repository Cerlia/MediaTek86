package dal;

import java.util.List;
import java.util.ArrayList;

import connexion.ConnexionBDD;
import model.Personnel;

/**
 * classe qui fait le lien entre la vue et la classe de connexion
 * @author Claire
 *
 */
public class AccesDonnees {
	/**
	 * chaîne de connexion à la base de données
	 */
	private static String connectionURL = "jdbc:mysql://localhost:3306/mediatek86";
	
	/**
	 * demande à ConnexionBDD la liste d'enregistrements de la table personnel
	 * @return liste du personnel sous forme de ArrayList
	 */
	public static List<Personnel> getPersonnel() {
		List<Personnel> lePersonnel = new ArrayList<>();
		String req = "select p.idpersonnel as idpersonnel, p.nom as nom, p.prenom as prenom, p.tel as tel, p.mail as mail, s.idservice as idservice, s.libelle as service ";
        req += "from personnel p join service s on (p.idservice = s.idservice) ";
        req += "order by nom, prenom;";
        ConnexionBDD conn = ConnexionBDD.getInstance(connectionURL);
        conn.requeteSelect(req);
        while (conn.lireCurseur())
        {
            Personnel personnel = new Personnel((int)conn.champ("iddeveloppeur"), (String)conn.champ("nom"), (String)conn.champ("prenom"), (String)conn.champ("tel"),
            		(String)conn.champ("mail"), (int)conn.champ("idprofil"), (String)conn.champ("profil"));
            lePersonnel.add(personnel);
        }
        conn.fermeCurseur();
        return lePersonnel;
	}
}
