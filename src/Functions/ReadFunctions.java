/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import classes.HashTable;
import classes.Resumen;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mario
 */
public class ReadFunctions {
    
    public Resumen read(){
        String titulo, texto, line, aux;
        String[] palabras, autores, auxArray;
        titulo = texto = "";
        File file = seleccion();
        BufferedReader br = buffReader(file);
        
        if(br == null){
            return null;
        }
        
        try{
            titulo = br.readLine();
            
//            System.out.println(titulo);
            
            br.readLine();
            line = br.readLine();
            aux = "";
            while(!line.equals("Resumen")){
                aux += line+",";
                line = br.readLine();
            }
            autores = aux.split(",");
            
//            System.out.println(autores.length);
            
            texto = br.readLine();
            
//            System.out.println("\n"+texto+"\n");
            
            aux = br.readLine();
            
//            System.out.println(aux);
            
            auxArray = aux.split(":");
            palabras = auxArray[1].split(","); 
            
            for(int i = 0; i < palabras.length; i++){
                palabras[i] = palabras[i].substring(1);
                if (i == palabras.length-1){
                    char[] carr = palabras[i].toCharArray();
                    if(carr[carr.length-1]=='.'){
                        palabras[i] = palabras[i].substring(0, carr.length-1);
                    }
                }
            }
                
            for(String i : palabras){
//                System.out.println(i);
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Archivo no válido");
            return null;
        }
        
       return new Resumen(titulo, texto, palabras, autores);
    }
    
    public void guardar(HashTable ht){
        File file = seleccion();
        
        try{
            PrintWriter pw = new PrintWriter(file);
            pw.write("");
            for(Resumen resumen : ht.getOriginal()){
                if(resumen != null){
                    System.out.print("paso");
                    pw.append(resumen.getTitulo()+"\n");
                    
                    for(String autor : resumen.getAutores()){
                        pw.append(autor+",");
                    }
                    
                    pw.append("\n");
                    pw.append(resumen.getTexto()+"\n");
                    
                    for(String palabra: resumen.getPalabras()){
                        pw.append(palabra+",");                       
                    }
                    pw.append("\n");                    
                }
            }
            
            JOptionPane.showMessageDialog(null, "datos guardados");
            pw.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error al guardar");
        }        
    }
    
    public HashTable cargar(){
        File file = seleccion();
        BufferedReader br = buffReader(file);
        HashTable ht = new HashTable();
        String line = "";
        
        try{
            line = br.readLine();
            while(line != null){
                                
                System.out.println(line);
                String titulo, texto;
                String[] autores, palabras;
                titulo = line;
                autores = br.readLine().split(",");
                texto = br.readLine();
                palabras = br.readLine().split(",");
                
                ht.insertar(new Resumen(titulo, texto, palabras, autores));
                line = br.readLine();
            }
            br.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error al cargar datos");
        }
        
        return ht;
    }
    
    public File seleccion(){
        File file;
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        jfc.setFileFilter(filtro);
        
        int selec = jfc.showOpenDialog(null);
        
        if (selec == JFileChooser.APPROVE_OPTION){
            file = jfc.getSelectedFile();
            return file;
        }else{
            JOptionPane.showMessageDialog(null, "Archivo no válido");
            return null;
        }
    }
    
    public BufferedReader buffReader(File file){
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            return br;
        }catch(Exception e){
            return null;
        }        
    }
}
