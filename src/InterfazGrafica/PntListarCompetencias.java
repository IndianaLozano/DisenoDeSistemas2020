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

import DTO.BuscarCompetenciaDTO;
import DTO.CompDTO;
import DTO.CompetenciaDTO;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;

public class PntListarCompetencias extends JPanel {
	private JTextField txtListarCompetencia;
	public static JTextField tf_nombrecomp;
	
	public static JTable table = new JTable();
	public static DefaultTableModel dm = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex, int columnIndex ) {
			return false;
		}
	};

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
		txtListarCompetencia.setBounds(271, 21, 211, 20);
		add(txtListarCompetencia);
		txtListarCompetencia.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre de la competencia");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(18, 75, 176, 14);
		add(lblNewLabel);
		
		tf_nombrecomp = new JTextField();
		tf_nombrecomp.setBounds(18, 88, 168, 20);
		add(tf_nombrecomp);
		tf_nombrecomp.setColumns(10);
		tf_nombrecomp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tf_nombrecomp.setText(tf_nombrecomp.getText().toUpperCase());
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Deporte");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(18, 119, 64, 14);
		add(lblNewLabel_1);
		
		JComboBox cb_deporte = new JComboBox();
		cb_deporte.setFont(new Font("Calibri", Font.PLAIN, 15));
		cb_deporte.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Voley", "Futbol", "Basquet", "Ajedrez", "Tenis", "Handball", "Nataci\u00F3n", "Rugby"}));
		cb_deporte.setBounds(18, 134, 168, 20);
		add(cb_deporte);
		
		JLabel lblNewLabel_2 = new JLabel("Modalidad");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(18, 175, 77, 14);
		add(lblNewLabel_2);
		
		JComboBox cb_modalidad = new JComboBox();
		cb_modalidad.setFont(new Font("Calibri", Font.PLAIN, 15));
		cb_modalidad.setModel(new DefaultComboBoxModel(new String[] {"Todas", "Sistema de liga", "Sistema de eliminaci\u00F3n simple", "Sistema de eliminaci\u00F3n doble"}));
		cb_modalidad.setBounds(18, 187, 168, 20);
		add(cb_modalidad);
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(18, 227, 46, 14);
		add(lblNewLabel_3);
		
		JComboBox cb_estado = new JComboBox();
		cb_estado.setFont(new Font("Calibri", Font.PLAIN, 15));
		cb_estado.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Creada", "Planificada", "En Disputa", "Finalizada"}));
		cb_estado.setBounds(18, 239, 168, 20);
		add(cb_estado);
		
		JButton btn_atras = new JButton("Atr\u00E1s");
		btn_atras.setBackground(UIManager.getColor("Button.background"));
		btn_atras.setBounds(18, 376, 77, 23);
		add(btn_atras);
		
		JButton btn_ver = new JButton("Ver Competencia");
		btn_ver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					
					int idCompetencia = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
					
					CompDTO compDTO = new CompDTO();
					try {
						compDTO = GestorCompetencia.mostrarCompetenciaDTO(idCompetencia);
						VentanaAdmin.pntVerCompetencia.cargarDatos(compDTO);
						VentanaAdmin.pntVerCompetencia.idCompetenciaActual =  compDTO.getIdCompetencia();
						VentanaAdmin.cambiarPantalla(VentanaAdmin.pntVerCompetencia, VentanaAdmin.n_pntVerCompetencia);
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
					
				}
				else {
					VentanaAdmin.mensajeError("Seleccione una Competencia de la Tabla", "ERROR");
				}
			}
		});
		btn_ver.setBounds(377, 281, 168, 46);
		add(btn_ver);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				BuscarCompetenciaDTO buscarCompDTO= new BuscarCompetenciaDTO();
				
				buscarCompDTO.setNombre(tf_nombrecomp.getText());
				buscarCompDTO.setDeporte(cb_deporte.getSelectedItem().toString());
				buscarCompDTO.setEstado(cb_estado.getSelectedItem().toString());
				buscarCompDTO.setModalidad(cb_modalidad.getSelectedIndex());
				buscarCompDTO.setIdUsuario(2);	
				
				try {
					restaurarTabla();
					
					List<Competencia> competencias = GestorCompetencia.obtenerMisCompetenciasSegunFiltro(buscarCompDTO);
					int idCompetencia;
					String nombre;
					String deporte;
					String modalidad;
					String estado;
					for (int i = 0; i < competencias.size() ; i++) {
						idCompetencia= competencias.get(i).idCompetencia;
						nombre= competencias.get(i).nombre;
						deporte= competencias.get(i).deporte.nombre;
						modalidad= competencias.get(i).modalidad.name();
						estado= competencias.get(i).estado.name();
						
						Object[] rowData= {idCompetencia, nombre, deporte, modalidad, estado};
						dm.addRow(rowData);
						
					}
				}catch (Exception e1) {
					
					e1.printStackTrace();
				}
			
			}
			
		});
		
		
		
		btn_buscar.setBounds(52, 296, 77, 23);
		add(btn_buscar);
		
		JButton btn_altacompetencia = new JButton("Crear Nueva Competencia");
		btn_altacompetencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_altacompetencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdmin.cambiarPantalla(VentanaAdmin.pntCrearCompetencia, VentanaAdmin.n_pntCrearCompetencia);
			}
		});
		btn_altacompetencia.setBounds(485, 353, 218, 46);
		add(btn_altacompetencia);
		
		JLabel lblNewLabel_8 = new JLabel("+");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_8.setBounds(446, 353, 29, 46);
		add(lblNewLabel_8);
	
		
		dm.addColumn("idCompetencia");
		dm.addColumn("Nombre");
		dm.addColumn("Deporte");
		dm.addColumn("Modalidad");
		dm.addColumn("Estado");
		
		table.setModel(dm); //table tendra las columnas de dm que agregamos aqui arriba
		
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.doLayout();
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(211, 75, 492, 195);
		add(scrollPane_1);

	}
	
	public static void restaurarTabla() {
	 for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
          dm.removeRow(i);
      }
	}
}
