/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotransversal70.AccesoADatos;

import java.sql.Connection;

public class InscripcionData {
    private Connection con=null;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        
             con= Conexion.getConexion();
        
        
    }
    
    
    
    
    
}
