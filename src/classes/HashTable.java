/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Mario
 */
public class HashTable {

    private Resumen[] repositorio;

    public HashTable() {
        this.repositorio = new Resumen[1];
    }

    private int hash(String string, Resumen[] repositorio) {
        int k = 0;
        byte[] bytes = string.getBytes(StandardCharsets.US_ASCII);

        for (int i = 0; i < bytes.length; i++) {
            k += bytes[i];
        }

        int key = (k & 0x7fffffff) % repositorio.length;

        return key;
    }

    public void insertar(Resumen nuevo_resumen) {
        Resumen[] temp = new Resumen[this.repositorio.length];
        int count = 0;

        while (true) {
            boolean reset = false;

            int first_key = this.hash(nuevo_resumen.getTitulo(), temp);
            temp[first_key] = nuevo_resumen;

            for (int i = 0; i < this.repositorio.length; i++) {
                Resumen resumen = this.repositorio[i];
                if (resumen == null) {
                    continue;
                }

                int key = this.hash(resumen.getTitulo(), temp);

                if (temp[key] == null) {
                    temp[key] = resumen;
                } else {
                    count += 1;
                    reset = true;
                    temp = new Resumen[this.repositorio.length + count];
                    break;
                }
            }

            if (reset) {
                continue;
            }
            break;
        }

        this.repositorio = temp;

    }

    public Resumen buscar(String titulo) {
        int key = this.hash(titulo, this.repositorio);
        Resumen resumen = this.repositorio[key];

        if (resumen == null) {
            return null;
        } else if (resumen.getTitulo().equals(titulo)) {
            return resumen;
        }

        return null;
    }

    

    public String[] routeTitle() {
        String[] strings = new String[this.count()];
        
        for (int i = 0; i < repositorio.length; i++) {
            if(repositorio[i] != null) {
                strings = this.setData(strings, repositorio[i]);
            }
        }
//        sortArray(strings);
        return strings;
    }
    
    private String[] setData(String[] strings, Resumen resumen) {
        for (int i = 0; i < strings.length; i++) {
            if(strings[i] == null) {
                strings[i] = resumen.getTitulo();
                break;
            }
        }
        
        return strings;
    }
    
    private int count() {
        int count = 0;
        
        for (int i = 0; i < this.repositorio.length; i++) {
            if(this.repositorio[i] != null) {
                count += 1;
            }
        }
        
        return count;
    }
    
    private void sortArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                String tmp = "";
                if (bigger(arr[i], arr[j])) {
                    tmp = arr[i];              
                    arr[i] = arr[j];          
                    arr[j] = tmp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    private boolean bigger(String string1, String string2) {
        byte[] check;
        byte[] bytes1 = string1.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes2 = string2.getBytes(StandardCharsets.US_ASCII);
        
        if(bytes1.length > bytes2.length) {
            check = bytes2;
        } else {
            check = bytes1;
        }
        
        for(int i = 0; i < check.length; i++) {
            if (bytes1[i] == bytes2[i]) {
                continue;
            }
            
            return bytes1[i] > bytes2[i];
        }
        
        return false;
    }

    public Resumen[] getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Resumen[] repositorio) {
        this.repositorio = repositorio;
    }

}
