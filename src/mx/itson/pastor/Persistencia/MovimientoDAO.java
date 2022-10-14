/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Movimiento;

/**
 *
 * @author eglso
 */
public class MovimientoDAO {
     public static List<Movimiento> obtenerTodos(){
        
        List<Movimiento> movimientos = new ArrayList();
        
        try {
            
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("");
            
            while(resultSet.next()){
                Movimiento m = new Movimiento();
                
                
                
            }
            
        } catch (Exception ex) {
            System.err.print("Ocurrio un error:" + ex.getMessage());
            
        }
        return movimientos;
        
    }
}
