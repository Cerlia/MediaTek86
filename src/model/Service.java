package model;

/**
 * classe permettant la manipulation d'enregistrements de la table service
 * @author Claire
 *
 */
public class Service {
	/**
	 * stocke la valeur du champ idservice de la table service
	 */
	private int idservice;
	/**
	 * stocke la valeur du champ nom de la table service
	 */
	private String nom;
	
	/**
	 * getter sur idservice
	 * @return idservice
	 */
	public int getIdservice() {
		return idservice;
	}

	/**
	 * getter sur nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * constructeur
	 * @param idservice champ idservice de la table service
	 * @param nom champ nom de la table service
	 */
	public Service(int idservice, String nom) {
		this.idservice = idservice;
		this.nom = nom;
	}
}
