/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmatic.coding;

/**
 *
 * @author Mahmoud
 */
public class ArithmaticCoding {

   public static void main(String[] args) {

        String s = "bill gates";
        String unique = "" + s.charAt(0);
        
        //to remove the repetation chars from the string s and save it in string unique
        for (int i = 0; i < s.length(); i++) {
            for (int t = 0; t < unique.length(); t++) {
                if (s.charAt(i) == unique.charAt(t)) {
                    break;
                } else {
                    if (t == unique.length() - 1) {
                        unique += s.charAt(i);
                        break;
                    }
                }
            }
        }
        System.out.println("unique\t" + unique);

        // to sort unique
        unique = unique.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println("  sorted unique  " + unique + " \t len " + unique.length());

        // probabilty of each char
        double[] prob = new double[unique.length()];
        for (int i = 0; i < unique.length(); i++) {
            for (int t = 0; t < s.length(); t++) {
                if (unique.charAt(i) == s.charAt(t)) {
                    prob[i]++;
                }
            }
        }

        for (int t = 0; t < prob.length; t++) {
            System.out.println("prob[t]\t" + prob[t]);
        }
        
        // to save lower and upper of each char
        double[][] arr = new double[unique.length()][2]; 
        double basicLower = 0;   // the biganing lower is 0 and the upper 1 
        for (int i = 0; i < unique.length(); i++) {
            arr[i][0] = basicLower;
            basicLower += prob[i] / s.length();
            arr[i][1] = basicLower;
        }
        
        // only  check 
        System.out.println("------------------------------------\n");
        for (int i = 0; i < unique.length(); i++) {
            System.out.print(unique.charAt(i) + "\t" + "lower " + arr[i][0]);
            System.out.println("\t upper " + arr[i][1]);
        }

        int index = 0;
        double low = 0;
        double tempLow=0; // use it until the value of low not change in [i] that is in loop under
        double high = 1;
        double range = 1;
        System.out.println("#########################################################################\n");
        for (int i = 0; i < s.length(); i++) {
            for (int t = 0; t < unique.length(); t++) {
                if (s.charAt(i) == unique.charAt(t)) {
                    index = t;
                    break;
                }
            }
            low = tempLow + range * arr[index][0];
            System.out.print(s.charAt(i)+"\t low \t" + low);
            high = tempLow + range * arr[index][1];
            tempLow=low;
            System.out.println(" high \t" + high+"\t arr[index][0] \t"+arr[index][0]+"\t arr[index][1] \t"+arr[index][1]);

            range = high - low;

        }
        System.out.println("\n#########################################################################");
        System.out.println("final low \t" + low);
        System.out.println("final high \t" + high);

    }

    
}
