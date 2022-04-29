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

public class Gestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion frame = new Gestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gestion() {
		setTitle("MediaTek86 - Gestion du personnel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 725);
		contentPane = new JPanel();
		contentPane.setLocation(-495, -538);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlPersonnel = new JPanel();
		pnlPersonnel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlPersonnel.setBounds(10, 29, 489, 390);
		contentPane.add(pnlPersonnel);
		pnlPersonnel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 467, 334);
		pnlPersonnel.add(list);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(10, 356, 95, 23);
		pnlPersonnel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(111, 356, 95, 23);
		pnlPersonnel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(212, 356, 95, 23);
		pnlPersonnel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("G\u00E9rer les absences");
		btnNewButton_3.setBounds(328, 357, 149, 23);
		pnlPersonnel.add(btnNewButton_3);
		
		JPanel pnlAbsence = new JPanel();
		pnlAbsence.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlAbsence.setBounds(533, 29, 389, 461);
		contentPane.add(pnlAbsence);
		pnlAbsence.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Ajouter");
		btnNewButton_4.setBounds(43, 428, 95, 23);
		pnlAbsence.add(btnNewButton_4);
		
		JButton btnNewButton_1_1 = new JButton("Modifier");
		btnNewButton_1_1.setBounds(145, 428, 95, 23);
		pnlAbsence.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Supprimer");
		btnNewButton_2_1.setBounds(246, 428, 95, 23);
		pnlAbsence.add(btnNewButton_2_1);
		
		JList list_1 = new JList();
		list_1.setBounds(10, 11, 367, 405);
		pnlAbsence.add(list_1);
		
		JPanel pnlModifPersonnel = new JPanel();
		pnlModifPersonnel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlModifPersonnel.setBounds(10, 465, 489, 206);
		contentPane.add(pnlModifPersonnel);
		pnlModifPersonnel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nom");
		lblNewLabel_4.setBounds(10, 32, 56, 14);
		pnlModifPersonnel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pr\u00E9nom");
		lblNewLabel_5.setBounds(10, 62, 46, 14);
		pnlModifPersonnel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Service");
		lblNewLabel_6.setBounds(10, 95, 46, 14);
		pnlModifPersonnel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("T\u00E9l\u00E9phone");
		lblNewLabel_7.setBounds(10, 135, 85, 14);
		pnlModifPersonnel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("E-mail");
		lblNewLabel_8.setBounds(10, 170, 46, 14);
		pnlModifPersonnel.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(113, 29, 226, 20);
		pnlModifPersonnel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(113, 59, 226, 20);
		pnlModifPersonnel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(113, 132, 226, 20);
		pnlModifPersonnel.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 91, 226, 22);
		pnlModifPersonnel.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(113, 167, 226, 20);
		pnlModifPersonnel.add(textField_3);
		
		JButton btnNewButton_5 = new JButton("Enregistrer");
		btnNewButton_5.setBounds(376, 131, 101, 23);
		pnlModifPersonnel.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Annuler");
		btnNewButton_5_1.setBounds(376, 166, 101, 23);
		pnlModifPersonnel.add(btnNewButton_5_1);
		
		JPanel pnlModifAbsence = new JPanel();
		pnlModifAbsence.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlModifAbsence.setBounds(533, 538, 389, 133);
		contentPane.add(pnlModifAbsence);
		pnlModifAbsence.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Motif");
		lblNewLabel_4_1.setBounds(10, 28, 56, 14);
		pnlModifAbsence.add(lblNewLabel_4_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(108, 24, 142, 22);
		pnlModifAbsence.add(comboBox_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Date de d\u00E9but");
		lblNewLabel_4_2.setBounds(10, 67, 90, 14);
		pnlModifAbsence.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Date de fin");
		lblNewLabel_4_2_1.setBounds(10, 97, 75, 14);
		pnlModifAbsence.add(lblNewLabel_4_2_1);
		
		JButton btnNewButton_5_2 = new JButton("Enregistrer");
		btnNewButton_5_2.setBounds(276, 63, 101, 23);
		pnlModifAbsence.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_1_1 = new JButton("Annuler");
		btnNewButton_5_1_1.setBounds(276, 93, 101, 23);
		pnlModifAbsence.add(btnNewButton_5_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(108, 61, 142, 20);
		pnlModifAbsence.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(108, 97, 142, 20);
		pnlModifAbsence.add(dateChooser_1);
		
		JLabel lblNewLabel = new JLabel("Personnel");
		lblNewLabel.setBounds(10, 11, 99, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Absences");
		lblNewLabel_1.setBounds(551, 11, 371, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter une personne");
		lblNewLabel_2.setBounds(10, 445, 149, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ajouter une absence");
		lblNewLabel_3.setBounds(551, 516, 142, 14);
		contentPane.add(lblNewLabel_3);
	}
}
