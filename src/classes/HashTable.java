/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Mario
 */
public class HashTable {
    private Resumen[] repositorio;
    
    public String[] routeTitle() {
        String[] string = new String[repositorio.length];
        for(int i = 0; i < repositorio.length; i++) {
            string[i] = repositorio[i].getTitulo();
        }
        return string;
    }

    public Resumen[] getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Resumen[] repositorio) {
        this.repositorio = repositorio;
    }
    
    
}
