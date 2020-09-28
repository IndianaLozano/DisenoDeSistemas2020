package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class VerCompetencia extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public VerCompetencia() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VER COMPETENCIA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(310, 11, 158, 22);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(48, 87, 61, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(141, 86, 142, 20);
		add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Modalidad");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(48, 142, 75, 14);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(141, 141, 142, 20);
		add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Deporte");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(48, 196, 61, 14);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(141, 195, 142, 20);
		add(textField_2);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.setBounds(34, 374, 75, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(48, 248, 61, 14);
		add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(141, 247, 142, 20);
		add(textField_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(371, 84, 279, 296);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_2 = new JButton("Modificar Competencia");
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dar de Baja");
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Consultar Fixture");
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("Consultar Tabla de Posiciones");
		btnNewButton_7.setBackground(SystemColor.inactiveCaption);
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("Generar Fixture");
		btnNewButton_5.setBackground(SystemColor.inactiveCaption);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Consultar Lista de Participantes");
		btnNewButton_6.setBackground(SystemColor.inactiveCaption);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_1 = new JButton("Ver Encuentros");
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));

	}
}
