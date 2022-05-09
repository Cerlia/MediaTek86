package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * classe permettant l'acc�s � la base de donn�es
 * @author Claire Stalter
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
	private Connection connexion = null;	
	/**
	 * curseur utilis� dans les requ�tes de type SELECT
	 */
	private ResultSet curseur = null;
	
	/**
	 * constructeur
	 * @param connectionString cha�ne de connexion
	 * @param login login
	 * @param pwd mot de passe
	 */
	private ConnexionBDD(String connectionString, String login, String pwd) {
		if(connexion == null) {
			try {
				connexion = DriverManager.getConnection(connectionString, login, pwd);			
			}
			catch(SQLException e) {
				System.out.println("Erreur d'acc�s � la BDD");
				System.exit(0);
			}			
		}		
	}
	
	/**
	 * renvoie l'instance unique de la classe apr�s l'avoir cr��e si besoin
	 * @param connectionString cha�ne de connexion
	 * @param login login
	 * @param pwd mot de passe
	 * @return instance unique de la classe
	 */
	public static ConnexionBDD getInstance(String connectionString, String login, String pwd) {
		if (instance == null) {
			instance = new ConnexionBDD(connectionString, login, pwd);
		}		
		return instance;
	}
	
	/**
	 * ex�cution d'une requ�te autre que SELECT
	 * @param requete requ�te MySQL
	 * @param parametres param�tres pour la pr�paration de la requ�te
	 */
	public void requeteUpdate(String requete, List<Object> parametres) {
		if (connexion != null) {
			try {
				PreparedStatement commandeprep = connexion.prepareStatement(requete);
				if (parametres != null) {
					int i = 1;
					for (Object param : parametres) {
				        commandeprep.setObject(i, param);
				        i++;
					}
				}
				commandeprep.executeUpdate();
			}
			catch(SQLException e) {
				if (e.getErrorCode() == 1062) {
					JOptionPane.showConfirmDialog(null,
							"Enregistrement impossible, car une autre absence ayant la m�me date de d�but existe d�j� pour cette personne",
							"Erreur",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE,
							null);	
				}
				else {
					System.out.println(e.getMessage());
				}
			}			
		}		
	}
	
	/**
	 * ex�cution d'une requ�te de type SELECT
	 * @param requete requ�te MySQL
	 * @param parametres param�tres pour la pr�paration de la requ�te
	 */
	public void requeteSelect(String requete, List<Object> parametres) {
		if(connexion != null) {
			try {
				PreparedStatement commandeprep = connexion.prepareStatement(requete);
				if(parametres != null) {
					int i = 1;
					for (Object param : parametres) {
						commandeprep.setObject(i, param);
						i++;
					}
				}
				curseur = commandeprep.executeQuery();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}	
	
	/**
	 * lecture de la ligne suivante du curseur
	 * @return false si la fin du curseur est atteinte
	 */
	public Boolean lireCurseur() {
		if (curseur != null) {
			try {
				return curseur.next();
			}
			catch (SQLException e) {}
		}
		return false;
	}
	
	/**
	 * lecture d'un champ de la ligne actuelle du curseur
	 * @param champ nom du champ � lire
	 * @return valeur du champ
	 */
	public Object champ(String champ) {
		if (curseur == null) {
            return null;
        }
        try {
            return curseur.getObject(champ);
        }
        catch (SQLException e) {
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
				curseur = null;
			}
        }
	}
}