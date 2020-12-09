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

public class PantallaMostrarFixtureCU019 extends JPanel {
	private JTable table;

	public PantallaMostrarFixtureCU019() {
		setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(650, 129, 17, 176);
		add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("MOSTRAR FIXTURE DE LA COMPETENCIA <nombre-de-competencia>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(69, 29, 592, 22);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fecha actual"}));
		comboBox.setBounds(317, 76, 99, 20);
		add(comboBox);
		
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
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(61, 129, 607, 176);
		add(table);
		
		JLabel lblNombreDelParticipante = new JLabel("Encuentro");
		lblNombreDelParticipante.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombreDelParticipante.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelParticipante.setPreferredSize(new Dimension(111, 10));
		lblNombreDelParticipante.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNombreDelParticipante.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNombreDelParticipante.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNombreDelParticipante.setBounds(61, 107, 203, 22);
		add(lblNombreDelParticipante);
		
		JLabel lblEmail = new JLabel("Disputado por");
		lblEmail.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setPreferredSize(new Dimension(111, 10));
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(263, 107, 203, 22);
		add(lblEmail);
		
		Button button = new Button("Atr\u00E1s");
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBounds(61, 378, 70, 22);
		add(button);
		
		JButton btnNewButton = new JButton("Gestionar resultados del fixture");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(242, 316, 245, 56);
		add(btnNewButton);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setPreferredSize(new Dimension(111, 10));
		lblResultado.setHorizontalTextPosition(SwingConstants.CENTER);
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblResultado.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblResultado.setAlignmentX(0.5f);
		lblResultado.setBounds(465, 107, 187, 22);
		add(lblResultado);

	}
	
	public static void mensaje(String error, String titulo) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, error, titulo, 
			JOptionPane.PLAIN_MESSAGE, 
			JOptionPane.WARNING_MESSAGE)==0);
			
	}
}
