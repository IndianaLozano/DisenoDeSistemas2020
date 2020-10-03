package InterfazGrafica;

import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JCheckBox;
import java.awt.ComponentOrientation;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.Button;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class PntCrearEliminatoria extends JPanel {

	/**
	 * Create the panel.
	 */
	public PntCrearEliminatoria() {
		setLayout(null);
		
		Label crearNuevaCompetenciaDeportiva = new Label();
		crearNuevaCompetenciaDeportiva.setText(" CREAR NUEVA COMPETENCIA DEPORTIVA");
		crearNuevaCompetenciaDeportiva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crearNuevaCompetenciaDeportiva.setBounds(169, 22, 401, 24);
		add(crearNuevaCompetenciaDeportiva);
		
		Label crearNuevaCompetenciaDeportiva_1 = new Label();
		crearNuevaCompetenciaDeportiva_1.setText(" SISTEMA DE ELIMINATORIAS: FORMA DE PUNTUACI\u00D3N");
		crearNuevaCompetenciaDeportiva_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		crearNuevaCompetenciaDeportiva_1.setBounds(149, 52, 451, 24);
		add(crearNuevaCompetenciaDeportiva_1);
		
		Button button = new Button("Atr\u00E1s");
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBounds(65, 388, 70, 22);
		add(button);
		
		Button button_1 = new Button("Siguiente");
		button_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		button_1.setBounds(594, 388, 70, 22);
		add(button_1);
		
		JRadioButton chckbxPuntuacin_1_1_1 = new JRadioButton("RESULTADO FINAL");
		chckbxPuntuacin_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxPuntuacin_1_1_1.setBounds(189, 271, 140, 25);
		add(chckbxPuntuacin_1_1_1);
		
		JRadioButton chckbxPuntuacin_1_1_2 = new JRadioButton("PUNTUACI\u00D3N");
		chckbxPuntuacin_1_1_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxPuntuacin_1_1_2.setBounds(189, 211, 103, 25);
		add(chckbxPuntuacin_1_1_2);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"Tantos ganados por ausencia del rival"}));
		comboBox_1_1_1_1.setBounds(297, 213, 245, 20);
		add(comboBox_1_1_1_1);
		
		JRadioButton chckbxNewCheckBox_1 = new JRadioButton("SETS");
		chckbxNewCheckBox_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxNewCheckBox_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		chckbxNewCheckBox_1.setBounds(189, 151, 51, 25);
		add(chckbxNewCheckBox_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Cantidad de sets"}));
		comboBox_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboBox_1.setAlignmentX(0.0f);
		comboBox_1.setBounds(245, 153, 124, 20);
		add(comboBox_1);

	}
	
	public static void mensaje(String error, String titulo) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, error, titulo, 
			JOptionPane.PLAIN_MESSAGE, 
			JOptionPane.ERROR_MESSAGE)==0);
			
	}
}
