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

import Entidades.Deporte;
import Gestores.GestorDeCompetencia;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PntCrearCompetencia extends JPanel {
	private JTextField tf_nombre_comp;
	
	public static JTable table= new JTable();
	public static DefaultTableModel dm= new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int columnIndex ) {return false;}};
	private Button btn_mas;
	public static JComboBox cb_deporte = new JComboBox();


	/**
	 * Create the panel.
	 * 
	 */
	public PntCrearCompetencia() {
		setPreferredSize(new Dimension(730, 460));
		setLayout(null);
		
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
		
		tf_nombre_comp = new JTextField();
		tf_nombre_comp.setColumns(10);
		tf_nombre_comp.setBounds(42, 97, 221, 24);
		add(tf_nombre_comp);
		
		JTextArea ta_reglamento = new JTextArea();
		ta_reglamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		ta_reglamento.setBounds(346, 176, 339, 209);
		add(ta_reglamento);
		
		
		cb_deporte.setToolTipText("");
		cb_deporte.setName("Deporte");
		cb_deporte.setBounds(346, 97, 130, 24);
		add(cb_deporte);
		
		JLabel lblDeporteAsociado = new JLabel("Deporte(*)");
		lblDeporteAsociado.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDeporteAsociado.setBounds(346, 80, 130, 14);
		add(lblDeporteAsociado);
		
		JLabel lblModalidad = new JLabel("Modalidad(*)");
		lblModalidad.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblModalidad.setBounds(542, 80, 82, 14);
		add(lblModalidad);
		
		JComboBox cb_modalidad = new JComboBox();
		cb_modalidad.setToolTipText("");
		cb_modalidad.setName("Modalidad\r\n");
		cb_modalidad.setBounds(542, 97, 143, 24);
		add(cb_modalidad);
		
		JLabel lblModalidad_1 = new JLabel("Lugares de realizaci\u00F3n(*)");
		lblModalidad_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblModalidad_1.setBounds(42, 160, 221, 14);
		add(lblModalidad_1);
		
		JComboBox cb_lugar = new JComboBox();
		cb_lugar.setModel(new DefaultComboBoxModel(new String[] {"Lugar"}));
		cb_lugar.setBounds(42, 177, 150, 20);
		add(cb_lugar);
		
		JComboBox cb_disponibilidad = new JComboBox();
		cb_disponibilidad.setModel(new DefaultComboBoxModel(new String[] {"Disponibilidad"}));
		cb_disponibilidad.setBounds(191, 177, 64, 20);
		add(cb_disponibilidad);
		
		btn_mas = new Button("+");
		btn_mas.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_mas.setBounds(261, 175, 23, 22);
		add(btn_mas);
		
		Button btn_atras = new Button("Atr\u00E1s");
		btn_atras.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_atras.setBounds(42, 391, 94, 22);
		add(btn_atras);
		
		Button btn_sig = new Button("Siguiente");
		btn_sig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_sig.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_sig.setBounds(591, 391, 94, 22);
		add(btn_sig);
		
		JLabel lblReglamento = new JLabel("Reglamento");
		lblReglamento.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblReglamento.setBounds(346, 160, 221, 14);
		add(lblReglamento);
		
		dm.addColumn("Lugar");
		dm.addColumn("Disp");
		
		table.setModel(dm);
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(41, 208, 286, 177);
		add(scrollPane_1);
		
		Button btn_menos = new Button("-");
		btn_menos.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_menos.setBounds(290, 176, 23, 22);
		add(btn_menos);
		
		try {
			llenarCBDeporte();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public static void llenarCBDeporte () throws Exception {
		
		List<Deporte> deportes = GestorDeCompetencia.obtenerDeportes();
		int tamList = deportes.size();
		int id;
		String nombres_deportes;
		
		for(int i=0; i<tamList; i++) {
			//se usa el get para listas 
			id= deportes.get(i).idDeporte;
			nombres_deportes= deportes.get(i).nombre;
			
			cb_deporte.addItem(nombres_deportes);
				
			}
		
		
	}
	
	
}
