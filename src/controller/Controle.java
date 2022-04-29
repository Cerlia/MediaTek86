package controller;

import view.Gestion;

public class Controle {
	
	private Gestion frmGestion;

	public static void main(String[] args)
	{
		new Controle();
	}

	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmGestion = new Gestion() ;
		this.frmGestion.setVisible(true);
	}
}
