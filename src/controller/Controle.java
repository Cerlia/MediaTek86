package controller;

import java.util.HashMap;

import view.Login;
import view.Gestion;
import connexion.ConnexionBDD;

/**
 * classe gérant les interactions entre la vue et le modèle
 * @author Claire
 *
 */
public class Controle {
	/**
	 * instance de Login
	 */
	private Login frmLogin;

	/**
	 * constructeur permettant d'ouvrir la fenêtre de login
	 */
	public Controle() {
		this.frmLogin = new Login(this) ;
		this.frmLogin.setVisible(true);
	}
}
