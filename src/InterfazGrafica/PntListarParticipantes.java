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

import Entidades.Competencia;
import Entidades.Participante;
import Gestores.GestorCompetencia;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PntListarParticipantes extends JPanel {

	public JLabel lbl_titulo = new JLabel();

	public int idCompetenciaActual;
	public static JTable table = new JTable();
	public static DefaultTableModel dm = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex, int columnIndex ) {
			return false;
		}
	};
	/**
	 * Create the panel.
	 */
	public PntListarParticipantes() {
		setLayout(null);
		
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_titulo.setBounds(192, 30, 343, 22);
		add(lbl_titulo);
		
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
		
		Button button = new Button("Atr\u00E1s");
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBounds(58, 383, 70, 22);
		add(button);
		
		JButton btn_altaParticipante = new JButton("Dar de alta Participante");
		btn_altaParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAdmin.pntAltaParticipante.idCompetenciaActual= idCompetenciaActual;
				VentanaAdmin.cambiarPantalla(VentanaAdmin.pntAltaParticipante, VentanaAdmin.n_pntAltaParticipante);
			}
		});
		btn_altaParticipante.setFont(new Font("Calibri", Font.PLAIN, 14));
		btn_altaParticipante.setBounds(424, 92, 245, 56);
		add(btn_altaParticipante);
		
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
		
		dm.addColumn("idParticipante");
		dm.addColumn("Nombre del Participante");
		dm.addColumn("Correo Electrónico");
		
		table.setModel(dm);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.doLayout();
        
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(58, 125, 277, 222);
		add(scrollPane_1);

	}
	
	public static void mensaje(String error, String titulo) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, error, titulo, 
			JOptionPane.PLAIN_MESSAGE, 
			JOptionPane.ERROR_MESSAGE)==0);
			
	}
	
	
	public static void cargarParticipantes (int idCompetencia) throws Exception {
		
		
		Competencia comp= GestorCompetencia.obtenerCompetencia(idCompetencia).get(0);
		List<Participante> participantes= comp.participantes;
		int id;
		String nombre;
		String correo;
		
		if (participantes.size()>0) {
			
			for(int i=0; i<participantes.size(); i++) {
			id= participantes.get(i).id;
			nombre= participantes.get(i).nombre;
			correo= participantes.get(i).correo;
			
			
			Object[] rowData= {id, nombre, correo};
			dm.addRow(rowData);
			
			}
			
			
		}
	}
	
	
	public  void actualizarTitulo() throws Exception {
		Competencia comp= GestorCompetencia.obtenerCompetencia(idCompetenciaActual).get(0);
		String nombre = comp.nombre;
		lbl_titulo.setText("COMPETENCIA: "+ nombre );
	}
	
	public static void actualizarTabla(int idCompetencia) throws Exception {
	       for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
	           dm.removeRow(i);
	       }
	       cargarParticipantes(idCompetencia);
	}
}
