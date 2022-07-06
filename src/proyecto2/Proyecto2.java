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

        ReadFunctions rf = new ReadFunctions();
        
        HashTable hashTable = new HashTable();

        Resumen resumen1 = rf.read();

        hashTable.insertar(resumen1);

        Resumen resumen2 = rf.read();

        hashTable.insertar(resumen2);

        Resumen resumen3 = rf.read();

        hashTable.insertar(resumen3);

        Resumen resumen4 = rf.read();

        hashTable.insertar(resumen4);

        for (int i = 0; i < hashTable.getOriginal().length; i++) {
            System.out.println(hashTable.getOriginal()[i].getTitulo());
        }

        System.out.println("///////////////////");
        
         hashTable.function_hash();
        
        System.out.println(hashTable.getHash().length);


//        for (int i = 0; i < hashTable.getHash().length; i++) {
//            Hash hash = hashTable.getHash()[i];
//            
//            System.out.println(hash);
//            
////            for (int j = 0; j < resumen.getPalabras().length; j++) {
////                String palabra = resumen.getPalabras()[j];
////                System.out.println(palabra);
////            }
//            
//        }
        
        Hash hash = hashTable.buscar("AutoCAD");
        
        for (int i = 0; i < hash.getRepositorio().length; i++) {
            String[] palabras = hash.getRepositorio()[i].getPalabras();
            for (int j = 0; j < palabras.length; j++) {
                System.out.println(palabras[j]);
            }
        }

        Home home = new Home(hashTable);

        home.setVisible(true);
    }

}
