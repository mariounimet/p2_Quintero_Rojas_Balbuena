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

    private Hash[] hash;
    private Resumen[] original;

    public HashTable() {
        this.hash = new Hash[0];
        this.original = new Resumen[0];
    }

    private int hash(String string, Hash[] repositorio) {
        int k = 0;
        byte[] bytes = string.getBytes(StandardCharsets.US_ASCII);

        for (int i = 0; i < bytes.length; i++) {
            k += bytes[i];
        }

        int key = (k & 0x7fffffff) % repositorio.length;

        return key;
    }

    public void insertar(Resumen nuevo) {
        Resumen[] temp = new Resumen[this.original.length + 1];
        int count = 0;

        temp[count] = nuevo;

        count++;

        for (int i = 0; i < this.original.length; i++) {
            temp[count] = this.original[i];
            count++;
        }

        this.original = temp;
    }

    public void function_hash() {
        Hash[] temp = new Hash[1];
        int count = 0;

        while (true) {
            boolean reset = false;

            for (int i = 0; i < this.original.length; i++) {
                Resumen resumen = this.original[i];

                for (int j = 0; j < resumen.getPalabras().length; j++) {
                    String palabra = resumen.getPalabras()[j];
                    int key = this.hash(palabra.toLowerCase(), temp);

                    if (temp[key] == null) {
                        Hash hash = new Hash();
                        hash.insertar(resumen);
                        temp[key] = hash;
                    } else if (this.compare(temp[key].getRepositorio()[0].getPalabras(), palabra)) {
                        temp[key].insertar(resumen);
                    } else {
                        count += 1;
                        reset = true;
                        temp = new Hash[this.original.length + count];
                        break;
                    }
                }
                
                if(reset) {
                    break;
                } else {
                    continue;
                }

            }
            
            if(reset) {
                    continue;
                } else {
                    break;
                }
        }

        this.hash = temp;

    }

    private boolean compare(String[] palabras, String palabra) {
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].toLowerCase().equals(palabra.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

//    private void title_hash() {
//        System.out.println(this.original.length);
//        
//        Hash[] temp = new Hash[this.original.length];
//        int count = 0;
//
//        while (true) {
//            boolean reset = false;
//
//            for (int i = 0; i < this.original.length; i++) {
//                Resumen resumen = this.original[i];
//
//                int key = this.hash(resumen.getTitulo(), temp);
//
//                if (temp[key] == null) {
//                    Hash hash = new Hash();
//                    hash.agregar(resumen);
//                    temp[key] = hash;
//                } else {
//                    count += 1;
//                    reset = true;
//                    temp = new Hash[this.original.length + count];
//                    break;
//                }
//            }
//
//            if (reset) {
//                continue;
//            }
//            break;
//        }
//
//        this.hash = temp;
//    }
//    public void insertar(Resumen nuevo_resumen) {
//        Resumen[] temp = new Resumen[this.repositorio.length];
//        int count = 0;
//
//        int search_key = this.hash(nuevo_resumen.getTitulo(), this.repositorio);
//
//        if (this.repositorio[search_key] != null) {
//            if (this.repositorio[search_key].getTitulo().equals(nuevo_resumen.getTitulo())) {
//                for (int i = 0; i < this.repositorio.length; i++) {
//                    System.out.println(this.repositorio[i]);
//                }
//                return;
//            }
//        }
//
//        while (true) {
//            boolean reset = false;
//
//            temp[search_key] = nuevo_resumen;
//
//            for (int i = 0; i < this.repositorio.length; i++) {
//                Resumen resumen = this.repositorio[i];
//                if (resumen == null) {
//                    continue;
//                }
//
//                int key = this.hash(resumen.getTitulo(), temp);
//
//                if (temp[key] == null) {
//                    temp[key] = resumen;
//                } else {
//                    count += 1;
//                    reset = true;
//                    temp = new Resumen[this.repositorio.length + count];
//                    break;
//                }
//            }
//
//            if (reset) {
//                continue;
//            }
//            break;
//        }
//
//        this.repositorio = temp;
//
//    }
    public Hash buscar(String palabra) {
        int key = this.hash(palabra.toLowerCase(), this.hash);
        Hash hash = this.hash[key];

        if (hash == null) {
            return null;
        }

        return hash;

    }

    public String[] routeTitle() {
        String[] strings = new String[this.original.length];

        for (int i = 0; i < original.length; i++) {
            strings[i] = original[i].getTitulo();
        }
        sortArray(strings);
        return strings;
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

        if (bytes1.length > bytes2.length) {
            check = bytes2;
        } else {
            check = bytes1;
        }

        for (int i = 0; i < check.length; i++) {
            if (bytes1[i] == bytes2[i]) {
                continue;
            }

            return bytes1[i] > bytes2[i];
        }

        return false;
    }

    public Resumen[] getOriginal() {
        return original;
    }

    public void setOriginal(Resumen[] original) {
        this.original = original;
    }

    public Hash[] getHash() {
        return hash;
    }

}
