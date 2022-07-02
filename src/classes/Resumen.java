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
    
    public String obtenerAutores() {
        String string = "";
        
        for(int i = 0; i < autores.length; i++) {
            string += this.autores[i] + ", ";
            if((i + 1) < autores.length) {
                string += ", ";
            } else {
                string += ".";
            }
        }
        
        return string;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String[] getPalabras() {
        return palabras;
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public Resumen getNext() {
        return next;
    }

    public void setNext(Resumen next) {
        this.next = next;
    }
    
    
}
