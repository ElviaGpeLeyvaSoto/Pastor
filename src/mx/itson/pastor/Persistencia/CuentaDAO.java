/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Cliente;
import mx.itson.pastor.entidades.Cuenta;

/**
 *
 * @author eglso
 */
public class CuentaDAO {
    
     public static List<Cuenta> obtenerTodos(){
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT cu.id, cu.numero, cl.id, cl.nombre, cl.direccion, cl.telefono, cl.email FROM cuenta cu INNER JOIN cliente cl ON cu.idCliente = cl.id");
            
            while(resultSet.next()){
                Cuenta cuenta = new Cuenta();
                cuenta.setId(resultSet.getInt(1));
                cuenta.setNumero(resultSet.getString(2));

                Cliente c = new Cliente();
                c.setId(resultSet.getInt(3));
                c.setNombre(resultSet.getString(4));
                c.setDireccion(resultSet.getString(5));
                c.setTelefono(resultSet.getString(6));
                c.setEmail(resultSet.getString(7));

                cuenta.setCliente(c);

                cuentas.add(cuenta);
            }
        } catch(Exception ex){
            System.err.print("Ocurrió un error: " + ex.getMessage());
        }
        return cuentas;
    }
    public static boolean Guardar (String numero, int idCliente){
        
        boolean resultado = false;
        try {
            
            Connection connection = Conexion.obtener();
            String consulta = "INSERT INTO cuenta ( numero, idcliente) VALUES (?, ?);)";
            PreparedStatement s = connection.prepareStatement(consulta);
                    s.setString(1, numero);
                    s.setInt(2, idCliente);
                    s.execute();
                    resultado = s.getUpdateCount() == 1;
                    
        } catch (Exception e) {
            System.err.println("Ocurrio un error:" + e.getMessage());
        }
        return resultado;
    }
    public static boolean verificarExistencia(String numero){
       boolean existencia = false; 
        try {
            Connection connection = Conexion.obtener();
            String consulta = "Select * FROM cuenta WHERE numero =?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, numero);
            
            ResultSet resultSet = statement.executeQuery();
            
            existencia = resultSet.next();
            
        } catch (Exception e) {
            System.err.println("Ocurrio un error:" + e.getMessage());
        }
        return existencia;
    }
}
