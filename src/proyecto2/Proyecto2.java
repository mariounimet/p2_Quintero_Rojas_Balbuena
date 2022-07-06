/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import Functions.ReadFunctions;
import Interfaz.Home;
import classes.Hash;
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

        HashTable hashTable = new HashTable();

//        Hash hash = hashTable.buscar("AutoCAD");
//        
//        for (int i = 0; i < hash.getRepositorio().length; i++) {
//            String[] palabras = hash.getRepositorio()[i].getPalabras();
//            for (int j = 0; j < palabras.length; j++) {
//                System.out.println(palabras[j]);
//            }
//        }
        Home home = new Home(hashTable);

        home.setVisible(true);
    }

}
