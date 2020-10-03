package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidades.ConsultaGenerica;


public class Conexion {
	
	
	private static String server= "localhost";
	private static String port= "3306";
	private static String BDD= "";
	private static String user= "";
	private static String password= "";
	
	//METODOS-------------------------------------------------------------
	
	
	//M�todo que crea una conexion con la BDD.
	
	public static Connection conectarBDD() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionUrl= "jdbc:mysql://" + server + ":" + port + "/" + BDD + "?useLegacyDatetimeCode=false&serverTimezone=America/Argentina/Buenos_Aires";
			Connection connect= DriverManager.getConnection(connectionUrl, user, password);
			
			System.out.println("Conexi�n exitosa");
			return connect;
			
		}catch(Exception ex){
			
			System.out.println("Error en la conexion a la BDD");
			System.out.println(ex.getMessage());
            return null;
		}
	}
	
	//Metodo que envia una consulta a la BDD 
	
	public static ArrayList<Object> consultar(String query, Class<? extends Object> ob) throws Exception{
        ArrayList<Object> result = new ArrayList<Object>();
        Connection con = null;
        try {
            con =Conexion.conectarBDD();
            ResultSet rs = con.createStatement().executeQuery(query);
            String objeto;
            while(rs.next()){
                objeto = "";
                if(ob == ConsultaGenerica.class){
                    for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                        objeto += rs.getMetaData().getColumnName(i) + " -- " + rs.getString(i) + "\t";
                    }
                }
                else{
                    for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                        objeto += rs.getString(i) + "\t";
                    }
                }
                Object obj = ob.getConstructor(String.class).newInstance(objeto);
                result.add(obj);
            }
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if(con != null){
                con.close();
            }
        }
        return result;
    }
	
	// M�todo que ejecuta una acci�n en la BDD (insertar, eliminar etc.)
	
	public static void ejecutar(String query) throws Exception{
        Connection con = null;
        try {
            con = Conexion.conectarBDD();
            con.createStatement().executeUpdate(query);
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if(con != null){
                con.close();
            }
        }
    }
	


}
