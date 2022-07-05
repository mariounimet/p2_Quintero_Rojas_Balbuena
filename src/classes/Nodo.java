/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author andre
 */
public class Nodo {
    Object data;
    Nodo pnext;

 //Constructor.
    Nodo (Object o){
        data=o;
        pnext=null;
    }
  
}
