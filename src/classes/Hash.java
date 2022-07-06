/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author dsre1
 */
public class Hash {
    private Resumen[] repositorio;

    public Hash() {
        this.repositorio = new Resumen[0];
    }
    
    public void insertar(Resumen nuevo) {
        Resumen[] temp = new Resumen[this.repositorio.length + 1];
        int count = 0;

        temp[count] = nuevo;

        count++;

        for (int i = 0; i < this.repositorio.length; i++) {
            temp[count] = this.repositorio[i];
            count++;
        }

        this.repositorio = temp;
    }

    public Resumen[] getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Resumen[] repositorio) {
        this.repositorio = repositorio;
    }
    
}
