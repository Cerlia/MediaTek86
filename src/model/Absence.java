package model;

import java.time.LocalDate;

/**
 * classe permettant la manipulation d'enregistrements de la table absence
 * @author Claire
 *
 */
public class Absence {
	/**
	 * stocke la valeur du champ idpersonnel de la table absence
	 */
	private int idpersonnel;
	/**
	 * stocke la valeur du champ datedebut de la table absence
	 */
	private LocalDate datedebut;
	/**
	 * stocke la valeur du champ datefin de la table absence
	 */
	private LocalDate datefin;
	/**
	 * stocke la valeur du champ idmotif de la table absence
	 */
	private int idmotif;
	/**
	 * stocke la valeur du champ libelle de la table motif
	 */
	private String motif;
	
	/**
	 * getter sur idpersonnel
	 * @return idpersonnel
	 */
	public int getIdpersonnel() {
		return idpersonnel;
	}

	/**
	 * getter sur datedebut
	 * @return datedebut
	 */
	public LocalDate getDatedebut() {
		return datedebut;
	}

	/**
	 * getter sur datefin
	 * @return datefin
	 */
	public LocalDate getDatefin() {
		return datefin;
	}

	/**
	 * getter sur idmotif
	 * @return idmotif
	 */
	public int getIdmotif() {
		return idmotif;
	}

	/**
	 * getter sur motif
	 * @return motif
	 */
	public String getMotif() {
		return motif;
	}
	
	/**
	 * constructeur
	 * @param idpersonnel champ idpersonnel de la table absence
	 * @param datedebut champ datedebut de la table absence
	 * @param datefin champ datefin de la table absence
	 * @param idmotif champ idmotif de la table absence
	 * @param motif champ libelle de la table motif
	 */
	public Absence(int idpersonnel, LocalDate datedebut, LocalDate datefin, int idmotif, String motif) {
		this.idpersonnel = idpersonnel;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.idmotif = idmotif;
		this.motif = motif;
	}
}


