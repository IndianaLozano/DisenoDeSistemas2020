package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Button;
import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class PntCrearCompetencia extends JPanel {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PntCrearCompetencia() {
		setPreferredSize(new Dimension(730, 460));
		setLayout(null);
		
		Button button_2_1 = new Button("-");
		button_2_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		button_2_1.setBounds(263, 214, 17, 14);
		add(button_2_1);
		
		JLabel lblCrearNuevaCompetencia = new JLabel("CREAR NUEVA COMPETENCIA DEPORTIVA");
		lblCrearNuevaCompetencia.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCrearNuevaCompetencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearNuevaCompetencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrearNuevaCompetencia.setBounds(202, 24, 349, 14);
		add(lblCrearNuevaCompetencia);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la competencia(*)");
		lblNombreDeLa.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNombreDeLa.setBounds(42, 80, 221, 14);
		add(lblNombreDeLa);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(42, 97, 221, 24);
		add(textField);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(346, 176, 339, 192);
		add(textArea);
		
		JComboBox deporteAsociado = new JComboBox();
		deporteAsociado.setToolTipText("");
		deporteAsociado.setName("Deporte");
		deporteAsociado.setBounds(346, 97, 130, 24);
		add(deporteAsociado);
		
		JLabel lblDeporteAsociado = new JLabel("Deporte(*)");
		lblDeporteAsociado.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDeporteAsociado.setBounds(346, 80, 130, 14);
		add(lblDeporteAsociado);
		
		JLabel lblModalidad = new JLabel("Modalidad(*)");
		lblModalidad.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblModalidad.setBounds(542, 80, 82, 14);
		add(lblModalidad);
		
		JComboBox deporteAsociado_1 = new JComboBox();
		deporteAsociado_1.setToolTipText("");
		deporteAsociado_1.setName("Modalidad\r\n");
		deporteAsociado_1.setBounds(542, 97, 143, 24);
		add(deporteAsociado_1);
		
		JLabel lblModalidad_1 = new JLabel("Lugares de realizaci\u00F3n(*)");
		lblModalidad_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblModalidad_1.setBounds(42, 160, 221, 14);
		add(lblModalidad_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lugar"}));
		comboBox.setBounds(42, 177, 150, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Disponibilidad"}));
		comboBox_1.setBounds(191, 177, 64, 20);
		add(comboBox_1);
		
		Button button_2 = new Button("+");
		button_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		button_2.setBounds(261, 175, 23, 22);
		add(button_2);
		
		Button button = new Button("Atr\u00E1s");
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBounds(66, 391, 70, 22);
		add(button);
		
		Button button_1 = new Button("Siguiente");
		button_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		button_1.setBounds(601, 391, 70, 22);
		add(button_1);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(0).setMinWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setMinWidth(0);
		table.setRowHeight(25);
		table.setBounds(new Rectangle(1, 1, 1, 1));
		table.setBounds(42, 208, 246, 160);
		add(table);
		
		JLabel lblReglamento = new JLabel("Reglamento");
		lblReglamento.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblReglamento.setBounds(346, 160, 221, 14);
		add(lblReglamento);

	}
	
	public static void mensaje(String error, String titulo) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, error, titulo, 
			JOptionPane.PLAIN_MESSAGE, 
			JOptionPane.ERROR_MESSAGE)==0);
	}
}
