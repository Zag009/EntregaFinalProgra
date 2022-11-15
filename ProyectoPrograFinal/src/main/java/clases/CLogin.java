/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import CentrosReciclaje.login.FormMenuPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Esteban Meza
 */
public class CLogin {
    
    public void validarUsuario(JTextField usuario, JPasswordField password){
        
        try{
            
            ResultSet rs=null;
            PreparedStatement ps=null;
            
            clases.CConexion objetoConexion = new clases.CConexion();
            
            String consulta="select * from usuarios where usuario = (?) and password = (?)";
            ps=objetoConexion.estableceConexion().prepareStatement(consulta);
            
            String contra = String.valueOf(password.getPassword());
            
            ps.setString(1, usuario.getText());
            ps.setString(2, contra);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                
                JOptionPane.showMessageDialog(null,"El Usuario es Correcto");
                FormMenuPrincipal objetoMenu = new FormMenuPrincipal();
                objetoMenu.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"El Usuario es  Inorrecto, vuelva a intentar");
            }
            
            
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: "+e.toString());
        }
    }
    
}
