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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;

/**
 * classe permettant l'affichage de la fenêtre principale
 * @author Claire
 *
 */
public class Gestion extends JFrame {
	/**
	 * instance de Controle permettant les échanges avec le contrôleur
	 */
	private Controle controle;
	/**
	 * panneau d'affichage du personnel (haut gauche)
	 */
	private JPanel pnlPersonnel;
	/**
	 * panneau d'ajout/modification du personnel (bas gauche)
	 */
	private JPanel pnlModifPersonnel;
	/**
	 * panneau d'affichage des absences (haut droite)
	 */
	private JPanel pnlAbsence;
	/**
	 * panneau d'ajout/modification d'une absence (bas droite)
	 */
	private JPanel pnlModifAbsence;
	/**
	 * table contenant la liste du personnel
	 */
	private JTable tblPersonnel;
	/**
	 * table contenant la liste des absences
	 */
	private JTable tblAbsences;
	
	/**
	 * création de la fenêtre
	 */
	public Gestion(Controle controle) {
		this.controle = controle;
		setTitle("MediaTek86 - Gestion du personnel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 725);
		JPanel contentPane = new JPanel();
		contentPane.setLocation(-495, -538);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlPersonnel = new JPanel();
		pnlPersonnel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlPersonnel.setBounds(10, 29, 627, 390);
		contentPane.add(pnlPersonnel);
		pnlPersonnel.setLayout(null);
		
		JButton btnAjoutPers = new JButton("Ajouter");
		btnAjoutPers.setBounds(10, 356, 95, 23);
		pnlPersonnel.add(btnAjoutPers);
		
		JButton btnModifPers = new JButton("Modifier");
		btnModifPers.setBounds(111, 356, 95, 23);
		pnlPersonnel.add(btnModifPers);
		
		JButton btnSuppPers = new JButton("Supprimer");
		btnSuppPers.setBounds(212, 356, 95, 23);
		pnlPersonnel.add(btnSuppPers);
		
		JButton btnGerAbs = new JButton("G\u00E9rer les absences");
		btnGerAbs.setBounds(466, 356, 149, 23);
		pnlPersonnel.add(btnGerAbs);
		
		tblPersonnel = new JTable();
		tblPersonnel.setBounds(10, 12, 605, 335);
		pnlPersonnel.add(tblPersonnel);
		
		pnlAbsence = new JPanel();
		pnlAbsence.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlAbsence.setBounds(683, 29, 389, 461);
		contentPane.add(pnlAbsence);
		pnlAbsence.setLayout(null);
		
		JButton btnAjoutAbs = new JButton("Ajouter");
		btnAjoutAbs.setBounds(43, 428, 95, 23);
		pnlAbsence.add(btnAjoutAbs);
		
		JButton btnModifAbs = new JButton("Modifier");
		btnModifAbs.setBounds(145, 428, 95, 23);
		pnlAbsence.add(btnModifAbs);
		
		JButton btnSuppAbs = new JButton("Supprimer");
		btnSuppAbs.setBounds(246, 428, 95, 23);
		pnlAbsence.add(btnSuppAbs);
		
		pnlModifPersonnel = new JPanel();
		pnlModifPersonnel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlModifPersonnel.setBounds(10, 465, 627, 206);
		contentPane.add(pnlModifPersonnel);
		pnlModifPersonnel.setLayout(null);
		
		JLabel lblLabel0 = new JLabel("Nom");
		lblLabel0.setBounds(10, 32, 56, 14);
		pnlModifPersonnel.add(lblLabel0);
		
		JLabel lblLabel1 = new JLabel("Pr\u00E9nom");
		lblLabel1.setBounds(10, 62, 46, 14);
		pnlModifPersonnel.add(lblLabel1);
		
		JLabel lblLabel2 = new JLabel("Service");
		lblLabel2.setBounds(10, 95, 46, 14);
		pnlModifPersonnel.add(lblLabel2);
		
		JLabel lblLabel3 = new JLabel("T\u00E9l\u00E9phone");
		lblLabel3.setBounds(10, 135, 85, 14);
		pnlModifPersonnel.add(lblLabel3);
		
		JLabel lblLabel4 = new JLabel("E-mail");
		lblLabel4.setBounds(10, 170, 46, 14);
		pnlModifPersonnel.add(lblLabel4);
		
		JTextField txtNom = new JTextField();
		txtNom.setBounds(113, 29, 268, 20);
		pnlModifPersonnel.add(txtNom);
		txtNom.setColumns(10);
		
		JTextField txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(113, 59, 268, 20);
		pnlModifPersonnel.add(txtPrenom);
		
		JTextField txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(113, 132, 268, 20);
		pnlModifPersonnel.add(txtTel);
		
		JComboBox cboService = new JComboBox();
		cboService.setBounds(113, 91, 268, 22);
		pnlModifPersonnel.add(cboService);
		
		JTextField txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(113, 167, 268, 20);
		pnlModifPersonnel.add(txtMail);
		
		JButton btnSavePers = new JButton("Enregistrer");
		btnSavePers.setBounds(500, 131, 101, 23);
		pnlModifPersonnel.add(btnSavePers);
		
		JButton btnCancelPers = new JButton("Annuler");
		btnCancelPers.setBounds(500, 166, 101, 23);
		pnlModifPersonnel.add(btnCancelPers);
		
		pnlModifAbsence = new JPanel();
		pnlModifAbsence.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlModifAbsence.setBounds(683, 538, 389, 133);
		contentPane.add(pnlModifAbsence);
		pnlModifAbsence.setLayout(null);
		
		JLabel lblLabel5 = new JLabel("Motif");
		lblLabel5.setBounds(10, 28, 56, 14);
		pnlModifAbsence.add(lblLabel5);
		
		JComboBox cboMotif = new JComboBox();
		cboMotif.setBounds(108, 24, 142, 22);
		pnlModifAbsence.add(cboMotif);
		
		JLabel lblLabel6 = new JLabel("Date de d\u00E9but");
		lblLabel6.setBounds(10, 67, 90, 14);
		pnlModifAbsence.add(lblLabel6);
		
		JLabel lblLabel7 = new JLabel("Date de fin");
		lblLabel7.setBounds(10, 97, 75, 14);
		pnlModifAbsence.add(lblLabel7);
		
		JButton btnSaveAbs = new JButton("Enregistrer");
		btnSaveAbs.setBounds(276, 63, 101, 23);
		pnlModifAbsence.add(btnSaveAbs);
		
		JButton btnCancelAbs = new JButton("Annuler");
		btnCancelAbs.setBounds(276, 93, 101, 23);
		pnlModifAbsence.add(btnCancelAbs);
		
		JDateChooser dtcDateDeb = new JDateChooser();
		dtcDateDeb.setBounds(108, 61, 142, 20);
		pnlModifAbsence.add(dtcDateDeb);
		
		JDateChooser dtcDateFin = new JDateChooser();
		dtcDateFin.setBounds(108, 97, 142, 20);
		pnlModifAbsence.add(dtcDateFin);
		
		JLabel lblTitre1 = new JLabel("Personnel");
		lblTitre1.setBounds(10, 11, 99, 14);
		contentPane.add(lblTitre1);
		
		JLabel lblTitre2 = new JLabel("Absences");
		lblTitre2.setBounds(683, 11, 371, 14);
		contentPane.add(lblTitre2);
		
		JLabel lblTitre3 = new JLabel("Ajouter une personne");
		lblTitre3.setBounds(10, 445, 149, 14);
		contentPane.add(lblTitre3);
		
		JLabel lblTitre4 = new JLabel("Ajouter une absence");
		lblTitre4.setBounds(685, 516, 142, 14);
		contentPane.add(lblTitre4);
		
		statutPanel(pnlModifPersonnel, false);
		statutPanel(pnlAbsence, false);
		
		tblAbsences = new JTable();
		tblAbsences.setBounds(12, 12, 365, 404);
		pnlAbsence.add(tblAbsences);
		statutPanel(pnlModifAbsence, false);
		
		// chargement de la liste du personnel
		chargePersonnel();
		// chargement du combo des services
		// chargeServices();
		// chargement du combo des motifs d'absence
		// chargeMotifs();
	}
	
	/**
	 * activation/désactivation des composants d'un JPanel
	 * @param panel JPanel à activer/désactiver
	 * @param actif true si le JPanel doit être rendu actif
	 */
	private void statutPanel(JPanel panel, Boolean actif) {
	    Component[] composants = panel.getComponents();
	    for (Component composant : composants) {
	        composant.setEnabled(actif);
	    }
	}
	
	/**
	 * chargement de la liste du personnel dans la JTable tblPersonnel
	 */
	private void chargePersonnel() {
		ArrayList<Personnel> lePersonnel = controle.getPersonnel();
		// appel de méthode pour construire le "model" de remplissage de la table
		tblPersonnel.setModel(model(lePersonnel));
	}
	
	/**
	 * construction du modèle pour afficher les données dans une table
	 * @param lePersonnel liste d'objets de type Personnel
	 * @return modèle de données
	 */
	private DefaultTableModel model(ArrayList<Personnel> lePersonnel) {
		String[] colonnes = { "Nom", "Prénom", "Téléphone", "Mail", "Service"};
		Object[][] donnees = new Object[lePersonnel.size()][5];
		for (int i = 0; i < lePersonnel.size(); i++) {
			donnees[i][0] = lePersonnel.get(i).getNom();
			donnees[i][1] = lePersonnel.get(i).getPrenom();
			donnees[i][2] = lePersonnel.get(i).getTel();
			donnees[i][3] = lePersonnel.get(i).getMail();
			donnees[i][4] = lePersonnel.get(i).getService();
		}
		return new DefaultTableModel(donnees, colonnes);
	}
}
