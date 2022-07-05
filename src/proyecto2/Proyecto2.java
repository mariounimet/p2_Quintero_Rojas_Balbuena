/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import Functions.ReadFunctions;
import Interfaz.Home;
import classes.HashTable;
import classes.Resumen;

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

        Resumen resumen1 = rf.read();

        HashTable hashTable = new HashTable();

        hashTable.insertar(resumen1);

        Resumen resumen2 = rf.read();

        hashTable.insertar(resumen2);
        
        for(int i = 0; i < hashTable.getRepositorio().length; i++) {
            System.out.println(hashTable.getRepositorio()[i]);
        }

        Home home = new Home(hashTable);
        
        home.setVisible(true);
    }

}
