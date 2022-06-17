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
public class Resumen {
    private String titulo, texto;
    private String[] palabras, autores;
    private Resumen next;

    public Resumen(String titulo, String texto, String[] palabras, String[] autores) {
        this.titulo = titulo;
        this.texto = texto;
        this.palabras = palabras;
        this.autores = autores;
        this.next = null;
    }
    
}
