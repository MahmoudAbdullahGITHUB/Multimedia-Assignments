/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz77.comprission;

public class LZ77Comprission {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
        String s="abaababaabbbbbbb";
        String temp="", next="" ,dic="";
        String arr[]=new String [100]; // for uniq strings
        int pos /* []= new int [100]*/  , len /*[]=new int [100]*/ ;
        int max_pos=0 ,max_len=0 , number_of_tags=0;
       
        for(int i=0;i<s.length();i++){
            temp+=s.charAt(i);
            for(int t=i;t>=0;t--){
                int n= dic.lastIndexOf(temp);
                if(n==-1){
                   // dic+=temp;
                    if(temp.length()==1){
                       pos=0;
                      
                    } 
                    else
                    {
                       String tempdic=dic;
                       int pre ,after;
                     
                       StringBuilder sb=new StringBuilder(temp);
                       sb.deleteCharAt(temp.length()-1);
                       String ss=sb.toString();
                     
                       pre=dic.lastIndexOf(ss);
                       tempdic+=ss;
                       after=tempdic.lastIndexOf(ss);
                       pos=after-pre;   
                    }
                    len=temp.length()-1;
                    next+=temp.charAt(temp.length()-1);
                    dic+=temp;                   
                    System.out.println('<'+"\t"+pos+"\t"+len+"\t" +next+"\t"+'>'  );                 
                    temp="";
                    next="";
                
                    // to detrmine the max position in all tags
                    if(max_pos<pos){
                        max_pos=pos;
                    }
                    if(max_len<len){
                        max_len=len;
                    }
                    // when he enter here then tha tag is comleted
                    number_of_tags++;
                
                }
                else{
                    break;
                }            
            }   
        } 
        int original_size=s.length()*8;
        System.out.print("original_size \t " +original_size+"\n");
        // how to find the number of bits of
        // int tag_size = bits of max_pos +bits of max_len +8;
        // int compressed_size =tag_size*counter_of_tags 
        
    }
}
