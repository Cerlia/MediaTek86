package view;

import controller.Controle;
import model.Absence;
import model.Motif;
import model.Personnel;
import model.Responsable;
import model.Service;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.Color;

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
	 * champ d'entrée du login
	 */
	JTextField txtLogin;
	/**
	 * champ d'entrée du mot de passe
	 */
	JPasswordField txtPassword;
	/**
	 * label pouvant contenir un message d'erreur
	 */
	JLabel lblErreur;
	
	/**
	 * création de la fenêtre
	 * @param controle instance de Controle passée par lui-même
	 */
	public Login(Controle controle) {
		this.controle = controle;		
		setTitle("MediaTek86 - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 135);
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
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnConnect_clic();
			}
		});
		btnConnect.setBounds(284, 43, 98, 23);
		contentPane.add(btnConnect);
		
		txtLogin = new JTextField();
		txtLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				videMessageErreur();
			}
		});
		txtLogin.setBounds(100, 19, 162, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				videMessageErreur();
			}
		});
		
		txtPassword.setBounds(100, 44, 162, 20);
		contentPane.add(txtPassword);
		
		lblErreur = new JLabel("");
		lblErreur.setForeground(Color.RED);
		lblErreur.setBounds(72, 71, 229, 14);
		contentPane.add(lblErreur);
	}
	
	/**
	 * événement clic sur btnConnect : ouverture ou non de la fenêtre de gestion
	 */
	public void btnConnect_clic() {
		if (!txtLogin.getText().equals("") && !(String.valueOf(txtPassword.getPassword())).equals("")) {
			boolean loginok = false;  
			try {
				List<Responsable> lesResponsables = controle.getResponsables();
				for (Responsable resp : lesResponsables) {
					if (resp.getLogin().equals(txtLogin.getText()) && resp.getPwd().equals(getSHA256SecurePassword(String.valueOf(txtPassword.getPassword())))) {
						loginok = true;
					}
				}
			}
			catch (Exception e) {
				System.out.println("Erreur");
			}
			if (loginok) {
				controle.evtLanceGestion();
			}
			else {
				lblErreur.setText("Erreur de nom ou de mot de passe");
			}
		}
	}	
	
	/**
	 * génération d'un mot de passe avec algorithme SHA-2
	 * @param motdepasse mot de passe à hasher
	 * @return hash SHA-2 du mot de passe
	 */
	public String getSHA256SecurePassword(String motdepasse) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(motdepasse.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	/**
	 * effacement du message indiquant une erreur de login/mot de passe
	 */
	public void videMessageErreur() {
		lblErreur.setText("");
	}
}
