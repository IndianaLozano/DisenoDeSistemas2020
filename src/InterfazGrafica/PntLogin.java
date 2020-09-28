package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PntLogin extends PanelFondo {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public PntLogin() {
		this.url="/recursos2/fondoLogin.jpg";
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SPORTsYSTEM");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 36));
		lblNewLabel.setBounds(252, 11, 235, 46);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gesti\u00F3n de Competencias Deportivas ");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblNewLabel_1.setBounds(157, 52, 407, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel_2.setBounds(85, 92, 71, 20);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo Electr\u00F3nico");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblNewLabel_3.setBounds(51, 125, 132, 14);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(51, 150, 184, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a");
		lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_4.setBounds(51, 181, 90, 14);
		add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(52, 206, 183, 20);
		add(passwordField);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(85, 238, 89, 29);
		add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("\u00BFNo est\u00E1 registrado?");
		lblNewLabel_5.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_5.setBounds(51, 340, 149, 20);
		add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(183, 337, 122, 29);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Listar Competencias Deportivas");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(427, 141, 243, 36);
		add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("\u00BFDesea visualizar las competencias deportivas?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(403, 110, 293, 14);
		add(lblNewLabel_6);

	}
}
