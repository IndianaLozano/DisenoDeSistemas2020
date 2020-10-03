package InterfazGrafica;

import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Button;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButtonMenuItem;

public class PntCrearLiga extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PntCrearLiga() {
		setLayout(null);
		
		Label crearNuevaCompetenciaDeportiva = new Label();
		crearNuevaCompetenciaDeportiva.setText(" CREAR NUEVA COMPETENCIA DEPORTIVA");
		crearNuevaCompetenciaDeportiva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crearNuevaCompetenciaDeportiva.setBounds(188, 20, 401, 24);
		add(crearNuevaCompetenciaDeportiva);
		
		Label crearNuevaCompetenciaDeportiva_1 = new Label();
		crearNuevaCompetenciaDeportiva_1.setText(" SISTEMA DE LIGA: FORMA DE PUNTUACI\u00D3N");
		crearNuevaCompetenciaDeportiva_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		crearNuevaCompetenciaDeportiva_1.setBounds(199, 50, 358, 24);
		add(crearNuevaCompetenciaDeportiva_1);
		
		JLabel crearNuevaCompetenciaPuntuacionLiga_1_1_2 = new JLabel();
		crearNuevaCompetenciaPuntuacionLiga_1_1_2.setText(" PUNTOS POR PARTIDO GANADO(*)");
		crearNuevaCompetenciaPuntuacionLiga_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		crearNuevaCompetenciaPuntuacionLiga_1_1_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		crearNuevaCompetenciaPuntuacionLiga_1_1_2.setBounds(73, 129, 207, 19);
		add(crearNuevaCompetenciaPuntuacionLiga_1_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(285, 128, 49, 19);
		add(textField);
		
		JCheckBox rdbtnNewRadioButton = new JCheckBox("EMPATE PERMITIDO");
		rdbtnNewRadioButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(73, 197, 157, 23);
		add(rdbtnNewRadioButton);
		
		JLabel crearNuevaCompetenciaPuntuacionLiga_1_1 = new JLabel();
		crearNuevaCompetenciaPuntuacionLiga_1_1.setText(" PUNTOS POR PARTIDO EMPATADO");
		crearNuevaCompetenciaPuntuacionLiga_1_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		crearNuevaCompetenciaPuntuacionLiga_1_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		crearNuevaCompetenciaPuntuacionLiga_1_1.setBounds(73, 221, 207, 19);
		add(crearNuevaCompetenciaPuntuacionLiga_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(285, 220, 49, 19);
		add(textField_1);
		
		JLabel crearNuevaCompetenciaPuntuacionLiga_1_1_1 = new JLabel();
		crearNuevaCompetenciaPuntuacionLiga_1_1_1.setText(" PUNTOS POR PRESENTARSE(*)");
		crearNuevaCompetenciaPuntuacionLiga_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		crearNuevaCompetenciaPuntuacionLiga_1_1_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		crearNuevaCompetenciaPuntuacionLiga_1_1_1.setBounds(73, 293, 207, 19);
		add(crearNuevaCompetenciaPuntuacionLiga_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(254, 292, 49, 19);
		add(textField_2);
		
		Button button = new Button("Atr\u00E1s");
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBounds(62, 372, 70, 22);
		add(button);
		
		Button button_1 = new Button("Siguiente");
		button_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		button_1.setBounds(590, 372, 70, 22);
		add(button_1);
		
		JLabel crearNuevaCompetenciaPuntuacionLiga_1 = new JLabel();
		crearNuevaCompetenciaPuntuacionLiga_1.setText(" FORMA DE PUNTUACI\u00D3N:");
		crearNuevaCompetenciaPuntuacionLiga_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		crearNuevaCompetenciaPuntuacionLiga_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		crearNuevaCompetenciaPuntuacionLiga_1.setBounds(402, 128, 287, 19);
		add(crearNuevaCompetenciaPuntuacionLiga_1);
		
		JRadioButton chckbxNewCheckBox_1 = new JRadioButton("SETS");
		chckbxNewCheckBox_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		chckbxNewCheckBox_1.setBounds(413, 150, 62, 23);
		add(chckbxNewCheckBox_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Cantidad de sets"}));
		comboBox_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		comboBox_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboBox_1.setAlignmentX(0.0f);
		comboBox_1.setBounds(481, 151, 139, 20);
		add(comboBox_1);
		
		JRadioButton chckbxPuntuacin_1_1_1 = new JRadioButton("PUNTUACI\u00D3N");
		chckbxPuntuacin_1_1_1.setBounds(413, 194, 127, 23);
		add(chckbxPuntuacin_1_1_1);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"Tantos ganados por ausencia del rival"}));
		comboBox_1_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		comboBox_1_1_1_1.setBounds(413, 218, 247, 19);
		add(comboBox_1_1_1_1);
		
		JRadioButton chckbxNewCheckBox_1_1 = new JRadioButton("RESULTADO FINAL");
		chckbxNewCheckBox_1_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		chckbxNewCheckBox_1_1.setBounds(413, 254, 176, 23);
		add(chckbxNewCheckBox_1_1);

	}
	public static void mensaje(String error, String titulo) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, error, titulo, 
			JOptionPane.PLAIN_MESSAGE, 
			JOptionPane.ERROR_MESSAGE)==0);
			
	}
}
