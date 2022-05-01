package model;

/**
 * classe permettant la manipulation d'enregistrements de la table motif
 * @author Claire
 *
 */
public class Motif {
	/**
	 * stocke la valeur du champ idmotif de la table motif
	 */
	private int idmotif;
	/**
	 * stocke la valeur du champ libelle de la table motif
	 */
	private String libelle;
	
	/**
	 * getter sur idmotif
	 * @return idmotif
	 */
	public int getIdmotif() {
		return idmotif;
	}
	
	/**
	 * getter sur libelle
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	
	/**
	 * constructeur
	 * @param idmotif champ idmotif de la table motif
	 * @param libelle champ libelle de la table motif
	 */
	public Motif(int idmotif, String libelle) {
		this.idmotif = idmotif;
		this.libelle = libelle;
	}
}
