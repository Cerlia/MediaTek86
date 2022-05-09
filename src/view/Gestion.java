package view;

import controller.Controle;
import model.Absence;
import model.Motif;
import model.Personnel;
import model.Service;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

/**
 * classe permettant l'affichage de la fenêtre principale
 * @author Claire Stalter
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
	 * bouton qui active/désactive le panneau des absences
	 */
	private Button btnGerAbs;	
	/**
	 * table contenant la liste du personnel
	 */
	private JTable tblPersonnel;
	/**
	 * table contenant la liste des absences
	 */
	private JTable tblAbsences;
	/**
	 * combobox des services
	 */
	private JComboBox<String> cboService;
	/**
	 * combobox des motifs
	 */
	private JComboBox<String> cboMotif;
	/**
	 * champ nom de pnlModifPersonnel
	 */
	private JTextField txtNom;
	/**
	 * champ prénom de pnlModifPersonnel
	 */
	private JTextField txtPrenom;
	/**
	 * champ téléphone de pnlModifPersonnel
	 */
	private JTextField txtTel;
	/**
	 * champ e-mail de pnlModifPersonnel
	 */
	private JTextField txtMail;
	/**
	 * label titre de pnlAbsences
	 */
	private JLabel lblAbsences;
	/**
	 * label titre de pnlModifPersonnel
	 */	
	private JLabel lblAjModifPers;
	/**
	 * label titre de pnlModifAbsence
	 */
	private JLabel lblAjModifAbs;
	/**
	 * calendrier pour la date de début d'une absence
	 */
	private JDateChooser dtcDateDeb;
	/**
	 * calendrier pour la date de fin d'une absence
	 */
	private JDateChooser dtcDateFin;
	/**
	 * mémorise si un ajout de personnel est en cours
	 */
	private Boolean ajoutPersEnCours = false;
	/**
	 * mémorise si une modification de personnel est en cours
	 */
	private Boolean modifPersEnCours = false;
	/**
	 * mémorise si un ajout d'absence est en cours
	 */
	private Boolean ajoutAbsEnCours = false;
	/**
	 * mémorise si une modification d'absence est en cours
	 */
	private Boolean modifAbsEnCours = false;


	
	/**
	 * création de la fenêtre
	 * @param controle instance de Controle passée par lui-même
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
		
		/*  --------------------
		 * 
		 *	    PERSONNEL  
		 * 
		 * --------------------- */
		
		JLabel lblTitre1 = new JLabel("Personnel");
		lblTitre1.setBounds(10, 11, 627, 14);
		contentPane.add(lblTitre1);
				
		lblAjModifPers = new JLabel("Ajouter une personne");
		lblAjModifPers.setBounds(10, 446, 627, 14);
		contentPane.add(lblAjModifPers);
		
		pnlPersonnel = new JPanel();
		pnlPersonnel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlPersonnel.setBounds(10, 29, 627, 390);
		contentPane.add(pnlPersonnel);
		pnlPersonnel.setLayout(null);
		
		Button btnAjoutPers = new Button("Ajouter");
		btnAjoutPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAjoutPers_clic();
			}
		});
		btnAjoutPers.setBounds(10, 356, 95, 23);
		pnlPersonnel.add(btnAjoutPers);
		
		Button btnModifPers = new Button("Modifier");
		btnModifPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnModifPers_clic();
			}
		});
		btnModifPers.setBounds(111, 356, 95, 23);
		pnlPersonnel.add(btnModifPers);
		
		Button btnSuppPers = new Button("Supprimer");
		btnSuppPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSuppPers_clic();
			}
		});
		btnSuppPers.setBounds(212, 356, 95, 23);
		pnlPersonnel.add(btnSuppPers);
		
		btnGerAbs = new Button("G\u00E9rer les absences");
		btnGerAbs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnGerAbs_clic();
			}
		});
		btnGerAbs.setBounds(430, 356, 185, 23);
		pnlPersonnel.add(btnGerAbs);
		
		JScrollPane scpPersonnel = new JScrollPane();
		scpPersonnel.setBounds(12, 12, 603, 329);
		pnlPersonnel.add(scpPersonnel);
		
		tblPersonnel = new JTable();
		tblPersonnel.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scpPersonnel.setViewportView(tblPersonnel);
		tblPersonnel.setFillsViewportHeight(true);
		tblPersonnel.setDefaultEditor(Object.class, null);
		tblPersonnel.getTableHeader().setReorderingAllowed(false);
		
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
		
		txtNom = new JTextField();
		txtNom.setBounds(113, 29, 268, 20);
		pnlModifPersonnel.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(113, 59, 268, 20);
		pnlModifPersonnel.add(txtPrenom);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(113, 132, 268, 20);
		pnlModifPersonnel.add(txtTel);
		
		cboService = new JComboBox<>();
		cboService.setBounds(113, 91, 268, 22);
		pnlModifPersonnel.add(cboService);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(113, 167, 268, 20);
		pnlModifPersonnel.add(txtMail);
		
		Button btnSavePers = new Button("Enregistrer");
		btnSavePers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSavePers_clic();
			}
		});
		btnSavePers.setBounds(500, 131, 101, 23);
		pnlModifPersonnel.add(btnSavePers);
		
		Button btnCancelPers = new Button("Annuler");
		btnCancelPers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finModifPers();
			}
		});
		btnCancelPers.setBounds(500, 166, 101, 23);
		pnlModifPersonnel.add(btnCancelPers);
		
		/*  --------------------
		 * 
		 *	    ABSENCES  
		 * 
		 * --------------------- */
		
		lblAbsences = new JLabel("Absences");
		lblAbsences.setBounds(683, 11, 389, 14);
		contentPane.add(lblAbsences);
		
		lblAjModifAbs = new JLabel("Ajouter une absence");
		lblAjModifAbs.setBounds(683, 519, 387, 14);
		contentPane.add(lblAjModifAbs);
		
		pnlAbsence = new JPanel();
		pnlAbsence.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlAbsence.setBounds(683, 29, 389, 461);
		contentPane.add(pnlAbsence);
		pnlAbsence.setLayout(null);
		
		Button btnAjoutAbs = new Button("Ajouter");
		btnAjoutAbs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAjoutAbs_clic();
			}
		});
		btnAjoutAbs.setBounds(43, 428, 95, 23);
		pnlAbsence.add(btnAjoutAbs);
		
		Button btnModifAbs = new Button("Modifier");
		btnModifAbs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnModifAbs_clic();
			}
		});
		btnModifAbs.setBounds(145, 428, 95, 23);
		pnlAbsence.add(btnModifAbs);
		
		Button btnSuppAbs = new Button("Supprimer");
		btnSuppAbs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSuppAbs_clic();
			}
		});
		btnSuppAbs.setBounds(246, 428, 95, 23);
		pnlAbsence.add(btnSuppAbs);
				
		pnlModifAbsence = new JPanel();
		pnlModifAbsence.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlModifAbsence.setBounds(683, 538, 389, 133);
		contentPane.add(pnlModifAbsence);
		pnlModifAbsence.setLayout(null);
		
		JLabel lblLabel5 = new JLabel("Motif");
		lblLabel5.setBounds(10, 28, 56, 14);
		pnlModifAbsence.add(lblLabel5);
		
		cboMotif = new JComboBox<>();
		cboMotif.setBounds(108, 24, 142, 22);
		pnlModifAbsence.add(cboMotif);
		
		JLabel lblLabel6 = new JLabel("Date de d\u00E9but");
		lblLabel6.setBounds(10, 67, 90, 14);
		pnlModifAbsence.add(lblLabel6);
		
		JLabel lblLabel7 = new JLabel("Date de fin");
		lblLabel7.setBounds(10, 97, 75, 14);
		pnlModifAbsence.add(lblLabel7);
		
		Button btnSaveAbs = new Button("Enregistrer");
		btnSaveAbs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSaveAbs_clic();
			}
		});
		btnSaveAbs.setBounds(276, 58, 101, 23);
		pnlModifAbsence.add(btnSaveAbs);
		
		Button btnCancelAbs = new Button("Annuler");
		btnCancelAbs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finModifAbs();
			}
		});
		btnCancelAbs.setBounds(276, 93, 101, 23);
		pnlModifAbsence.add(btnCancelAbs);
		
		dtcDateDeb = new JDateChooser();
		dtcDateDeb.setBounds(108, 61, 142, 20);
		pnlModifAbsence.add(dtcDateDeb);
		
		dtcDateFin = new JDateChooser();
		dtcDateFin.setBounds(108, 97, 142, 20);
		pnlModifAbsence.add(dtcDateFin);
				
		JScrollPane scpAbsences = new JScrollPane();
		scpAbsences.setBounds(12, 12, 365, 402);
		pnlAbsence.add(scpAbsences);
		
		tblAbsences = new JTable();
		scpAbsences.setViewportView(tblAbsences);		
		tblAbsences.setFillsViewportHeight(true);
		tblAbsences.setDefaultEditor(Object.class, null);
		tblAbsences.getTableHeader().setReorderingAllowed(false);
				
		statutPanel(pnlModifPersonnel, false);
		statutPanel(pnlAbsence, false);
		statutPanel(pnlModifAbsence, false);
		
		// chargement de la liste du personnel
		chargePersonnel();
		// chargement du combo des services
		chargeServices();
		// chargement du combo des motifs d'absence
		chargeMotifs();
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
		tblPersonnel.setModel(modelTblPers(lePersonnel));
		tblPersonnel.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblPersonnel.getColumnModel().getColumn(1).setPreferredWidth(30);
		tblPersonnel.getColumnModel().getColumn(2).setPreferredWidth(30);
		tblPersonnel.getColumnModel().getColumn(3).setPreferredWidth(60);
		tblPersonnel.removeColumn(tblPersonnel.getColumnModel().getColumn(0));
		tblPersonnel.removeColumn(tblPersonnel.getColumnModel().getColumn(4));
	}
		
	/**
	 * chargement de la liste des absences dans la JTable tblAbsences
	 * @param idpersonnel idpersonnel de la personne dont on affiche les absences
	 */
	private void chargeAbsences(int idpersonnel) {
		ArrayList<Absence> lesAbsences = controle.getAbsences(idpersonnel);
		tblAbsences.setModel(modelTblAbs(lesAbsences));		
		tblAbsences.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblAbsences.getColumnModel().getColumn(1).setPreferredWidth(30);
		tblAbsences.getColumnModel().getColumn(2).setPreferredWidth(30);
		tblAbsences.getColumnModel().getColumn(3).setPreferredWidth(60);
		tblAbsences.removeColumn(tblAbsences.getColumnModel().getColumn(0));
		tblAbsences.removeColumn(tblAbsences.getColumnModel().getColumn(2));		
	}
	
	/**
	 * chargement du JComboBox cboService du panel pnlModifPersonnel
	 */
	private void chargeServices() {
		ArrayList<Service> lesServices = controle.getServices();
		cboService.setModel(modelCboServ(lesServices));
	}
	
	/**
	 * chargement du JComboBox cboMotif du panel pnlModifAbsence
	 */
	private void chargeMotifs() {
		ArrayList<Motif> lesMotifs = controle.getMotifs();
		cboMotif.setModel(modelCboMotif(lesMotifs));
	}
	
	/**
	 * construction du modèle pour afficher les données de la table tblPersonnel
	 * @param lePersonnel liste d'objets de type Personnel
	 * @return modèle de données
	 */
	private DefaultTableModel modelTblPers(ArrayList<Personnel> lePersonnel) {
		String[] colonnes = new String[] { "idpers", "Nom", "Prénom", "Téléphone", "Mail", "idserv", "Service"};
		Object[][] donnees = new Object[lePersonnel.size()][7];
		for (int i = 0; i < lePersonnel.size(); i++) {
			donnees[i][0] = lePersonnel.get(i).getIdpersonnel();
			donnees[i][1] = lePersonnel.get(i).getNom();
			donnees[i][2] = lePersonnel.get(i).getPrenom();
			donnees[i][3] = lePersonnel.get(i).getTel();
			donnees[i][4] = lePersonnel.get(i).getMail();
			donnees[i][5] = lePersonnel.get(i).getIdservice();
			donnees[i][6] = lePersonnel.get(i).getService();
		}
		return new DefaultTableModel(donnees, colonnes);
	}
	
	/**
	 * construction du modèle pour afficher les données de la table tblAbsences
	 * @param lesAbsences liste d'objets de type Absence
	 * @return modèle de données
	 */
	private DefaultTableModel modelTblAbs(ArrayList<Absence> lesAbsences) {
		String[] colonnes = new String[] { "idpers", "Date de début", "Date de fin", "idmotif", "Motif"};
		Object[][] donnees = new Object[lesAbsences.size()][5];
		for (int i = 0; i < lesAbsences.size(); i++) {
			donnees[i][0] = lesAbsences.get(i).getIdpersonnel();
			donnees[i][1] = lesAbsences.get(i).getDatedebut();
			donnees[i][2] = lesAbsences.get(i).getDatefin();
			donnees[i][3] = lesAbsences.get(i).getIdmotif();
			donnees[i][4] = lesAbsences.get(i).getMotif();
		}
		return new DefaultTableModel(donnees, colonnes);
	}
	
	/**
	 * construction du modèle pour afficher les données du combobox cboServices
	 * @param lesServices liste d'objets de type Service
	 * @return modèle de données
	 */
	private DefaultComboBoxModel<String> modelCboServ(ArrayList<Service> lesServices) {
		String[] donnees = new String[lesServices.size()];
		for (int i = 0; i < lesServices.size(); i++) {
			donnees[i] = lesServices.get(i).getNom();			
		}
		return new DefaultComboBoxModel<>(donnees);
	}
	
	/**
	 * construction du modèle pour afficher les données du combobox cboMotifs
	 * @param lesMotifs liste d'objets de type Motif
	 * @return modèle de données
	 */
	private DefaultComboBoxModel<String> modelCboMotif(ArrayList<Motif> lesMotifs) {
		String[] donnees = new String[lesMotifs.size()];
		for (int i = 0; i < lesMotifs.size(); i++) {
			donnees[i] = lesMotifs.get(i).getLibelle();			
		}
		return new DefaultComboBoxModel<>(donnees);
	}
	
	/**
	 * événement clic sur btnAjoutPers : activation du panneau pnlModifPersonnel
	 */
	private void btnAjoutPers_clic() {
		ajoutPersEnCours = true;
		statutPanel(pnlModifPersonnel, true);	
		statutPanel(pnlPersonnel, false);
		tblPersonnel.setEnabled(false);
		tblPersonnel.clearSelection();
	}
	
	/**
	 * événement clic sur btnModifPers : activation du panneau pnlModifPersonnel avec remplissage des champs
	 */
	private void btnModifPers_clic() {
		if (tblPersonnel.getSelectedRow() != -1) {
			try {
				ajoutPersEnCours = false;
				modifPersEnCours = true;
				lblAjModifPers.setText("Modifier les données d'une personne");
				statutPanel(pnlModifPersonnel, true);
				statutPanel(pnlPersonnel, false);
				tblPersonnel.setEnabled(false);
				// copie des données dans les champs correspondants
				int index = tblPersonnel.getSelectedRow();
				txtNom.setText((String)tblPersonnel.getModel().getValueAt(index, 1));
				txtPrenom.setText((String)tblPersonnel.getModel().getValueAt(index, 2));
				txtTel.setText((String)tblPersonnel.getModel().getValueAt(index, 3));
				txtMail.setText((String)tblPersonnel.getModel().getValueAt(index, 4));
				cboService.setSelectedIndex((int)tblPersonnel.getModel().getValueAt(index, 5)-1);	
			} catch (Exception e) {}					
		}
		else {
			JOptionPane.showConfirmDialog(null,
					"Une ligne doit être sélectionnée",
					"Information",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null);
		}
	}
	
	/**
	 * événement clic sur btnSavePers
	 */
	private void btnSavePers_clic() {
		if (!txtNom.getText().equals("") && !txtPrenom.getText().equals("")
				&& !txtTel.getText().equals("") && !txtMail.getText().equals("")) {
			int idpersonnel = 0;
			if (Boolean.TRUE.equals(modifPersEnCours)) {
				idpersonnel = (int)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 0);
			}
			String nom = txtNom.getText();
			String prenom = txtPrenom.getText();
			String tel = txtTel.getText();
			String mail = txtMail.getText();
			int idservice = cboService.getSelectedIndex()+1;
			String service = cboService.getSelectedItem().toString();
			Personnel personnel = new Personnel(idpersonnel, nom, prenom, tel, mail, idservice, service);
			// demande de confirmation			
			int choix = 0;
			if (Boolean.TRUE.equals(ajoutPersEnCours)) {
				choix = confirmMsgBoxPers("Ajouter une entrée avec ces informations ?", personnel);
			}
			else if (Boolean.TRUE.equals(modifPersEnCours)) {
				choix = confirmMsgBoxPers("Mettre à jour l'entrée avec ces informations ?", personnel);
			}			
			if (choix == 0) {
				if (modifPersEnCours) {
					controle.majPersonnel(personnel);
                    modifPersEnCours = false;
				}
				else if (ajoutPersEnCours) {
					controle.creePersonnel(personnel);
					ajoutPersEnCours = false;
				}
				finModifPers();
				chargePersonnel();
			}			
		}
		else {
			JOptionPane.showConfirmDialog(null,
					"Tous les champs doivent être remplis",
					"Information",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null);
		}				
	}
	
	/**
	 * affichage d'une boîte de dialogue demandant confirmation sur ajout/modification/suppression de personnel
	 * @param question question posée à l'utilisateur
	 * @param personnel données du personnel concerné par la question
	 * @return choix de l'utilisateur
	 */
	private int confirmMsgBoxPers(String question, Personnel personnel) {
		Object[] options = {"Confirmer", "Annuler"};
		return JOptionPane.showOptionDialog(null,
				"Nom : " + personnel.getNom() + "\nPrénom : " + personnel.getPrenom() + "\nService : " + personnel.getService() + 
				"\nTéléphone : " + personnel.getTel() + "\nE-Mail : " + personnel.getMail() + "\n\n" + question,
                "Demande de confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
	}
	
	/**
	 * réactivation de pnlPersonnel et désactivation de pnlModifPersonnel
	 */
	private void finModifPers() {
		statutPanel(pnlPersonnel, true);
        statutPanel(pnlModifPersonnel, false);
        lblAjModifPers.setText("Ajouter une personne");
        tblPersonnel.setEnabled(true);
    	ajoutPersEnCours = false;
    	modifPersEnCours = false;
        txtNom.setText("");
        txtPrenom.setText("");
        cboService.setSelectedIndex(0);
        txtTel.setText("");
        txtMail.setText("");
	}
	
	/**
	 * événement clic sur btnSuppPers
	 */
	private void btnSuppPers_clic() {
		if (tblPersonnel.getSelectedRow() != -1) {
			tblPersonnel.setEnabled(false);
			String question = "Supprimer les données de cette personne ?";
			int idpersonnel = (int)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 0);
			String nom = (String)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 1);
			String prenom = (String)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 2);
			String tel = (String)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 3);
			String mail = (String)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 4);
			int idservice = (int)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 5);
			String service = (String)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 6);
			Personnel personnel = new Personnel(idpersonnel, nom, prenom, tel, mail, idservice, service);
			int choix = confirmMsgBoxPers(question, personnel);
			if (choix == 0) {
				controle.supprPersonnel(personnel);
				chargePersonnel();				
			}
			tblPersonnel.setEnabled(true);
		}
		else {
			infoSelection();
		}
	}
	
	/**
	 * événement clic sur btnGerAbs
	 */
	private void btnGerAbs_clic() {
		// si le panneau des absences est inactif
		if (btnGerAbs.getLabel().equals("G\u00E9rer les absences")) {
			if (tblPersonnel.getSelectedRow() != -1) {
				finModifPers();
				tblPersonnel.setEnabled(false);
				statutPanel(pnlPersonnel, false);
				statutPanel(pnlAbsence, true);
				btnGerAbs.setEnabled(true);
				btnGerAbs.setLabel("Fermer les absences");
				int idpersonnel = (int)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 0);
				lblAbsences.setText("Absences - " + (String)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 2) +
						" " + (String)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 1));
				chargeAbsences(idpersonnel);
			}
			else {
				infoSelection();
			}
		// si le panneau des absences est actif
		}
		else if (btnGerAbs.getLabel().equals("Fermer les absences")) {
			DefaultTableModel dm = (DefaultTableModel)tblAbsences.getModel();
			dm.getDataVector().removeAllElements();
			dm.setColumnCount(0);
			dm.fireTableDataChanged();		
			statutPanel(pnlAbsence, false);
			statutPanel(pnlPersonnel, true);
			tblPersonnel.setEnabled(true);
			btnGerAbs.setLabel("Gérer les absences");
			lblAbsences.setText("Absences");
		}		
	}
	
	/**
	 * affichage d'un message avertissant qu'une ligne doit être sélectionnée
	 */
	private void infoSelection() {
		JOptionPane.showConfirmDialog(null,
				"Une ligne doit être sélectionnée",
				"Information",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null);
	}
	
	/**
	 * événement clic sur btnAjoutAbs : activation du panneau pnlModifAbsence
	 */
	private void btnAjoutAbs_clic() {
		ajoutAbsEnCours = true;
		statutPanel(pnlModifAbsence, true);
		statutPanel(pnlAbsence, false);
		tblAbsences.setEnabled(false);
		tblAbsences.clearSelection();
	}	
	
	/**
	 * événement clic sur btnModifAbs : activation du panneau pnlModifAbsence avec remplissage des champs
	 */
	private void btnModifAbs_clic() {
		if (tblAbsences.getSelectedRow() != -1) {
			try {
				ajoutAbsEnCours = false;
				modifAbsEnCours = true;
				lblAjModifAbs.setText("Modifier une absence");
				statutPanel(pnlModifAbsence, true);
				statutPanel(pnlAbsence, false);
				btnGerAbs.setEnabled(false);
				tblAbsences.setEnabled(false);
				int index = tblAbsences.getSelectedRow();
				// copie des données dans les champs correspondants				
				cboMotif.setSelectedIndex((int)tblAbsences.getModel().getValueAt(index, 3)-1);
				dtcDateDeb.setDate((Date)tblAbsences.getModel().getValueAt(index, 1));
				dtcDateFin.setDate((Date)tblAbsences.getModel().getValueAt(index, 2));					
			} catch (Exception e) {}					
		}
		else {
			infoSelection();
		}
	}
	
	/**
	 * réactivation de pnlPersonnel et désactivation de pnlModifPersonnel
	 */
	private void finModifAbs() {
		statutPanel(pnlAbsence, true);
        statutPanel(pnlModifAbsence, false);
        btnGerAbs.setEnabled(true);
        lblAjModifAbs.setText("Ajouter une absence");
        tblAbsences.setEnabled(true);
    	ajoutAbsEnCours = false;
    	modifAbsEnCours = false;
        cboMotif.setSelectedIndex(0);
        dtcDateDeb.setDate(null);
        dtcDateFin.setDate(null);
	}
	
	/**
	 * événement clic sur btnSaveAbs
	 */
	private void btnSaveAbs_clic() {
		if (dtcDateDeb.getDate() != null && dtcDateFin.getDate() != null) {
			// vérifie si la date de début est antérieure à la date de fin
			if (dtcDateDeb.getDate().before(dtcDateFin.getDate())) {
				int idpersonnel = (int)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 0);
				Date datedebut = dtcDateDeb.getDate();
				int idmotif = cboMotif.getSelectedIndex()+1;
				String motif = cboMotif.getSelectedItem().toString();
				Date datefin = dtcDateFin.getDate();				
				Absence absence = new Absence(idpersonnel, datedebut, datefin, idmotif, motif);
				// demande de confirmation			
				int choix = 0;
				if (Boolean.TRUE.equals(ajoutAbsEnCours)) {
					choix = confirmMsgBoxAbs("Ajouter une entrée avec ces informations ?", absence);
				}
				else if (Boolean.TRUE.equals(modifAbsEnCours)) {
					choix = confirmMsgBoxAbs("Mettre à jour l'entrée avec ces informations ?", absence);
				}			
				if (choix == 0) {
					if (modifAbsEnCours) {
						Date dateDebOriginale = (Date)tblAbsences.getModel().getValueAt(tblAbsences.getSelectedRow(), 1);
						controle.majAbsence(absence, dateDebOriginale);
						modifAbsEnCours = false;
					}
				else if (ajoutAbsEnCours) {
					controle.creeAbsence(absence);
					ajoutAbsEnCours = false;
				}
				finModifAbs();
				chargeAbsences(idpersonnel);
				}				
			}
			// si la date de fin est antérieure à la date de début
			else {
				JOptionPane.showConfirmDialog(null,
						"La date de fin ne peut pas être antérieure à la date de début",
						"Information",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE,
						null);				
			}
		}
		// si l'un des deux champs de date contient une donnée erronée ou nulle
		else {
			JOptionPane.showConfirmDialog(null,
					"Tous les champs doivent être correctement remplis",
					"Information",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null);
		}		
	}
	
	/**
	 * affichage d'une boîte de dialogue demandant confirmation sur ajout/modification/suppression d'absence
	 * @param question question posée à l'utilisateur
	 * @param absence données de l'absence concernée par la question
	 * @return choix de l'utilisateur
	 */
	private int confirmMsgBoxAbs(String question, Absence absence) {
		Object[] options = {"Confirmer", "Annuler"};
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	    String datedebut = formater.format(absence.getDatedebut());
	    String datefin = formater.format(absence.getDatefin());
		return JOptionPane.showOptionDialog(null,
				"Début : " + datedebut + "\nFin : " + datefin + "\nMotif : " + absence.getMotif() + "\n\n" + question,
                "Demande de confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
	}
	
	/**
	 * événement clic sur btnSuppAbs
	 */
	private void btnSuppAbs_clic() {
		if (tblAbsences.getSelectedRow() != -1) {
			tblAbsences.setEnabled(false);
			String question = "Supprimer cette absence ?";
			int idpersonnel = (int)tblPersonnel.getModel().getValueAt(tblPersonnel.getSelectedRow(), 0);
			Date datedebut = (Date)tblAbsences.getModel().getValueAt(tblAbsences.getSelectedRow(), 1);
		    Date datefin = (Date)tblAbsences.getModel().getValueAt(tblAbsences.getSelectedRow(), 2);		
			int idmotif = (int)tblAbsences.getModel().getValueAt(tblAbsences.getSelectedRow(), 3);
			String motif = (String)tblAbsences.getModel().getValueAt(tblAbsences.getSelectedRow(), 4);			
			Absence absence = new Absence(idpersonnel, datedebut, datefin, idmotif, motif);
			int choix = confirmMsgBoxAbs(question, absence);
			if (choix == 0) {
				controle.supprAbsence(absence);
				chargeAbsences(idpersonnel);				
			}
			tblAbsences.setEnabled(true);
		}
		else {
			infoSelection();
		}
	}
}
