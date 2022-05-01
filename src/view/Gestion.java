package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

/**
 * classe permettant l'affichage de la fenêtre principale
 * @author Claire
 *
 */
public class Gestion extends JFrame {
	/**
	 * création de la fenêtre
	 */
	public Gestion() {
		setTitle("MediaTek86 - Gestion du personnel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 725);
		JPanel contentPane = new JPanel();
		contentPane.setLocation(-495, -538);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlPersonnel = new JPanel();
		pnlPersonnel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlPersonnel.setBounds(10, 29, 489, 390);
		contentPane.add(pnlPersonnel);
		pnlPersonnel.setLayout(null);
		
		JList lstPersonnel = new JList();
		lstPersonnel.setBounds(10, 11, 467, 334);
		pnlPersonnel.add(lstPersonnel);
		
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
		btnGerAbs.setBounds(328, 357, 149, 23);
		pnlPersonnel.add(btnGerAbs);
		
		JPanel pnlAbsence = new JPanel();
		pnlAbsence.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlAbsence.setBounds(533, 29, 389, 461);
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
		
		JList lstAbsences = new JList();
		lstAbsences.setBounds(10, 11, 367, 405);
		pnlAbsence.add(lstAbsences);
		
		JPanel pnlModifPersonnel = new JPanel();
		pnlModifPersonnel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlModifPersonnel.setBounds(10, 465, 489, 206);
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
		txtNom.setBounds(113, 29, 226, 20);
		pnlModifPersonnel.add(txtNom);
		txtNom.setColumns(10);
		
		JTextField txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(113, 59, 226, 20);
		pnlModifPersonnel.add(txtPrenom);
		
		JTextField txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(113, 132, 226, 20);
		pnlModifPersonnel.add(txtTel);
		
		JComboBox cboService = new JComboBox();
		cboService.setBounds(113, 91, 226, 22);
		pnlModifPersonnel.add(cboService);
		
		JTextField txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(113, 167, 226, 20);
		pnlModifPersonnel.add(txtMail);
		
		JButton btnSavePers = new JButton("Enregistrer");
		btnSavePers.setBounds(376, 131, 101, 23);
		pnlModifPersonnel.add(btnSavePers);
		
		JButton btnCancelPers = new JButton("Annuler");
		btnCancelPers.setBounds(376, 166, 101, 23);
		pnlModifPersonnel.add(btnCancelPers);
		
		JPanel pnlModifAbsence = new JPanel();
		pnlModifAbsence.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlModifAbsence.setBounds(533, 538, 389, 133);
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
		lblTitre2.setBounds(533, 11, 371, 14);
		contentPane.add(lblTitre2);
		
		JLabel lblTitre3 = new JLabel("Ajouter une personne");
		lblTitre3.setBounds(10, 445, 149, 14);
		contentPane.add(lblTitre3);
		
		JLabel lblTitre4 = new JLabel("Ajouter une absence");
		lblTitre4.setBounds(533, 519, 142, 14);
		contentPane.add(lblTitre4);
	}
}
