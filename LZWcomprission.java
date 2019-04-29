/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw.compression;
import java.util.HashMap;

public class LZW_comprission {
    public void comprission(String str){
        
      //  String str="abaababbaabaabaaaababbbbbbbb";
        HashMap<String ,Integer> map =new HashMap<>();
        for(int i=0;i<128;i++)
        {
            map.put(Character.toString((char) i),i );
        }
  
        String temp1 ="";
        String temp2="";
        String dic="";
        int counter=127;
        int asciicounter=0;
        Integer []asciies=new Integer[str.length()-1];
        
        for(int i=0;i<str.length();i++){
            
            temp2+=str.charAt(i);
            Integer find=map.get(temp2);

            if(find==null){          //notexist
                counter++;
                map.put(temp2,counter);
                temp1+=temp2.substring(0,temp2.length()-1);
                System.out.println("temp2       \t"+temp2 + " \t temp1 \t"+temp1); 
                asciies[asciicounter]=map.get(temp1);
                asciicounter++;
                
                temp1="";
                temp2="";                
                --i;
            }
            
            if(i==str.length()-1){      // to handle the last tag
                
                asciies[asciicounter]=map.get(temp2);

            }
        }
        
        for(int t=0;t<asciicounter;t++){
            System.out.println("ascii  \t"+asciies[t]);
        }
        
       TAG.decomprission(asciies,map);
        
       
    }
    }
    


/**
 *
 * @author Mahmoud
 */
public class LZWCompression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
