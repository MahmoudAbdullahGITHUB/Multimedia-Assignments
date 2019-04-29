/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.decomprission;

import java.util.HashMap;


/**
 *
 * @author computer
 */
public class LZWDecomprission {
    
    public static void decomprission(Integer arr[],HashMap<String , Integer> map){
         String str="";
            System.out.print("\n\n decompress ----------------------------------- decompress \n\n");
            String itemp;
         // to search about the key by the value ;
        for(Integer i=0;i<arr.length;i++){ 
            
            Integer t=arr[i];
            
            map.entrySet().stream().filter((entry) -> {
             return entry.getValue().equals(t);
             
            }).forEach((entry) -> {
                System.out.print(entry.getKey());
            });
           
        }
        
         System.out.print("\n\n");
        
        
    } 
    
    
}

