package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class PntInicio extends PanelFondo {

	/**
	 * Create the panel.
	 */
	public PntInicio() {
		this.url="/recursos2/fondoInicio3.jpg";
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SPORTsYSTEM");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 36));
		lblNewLabel.setBounds(260, 11, 235, 46);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gesti\u00F3n de Competencias Deportivas ");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblNewLabel_1.setBounds(172, 59, 407, 20);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Modificar Datos de Usuario");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(232, 109, 277, 36);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Administrar Competencias Deportivas");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(232, 156, 277, 36);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Administrar Lugares de Realizaci\u00F3n");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(232, 203, 276, 36);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Mis Competencias");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(232, 250, 277, 36);
		add(btnNewButton_3);

	}
}
