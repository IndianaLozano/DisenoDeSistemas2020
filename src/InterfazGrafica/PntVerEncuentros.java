package InterfazGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DTO.EncuentrosProxDTO;
import DTO.ProxEncuentroDTO;
import Gestores.GestorCompetencia;
import Gestores.GestorFixture;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PntVerEncuentros extends JPanel {
	
	public static JLabel lbl_titulo = new JLabel("");

	public static int idCompetenciaActual;
	public static JTable table = new JTable();
	public static DefaultTableModel dm = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex, int columnIndex ) {
			return false;
		}
	};

	/**
	 * Create the panel.
	 */
	public PntVerEncuentros() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENCUENTROS:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(221, 11, 125, 28);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntVerCompetencia, VentanaAdmin.n_pntVerCompetencia);
			}
		});
		btnNewButton.setBounds(10, 390, 75, 23);
		add(btnNewButton);
		
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_titulo.setBounds(356, 11, 289, 28);
		add(lbl_titulo);
		
		dm.addColumn("idEncuentro");
		dm.addColumn("Fecha");
		dm.addColumn("Hora");
		dm.addColumn("Contrincante 1");
		dm.addColumn("Contrincante 2");
		
		table.setModel(dm);
		
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.doLayout();
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(61, 85, 651, 279);
		add(scrollPane_1);

	}
	
	
	public static void cargarEncuentrosProximos() throws Exception {
		
		String t = GestorCompetencia.obtenerCompetencia(idCompetenciaActual).get(0).nombre;
		lbl_titulo.setText(t);
		
		 EncuentrosProxDTO epDTO= GestorFixture.obtenerEncuentrosProximos(idCompetenciaActual);
		 List<ProxEncuentroDTO> proxEDTO = epDTO.getEncuentrosProxDTO();
		 
		 for(int i=0; i<proxEDTO.size() ; i++) {
			 ProxEncuentroDTO p = proxEDTO.get(i);
			 Object[] rowData= {p.getIdEncuentro(),p.getFecha(),p.getHora(), p.getpLocal(), p.getpVisitante() };
			 dm.addRow(rowData);
		 }
		
	}
	
}
