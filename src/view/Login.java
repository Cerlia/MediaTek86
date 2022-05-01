package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import controller.Controle;

/**
 * classe permettant l'affichage de la fenêtre de connexion
 * @author Claire
 *
 */
public class Login extends JFrame {

	/**
	 * instance de Controle permettant les échanges avec le contrôleur
	 */
	private Controle controle;
	
	/**
	 * création de la fenêtre
	 * @param controle instance de Controle
	 */
	public Login(Controle controle) {
		this.controle = controle;
		
		setTitle("MediaTek86 - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 180);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLabel0 = new JLabel("Nom");
		lblLabel0.setBounds(10, 22, 46, 14);
		contentPane.add(lblLabel0);
		
		JLabel lblLabel1 = new JLabel("Mot de passe");
		lblLabel1.setBounds(10, 47, 88, 14);
		contentPane.add(lblLabel1);
		
		JButton btnConnect = new JButton("Connexion");
		btnConnect.setBounds(112, 90, 121, 23);
		contentPane.add(btnConnect);
		
		JTextField txtLogin = new JTextField();
		txtLogin.setBounds(112, 19, 200, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(112, 44, 200, 20);
		contentPane.add(txtPassword);
	}
}
