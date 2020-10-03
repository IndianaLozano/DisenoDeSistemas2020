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
import javax.swing.SwingConstants;

public class PantallaCrearNuevaCompetenciaDeportivaExito extends JPanel {

	/**
	 * Create the panel.
	 */
	public PantallaCrearNuevaCompetenciaDeportivaExito() {
		setLayout(null);
		
		Button button_1 = new Button("Siguiente");
		button_1.setBounds(590, 372, 70, 22);
		button_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(button_1);
		
		JLabel lblHaCreadoExitosamente = new JLabel("\u00A1HA CREADO EXITOSAMENTE UNA NUEVA COMPETENCIA DEPORTIVA!");
		lblHaCreadoExitosamente.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaCreadoExitosamente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHaCreadoExitosamente.setBounds(70, 98, 590, 143);
		add(lblHaCreadoExitosamente);

	}
	
	public static void mensaje(String error, String titulo) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, error, titulo, 
			JOptionPane.PLAIN_MESSAGE, 
			JOptionPane.INFORMATION_MESSAGE)==0);
			
	}
}
