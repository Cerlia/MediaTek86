package controller;

import java.util.HashMap;

import view.Login;
import view.Gestion;
import connexion.ConnexionBDD;

/**
 * classe g�rant les interactions entre la vue et le mod�le
 * @author Claire
 *
 */
public class Controle {
	/**
	 * instance de Login
	 */
	private Login frmLogin;

	/**
	 * constructeur permettant d'ouvrir la fen�tre de login
	 */
	public Controle() {
		this.frmLogin = new Login(this) ;
		this.frmLogin.setVisible(true);
	}
}
