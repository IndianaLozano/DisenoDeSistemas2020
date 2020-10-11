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

import Entidades.Competencia;
import Entidades.Deporte;
import Entidades.LugarDeRealizacion;
import Entidades.Modalidad;
import Gestores.GestorCompetencia;
import Gestores.GestorCompetencia;
import Gestores.GestorLugaresDeRealizacion;
import javafx.scene.control.RadioButton;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PntCrearCompetencia extends JPanel {
	
	
	public static JTextField tf_nombre_comp;
	
	/* public static permite  acceso a metodos y variables de clase sin  necesidad de instanciar un objeto de dicha clase,
	 *  permitiendo inicializacion de forma comoda y durante la carga de clase
	 */
	public static JTable table = new JTable();
	public static DefaultTableModel dm = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex, int columnIndex ) {
			return false;
		}
	};
	
	private Button btn_mas;
	public static JComboBox cb_deporte = new JComboBox();
	public static JComboBox cb_modalidad = new JComboBox();
	public static JComboBox cb_lugar = new JComboBox();
	public static JComboBox cb_disponibilidad = new JComboBox();
	
	public static List<Integer> idLugares = new ArrayList<Integer>(); 

	// Creacion del panel
	
	public PntCrearCompetencia() {
		setPreferredSize(new Dimension(730, 460));
		setLayout(null);
		
		
		JLabel lblCrearNuevaCompetencia = new JLabel("CREAR NUEVA COMPETENCIA DEPORTIVA");
		lblCrearNuevaCompetencia.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCrearNuevaCompetencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearNuevaCompetencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrearNuevaCompetencia.setBounds(202, 24, 349, 14);
		add(lblCrearNuevaCompetencia);
		
		JLabel lblNombreCompetencia = new JLabel("Nombre de la competencia(*)");
		lblNombreCompetencia.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNombreCompetencia.setBounds(42, 80, 221, 14);
		add(lblNombreCompetencia);
		
		tf_nombre_comp = new JTextField();
		tf_nombre_comp.setColumns(10);
		tf_nombre_comp.setBounds(42, 97, 221, 24);
		add(tf_nombre_comp);
		
		JTextArea ta_reglamento = new JTextArea();
		ta_reglamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		ta_reglamento.setBounds(346, 176, 339, 209);
		add(ta_reglamento);
		
		
		cb_deporte.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//ItemEvent= clase predefinida de Java que identifica  evento o  hecho (click, seleccion, etc.)
				if(arg0.getStateChange()==ItemEvent.SELECTED) {
					int indiceSeleccionado = cb_deporte.getSelectedIndex();
					int idDeporteSeleccionado = devolverIdDeporte(indiceSeleccionado);
					try {
						cb_lugar.removeAllItems();
						llenarCBLugar(idDeporteSeleccionado);
						deleteAllRows(dm);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}		
			}
		});
		cb_deporte.setToolTipText("");
		cb_deporte.setName("Deporte");
		cb_deporte.setBounds(308, 97, 130, 24);
		add(cb_deporte);
		
		JLabel lblDeporteAsociado = new JLabel("Deporte(*)");
		lblDeporteAsociado.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDeporteAsociado.setBounds(308, 80, 130, 14);
		add(lblDeporteAsociado);
		
		JLabel lblModalidad = new JLabel("Modalidad(*)");
		lblModalidad.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblModalidad.setBounds(484, 80, 108, 14);
		add(lblModalidad);
		
		cb_modalidad.setToolTipText("");
		cb_modalidad.setName("Modalidad\r\n");
		cb_modalidad.setBounds(484, 97, 201, 24);
		add(cb_modalidad);
		
		JLabel lblModalidad_1 = new JLabel("Lugares de realizaci\u00F3n(*)");
		lblModalidad_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblModalidad_1.setBounds(42, 132, 221, 14);
		add(lblModalidad_1);
		
		cb_lugar.setBounds(42, 177, 161, 20);
		add(cb_lugar);
		
		cb_disponibilidad.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cb_disponibilidad.setBounds(201, 177, 68, 20);
		add(cb_disponibilidad);
		
		btn_mas = new Button("+");
		//Escuchador de accion
		btn_mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Declaro nombreLugar y disp
				String nombreLugar= cb_lugar.getSelectedItem().toString(); 
				
				//convierto el item del cb_disponibilidad a String y luego a int
				int disp= Integer.parseInt(cb_disponibilidad.getSelectedItem().toString()); 
				int idLugar= idLugares.get(cb_lugar.getSelectedIndex());
				
				// Object es la clase padre de todas las clases. fila tiene un atributo String y un int -> declarar fila como Object
				Object[] fila = {nombreLugar, disp, idLugar}; 
				
				int nombreRepetido = 0;
				if (table.getRowCount() == 0) { //si la tabla todavia no tiene ninguna fila agregada, agrega fila nueva
					dm.addRow(fila);
				}
				else { 

					int cantRowsInTable = table.getRowCount();
					
					for (int i = 0; i < cantRowsInTable; i++) { //recorro todas las filas de la tabla existente
						//fila[0] == nombreLugar
						if(fila[0] == table.getValueAt(i, 0)){
							nombreRepetido++;
						}
					}
					
					if (nombreRepetido > 0) {
						return;
					}
					else {
						dm.addRow(fila);
					}
				}
				
			}
		});
		btn_mas.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_mas.setBounds(275, 174, 23, 22);
		add(btn_mas);
		
		Button btn_atras = new Button("Atr\u00E1s");
		btn_atras.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_atras.setBounds(42, 391, 94, 22);
		add(btn_atras);
		
		Button btn_sig = new Button("Siguiente");
		btn_sig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Nombre de la competencia no se repita y que se ingrese en mayusculas.
				
				/*Obtener listado de nombres de competencias existentes.
				try {
					List<String> nombresCompetencias = GestorCompetencia.obtenerNombresCompetencias();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//int tamList = competencias.size();
				int nombreRepetido = 0;
				do {
					int contador = 0;
					competencias.get(contador).nombre;
					
				}
				while(nombreRepetido == 0);
				
				/*int nombreRepetido = 0;
				Comparar nombre de competencia actual con cada nombre de cada competencia existente. Si son iguales, nombreRepetido ++;
				
				Datos obligatorios.
				
				//VentanaAdmin.cambiarPantalla(VentanaAdmin.'nombrePantalla', VentanaAdmin.'pantalla');
				
				*/
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
		dm.addColumn("idLugar");
		
		table.setModel(dm); //table tendra las columnas de dm que agregamos aqui arriba
		
		table.getColumnModel().getColumn(2).setMaxWidth(0);
		table.getColumnModel().getColumn(2).setMinWidth(0);
		table.getColumnModel().getColumn(2).setPreferredWidth(0);
        table.doLayout();
		
		JScrollPane scrollPane_1 = new JScrollPane(table);  //agrego table dentro del ScrollPane
		scrollPane_1.setBounds(41, 208, 286, 177);
		add(scrollPane_1);
		
		Button btn_menos = new Button("-");
		btn_menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (table.getSelectedRow() ==-1) {
					VentanaAdmin.mensajeError("Seleccione la fila que desea eliminar", "Error");
				}else {
					dm.removeRow(table.getSelectedRow());
				}
			}
		});
		btn_menos.setFont(new Font("Calibri", Font.PLAIN, 15));
		btn_menos.setBounds(304, 175, 23, 22);
		add(btn_menos);
		
		JLabel lblNewLabel = new JLabel("Lugar");
		lblNewLabel.setBounds(42, 157, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Disponibilidad");
		lblNewLabel_1.setBounds(201, 157, 68, 14);
		add(lblNewLabel_1);
		
		try {
			llenarCB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		

	}
	
	//llenar combo boxes
	public static void llenarCB () throws Exception {
		
		List<Deporte> deportes = GestorCompetencia.obtenerDeportes();
		int tamList = deportes.size();
		int id;
		String nombres_deportes;
		
		for(int i=0; i<tamList; i++) {
			//get para listas 
			id= deportes.get(i).idDeporte;
			nombres_deportes= deportes.get(i).nombre;
			
			cb_deporte.addItem(nombres_deportes);
				
		}
		
		List<Integer> idModalidades = GestorCompetencia.obtenerIdModalidades();
		int tamList1 = idModalidades.size();
		
		int idMod;
		String nombres_modalidades;
		
		for(int i=0; i<tamList1; i++) {
			//se usa el get para listas 
			idMod= idModalidades.get(i);
			nombres_modalidades= GestorCompetencia.obtenerModalidadEnum(idMod).toString();
			cb_modalidad.addItem(nombres_modalidades);
				
		}
	
	}
	
	
	
	
	public static int devolverIdDeporte(int index) {
		return (index +1);
		
	}
	
	public static void llenarCBLugar(int idDeporteSeleccionado) throws Exception {
		idLugares.clear();
		
		List<LugarDeRealizacion> lugares= GestorLugaresDeRealizacion.obtenerLugaresDeporte(idDeporteSeleccionado);
		int tam= lugares.size();
		
		String nombreLugar;
		int id;
		for(int i=0; i<tam; i++) {
			nombreLugar= lugares.get(i).nombre;
			id= lugares.get(i).idLugar;
			idLugares.add(id);
			cb_lugar.addItem(nombreLugar);
		}
		
	}
	
	public static void deleteAllRows(final DefaultTableModel model) {
	       for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
	           model.removeRow(i);
	       }
	}
	
	
	
	
	
}
