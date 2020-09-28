package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

public class ListarCompetencia extends JPanel {
	private JTextField txtListarCompetencia;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListarCompetencia() {
		setBorder(null);
		setAlignmentY(0.0f);
		setAlignmentX(0.0f);
		setBounds(new Rectangle(1, 1, 724, 421));
		setLayout(null);
		
		txtListarCompetencia = new JTextField();
		txtListarCompetencia.setBorder(null);
		txtListarCompetencia.setFocusTraversalKeysEnabled(false);
		txtListarCompetencia.setMargin(new Insets(0, 0, 0, 0));
		txtListarCompetencia.setForeground(Color.BLACK);
		txtListarCompetencia.setBackground(UIManager.getColor("Button.background"));
		txtListarCompetencia.setEditable(false);
		txtListarCompetencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtListarCompetencia.setText("LISTAR COMPETENCIAS");
		txtListarCompetencia.setBounds(271, 11, 211, 20);
		add(txtListarCompetencia);
		txtListarCompetencia.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre de la competencia");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 87, 176, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 105, 168, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Deporte");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 136, 64, 14);
		add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Voley", "Futbol", "Basquet", "Ajedrez", "Tenis", "Handball", "Nataci\u00F3n", "Rugby"}));
		comboBox.setBounds(10, 152, 168, 20);
		add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Modalidad");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 189, 77, 14);
		add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Todas", "Sistema de liga", "Sistema de eliminaci\u00F3n simple", "Sistema de eliminaci\u00F3n doble"}));
		comboBox_1.setBounds(10, 203, 168, 20);
		add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 239, 46, 14);
		add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Creada", "Planificada", "En Disputa", "Finalizada"}));
		comboBox_2.setBounds(10, 252, 168, 20);
		add(comboBox_2);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre", "Modalidad", "Deporte", "Estado"
			}
		));
		table.setRowHeight(25);
		table.setBounds(new Rectangle(1, 2, 1, 1));
		table.setBounds(225, 103, 466, 175);
		add(table);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(225, 81, 116, 25);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Modalidad");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(458, 81, 116, 25);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Deporte");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(339, 81, 121, 20);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Estado");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(570, 84, 121, 19);
		add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(10, 387, 77, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver");
		btnNewButton_1.setBounds(650, 387, 64, 23);
		add(btnNewButton_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(690, 105, 17, 173);
		add(scrollBar);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setBounds(52, 296, 77, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dar de Alta Competencia");
		btnNewButton_3.setBounds(306, 323, 176, 46);
		add(btnNewButton_3);
		
		JLabel lblNewLabel_8 = new JLabel("+");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_8.setBounds(278, 323, 29, 46);
		add(lblNewLabel_8);

	}
}
