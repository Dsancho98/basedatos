/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.SQLException;

/**
 *La clase BaseDatos es la clase main la cual abre el menú.
 * @author Dani
 */
public class Basedatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Menu men = new Menu ();
        men.setVisible(true);   
    }
    
}
