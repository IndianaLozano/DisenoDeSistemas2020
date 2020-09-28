package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class VerEncuentros extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VerEncuentros() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENCUENTROS:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(221, 11, 125, 28);
		add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setRowHeight(25);
		table.setBounds(new Rectangle(1, 1, 1, 1));
		table.setBounds(109, 98, 589, 275);
		add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(109, 71, 118, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hora");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(225, 72, 118, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Lugar");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(342, 73, 118, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contrincante 1");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(456, 72, 118, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contrincante 2");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(579, 73, 119, 14);
		add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.setBounds(10, 390, 75, 23);
		add(btnNewButton);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(697, 98, 17, 275);
		add(scrollBar);
		
		JLabel lblNewLabel_6 = new JLabel("<Nombre de la Competencia>");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(356, 11, 289, 28);
		add(lblNewLabel_6);

	}
}
