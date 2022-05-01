package model;

/**
 * classe permettant la manipulation d'enregistrements de la table responsable
 * @author Claire
 *
 */
public class Responsable {
	/**
	 * stocke la valeur du champ login de la table responsable 
	 */
	private String login;
	/**
	 * stocke la valeur du champ pwd de la table responsable
	 */
	private String pwd;
	
	/**
	 * getter sur login
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * getter sur pwd
	 * @return pwd
	 */
	public String getPwd() {
		return pwd;
	}
	
	/**
	 * constructeur
	 * @param login champ login de la table responsable
	 * @param pwd champ pwd de la table responsable
	 */
	public Responsable(String login, String pwd) {
		this.login = login;
		this.pwd = pwd;
	}	
}
