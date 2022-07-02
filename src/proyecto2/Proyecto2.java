/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import Functions.ReadFunctions;
import Interfaz.Home;
import classes.HashTable;

/**
 *
 * @author Mario
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReadFunctions rf = new ReadFunctions();
        
        HashTable hashTable = new HashTable();
        
        Home home = new Home(hashTable);
        
        home.setVisible(true);

    }
    
}
