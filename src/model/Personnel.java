package model;

/**
 * classe permettant la manipulation d'enregistrements de la table personnel
 * @author Claire
 *
 */
public class Personnel {
	/**
	 * stocke la valeur du champ idpersonnel de la table personnel
	 */
	private int idpersonnel;
	/**
	 * stocke la valeur du champ nom de la table personnel
	 */
	private String nom;
	/**
	 * stocke la valeur du champ prenom de la table personnel
	 */
	private String prenom;
	/**
	 * stocke la valeur du champ tel de la table personnel
	 */
	private String tel;
	/**
	 * stocke la valeur du champ mail de la table personnel
	 */
	private String mail;
	/**
	 * stocke la valeur du champ idservice de la table personnel
	 */
	private int idservice;
	/**
	 * stocke la valeur du champ nom de la table service
	 */
	private String service;
	
	/**
	 * getter sur idpersonnel
	 * @return idpersonnel
	 */
	public int getIdpersonnel() {
		return idpersonnel;
	}

	/**
	 * getter sur nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * getter sur prenom
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * getter sur tel
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * getter sur mail
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * getter sur idservice
	 * @return idservice
	 */
	public int getIdservice() {
		return idservice;
	}

	/**
	 * getter sur service
	 * @return service
	 */
	public String getService() {
		return service;
	}
	
	/**
	 * constructeur
	 * @param idpersonnel champ idpersonnel de la table personnel
	 * @param nom champ nom de la table personnel
	 * @param prenom champ prenom de la table personnel
	 * @param tel champ tel de la table personnel
	 * @param mail champ mail de la table personnel
	 * @param idservice champ idservice de la table personnel
	 * @param service champ nom de la table service
	 */
	public Personnel(int idpersonnel, String nom, String prenom, String tel, String mail, int idservice, String service) {
		this.idpersonnel = idpersonnel;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mail = mail;
		this.idservice = idservice;
		this.service = service;
	}
}
