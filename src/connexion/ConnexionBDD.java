package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * classe permettant l'acc�s � la base de donn�es
 * @author Claire
 *
 */
public class ConnexionBDD {
	/**
	 * instance unique de la classe
	 */
	private static ConnexionBDD instance = null;
	/**
	 * connexion � la base de donn�es
	 */
	private Connection connexion;
	/**
	 * commande � envoyer � la base de donn�es
	 */
	private Statement commande;
	/**
	 * commande � envoyer � la base de donn�es (requ�te pr�par�e)
	 */
	private PreparedStatement commandeprep;
	/**
	 * curseur utilis� dans les requ�tes de type SELECT
	 */
	private ResultSet curseur;
	
	/**
	 * constructeur
	 * @param connectionString cha�ne de connexion
	 */
	private ConnexionBDD(String connectionString) {
		try {
			// chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// ouverture de la connexion
			connexion = DriverManager.getConnection(connectionString, "mtmanager", "Aga,Ajtp86");			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connexion impossible");
		    System.exit(0);
		}
	}
	
	/**
	 * renvoie l'instance unique de la classe apr�s l'avoir cr��e si besoin
	 * @param connectionString cha�ne de connexion
	 * @return instance unique de la classe
	 */
	public static ConnexionBDD getInstance(String connectionString) {
		if (ConnexionBDD.instance == null) {
			instance = new ConnexionBDD(connectionString);
		}		
		return instance;
	}
	
	/**
	 * ex�cution d'une requ�te autre que SELECT
	 * @param requete requ�te MySQL
	 * @param parametres param�tres pour la pr�paration de la requ�te
	 */
	public void requeteUpdate(String requete, Map<Integer, String> parametres) {
		try {
			commandeprep = connexion.prepareStatement(requete);						
			for (Map.Entry<Integer, String> e : parametres.entrySet()) {
		        commandeprep.setString(e.getKey(), e.getValue());
			}
			commandeprep.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("erreur");
		}
	}
	
	/**
	 * ex�cution d'une requ�te de type SELECT
	 * @param requete requ�te MySQL
	 */
	public void requeteSelect(String requete) {
		try {
			commande = connexion.createStatement();
			curseur = commande.executeQuery(requete);			
		}
		catch (Exception e) {
			System.out.println("erreur");
		}
	}
	
	/**
	 * lecture de la ligne suivante du curseur
	 * @return false si la fin du curseur est atteinte
	 */
	public Boolean lireCurseur() {
		if (curseur == null) {
			return false;
		}
		try {
			return curseur.next();
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * lecture d'un champ de la ligne actuelle du curseur
	 * @param champ nom du champ � lire
	 * @return valeur du champ
	 */
	public Object champ(String champ) {
		if (curseur == null)
        {
            return null;
        }
        try
        {
            return curseur.getObject(champ);
        }
        catch (Exception e)
        {
            return null;
        }
		
	}
	
	/**
	 * fermeture du curseur
	 */
	public void fermeCurseur() {
        if (curseur != null)
        {
            try {
				curseur.close();
			}
            catch (SQLException e) {
				e.printStackTrace();
			}
        }
	}
}