/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.negocio;

import mx.itson.pastor.Persistencia.CuentaDAO;

/**
 *
 * @author eglso
 */
public class CuentaNegocio {
    
    public static boolean guardar(String numero, int idCliente){
        
        boolean resultado = false;
        try {
            
            if(!CuentaDAO.verificarExistencia(numero)){
                resultado = CuentaDAO.Guardar(numero, idCliente);
            }
            
        } catch (Exception e) {
            System.err.print(e.getMessage());
            
        }
        return resultado;
    }
}
