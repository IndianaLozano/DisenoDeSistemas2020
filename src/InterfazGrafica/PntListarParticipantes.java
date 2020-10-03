package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PntListarParticipantes extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PntListarParticipantes() {
		setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(333, 159, 17, 176);
		add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("COMPETENCIA <nombre-de-competencia>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(192, 30, 343, 22);
		add(lblNewLabel);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por");
		lblOrdenarPor.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblOrdenarPor.setBounds(58, 92, 76, 22);
		add(lblOrdenarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Campo"}));
		comboBox.setBounds(133, 93, 58, 20);
		add(comboBox);
		
		JCheckBox chckbxDescendente = new JCheckBox("Descendente");
		chckbxDescendente.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxDescendente.setBounds(227, 92, 108, 23);
		add(chckbxDescendente);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(59, 159, 291, 176);
		add(table);
		
		JLabel lblNombreDelParticipante = new JLabel("Nombre de participante");
		lblNombreDelParticipante.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombreDelParticipante.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelParticipante.setPreferredSize(new Dimension(111, 10));
		lblNombreDelParticipante.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNombreDelParticipante.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNombreDelParticipante.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNombreDelParticipante.setBounds(58, 137, 147, 22);
		add(lblNombreDelParticipante);
		
		JLabel lblEmail = new JLabel("Correo electr\u00F3nico");
		lblEmail.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setPreferredSize(new Dimension(111, 10));
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(203, 137, 132, 22);
		add(lblEmail);
		
		Button button = new Button("Atr\u00E1s");
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBounds(58, 383, 70, 22);
		add(button);
		
		JButton btnNewButton = new JButton("Dar de alta Participante");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(424, 92, 245, 56);
		add(btnNewButton);
		
		JButton btnEditarParticipante = new JButton("Modificar Participante");
		btnEditarParticipante.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEditarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarParticipante.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnEditarParticipante.setBounds(424, 187, 245, 56);
		add(btnEditarParticipante);
		
		JButton btnEliminarParticipante = new JButton("Dar de baja Participante");
		btnEliminarParticipante.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnEliminarParticipante.setBounds(424, 279, 245, 56);
		add(btnEliminarParticipante);

	}
	
	public static void mensaje(String error, String titulo) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, error, titulo, 
			JOptionPane.PLAIN_MESSAGE, 
			JOptionPane.ERROR_MESSAGE)==0);
			
	}
}
