/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import classes.HashTable;

/**
 *
 * @author dsre1
 */
public class AnalyzeSummary {
    
    public int analyzeText(String text, String evaluate) {
        String[] frequency = text.split(evaluate);
        
        return (frequency.length - 1);    
    }

}
