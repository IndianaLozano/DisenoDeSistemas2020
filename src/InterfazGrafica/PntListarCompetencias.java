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

import Entidades.Competencia;
import Entidades.Usuario;
import Gestores.GestorCompetencia;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PntListarCompetencias extends JPanel {
	private JTextField txtListarCompetencia;
	public static JTextField tf_nombrecomp;
	private JTable table_listarcomps;

	/**
	 * Create the panel.
	 */
	public PntListarCompetencias() {
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
		
		tf_nombrecomp = new JTextField();
		tf_nombrecomp.setBounds(10, 105, 168, 20);
		add(tf_nombrecomp);
		tf_nombrecomp.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Deporte");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 136, 64, 14);
		add(lblNewLabel_1);
		
		JComboBox cb_deporte = new JComboBox();
		cb_deporte.setFont(new Font("Calibri", Font.PLAIN, 15));
		cb_deporte.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Voley", "Futbol", "Basquet", "Ajedrez", "Tenis", "Handball", "Nataci\u00F3n", "Rugby"}));
		cb_deporte.setBounds(10, 152, 168, 20);
		add(cb_deporte);
		
		JLabel lblNewLabel_2 = new JLabel("Modalidad");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 189, 77, 14);
		add(lblNewLabel_2);
		
		JComboBox cb_modalidad = new JComboBox();
		cb_modalidad.setFont(new Font("Calibri", Font.PLAIN, 15));
		cb_modalidad.setModel(new DefaultComboBoxModel(new String[] {"Todas", "Sistema de liga", "Sistema de eliminaci\u00F3n simple", "Sistema de eliminaci\u00F3n doble"}));
		cb_modalidad.setBounds(10, 203, 168, 20);
		add(cb_modalidad);
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 239, 46, 14);
		add(lblNewLabel_3);
		
		JComboBox cb_estado = new JComboBox();
		cb_estado.setFont(new Font("Calibri", Font.PLAIN, 15));
		cb_estado.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Creada", "Planificada", "En Disputa", "Finalizada"}));
		cb_estado.setBounds(10, 252, 168, 20);
		add(cb_estado);
		
		table_listarcomps = new JTable();
		table_listarcomps.setBackground(Color.WHITE);
		table_listarcomps.setForeground(Color.BLACK);
		table_listarcomps.setModel(new DefaultTableModel(
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
		table_listarcomps.setRowHeight(25);
		table_listarcomps.setBounds(new Rectangle(1, 2, 1, 1));
		table_listarcomps.setBounds(225, 103, 466, 175);
		add(table_listarcomps);
		
		JLabel lbl_nombre = new JLabel("Nombre");
		lbl_nombre.setForeground(Color.BLACK);
		lbl_nombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_nombre.setBackground(Color.WHITE);
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre.setBounds(225, 81, 116, 25);
		add(lbl_nombre);
		
		JLabel lbl_modalidad = new JLabel("Modalidad");
		lbl_modalidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_modalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_modalidad.setBounds(458, 81, 116, 25);
		add(lbl_modalidad);
		
		JLabel lbl_deporte = new JLabel("Deporte");
		lbl_deporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_deporte.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_deporte.setBounds(339, 81, 121, 20);
		add(lbl_deporte);
		
		JLabel lbl_estado = new JLabel("Estado");
		lbl_estado.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_estado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_estado.setBounds(570, 84, 121, 19);
		add(lbl_estado);
		
		JButton btn_atras = new JButton("Atr\u00E1s");
		btn_atras.setBackground(UIManager.getColor("Button.background"));
		btn_atras.setBounds(10, 387, 77, 23);
		add(btn_atras);
		
		JButton btn_ver = new JButton("Ver");
		btn_ver.setBounds(650, 387, 64, 23);
		add(btn_ver);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(690, 105, 17, 173);
		add(scrollBar);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//int idUsuario
				String nombreComp = tf_nombrecomp.getText();
				String deporte = cb_deporte.getSelectedItem().toString();
				int idDeporte = GestorCompetencia.obtenerIdDeporte(deporte);
				String modalidad = cb_modalidad.getSelectedItem().toString();
				String estado = cb_estado.getSelectedItem().toString();	
				
				try {
					//List<Competencia> competencias = GestorCompetencia.obtenerMisCompetenciasSegunFiltro(2, nombreComp, deporte, modalidad, estado);
					//for (int i = 0; i < competencias.size() ; i++) {
						
						
						
					//}
				}catch (Exception e1) {
					
					e1.printStackTrace();
				}
			
			}
			
		});
		
		
		
		/*public static void restaurarTabla() {
			 for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
		           dm.removeRow(i);
		       }
		}
		*/
		
		btn_buscar.setBounds(52, 296, 77, 23);
		add(btn_buscar);
		
		JButton btn_altacompetencia = new JButton("Dar de Alta Competencia");
		btn_altacompetencia.setBounds(306, 323, 176, 46);
		add(btn_altacompetencia);
		
		JLabel lblNewLabel_8 = new JLabel("+");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_8.setBounds(278, 323, 29, 46);
		add(lblNewLabel_8);

	}
}
