/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotransversal70.AccesoADatos;

import java.sql.Connection;

/**
 *
 * @author 54911
 */
public class MateriaData {
    
    private Connection con=null;

    public MateriaData() {

        con= Conexion.getConexion();
        
    }

 
        
       
        
}
