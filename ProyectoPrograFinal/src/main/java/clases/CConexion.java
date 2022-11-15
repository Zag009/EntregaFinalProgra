/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban Meza
 */
public class CConexion {
   
    String usuario="root";
    String contraseña="";
    String bd="login";
    String ip="localhost";
    String puerto="3306";
    private Connection conectar;
    
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            //JOptionPane.showMessageDialog(null, "Se conecto correctamente a la base de datos");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Problemas en la conexion"+e.toString());
        }
        return conectar;
    }
}
