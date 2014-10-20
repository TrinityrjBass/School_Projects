/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivedescentparser;

import java.util.Scanner;

/**
 *
 * @author Trinity Bass
 */
public class RecursiveDescentParser {

    /**
     * @param args the command line arguments
     */
    static Lexer lex;
    private static String output = "";
    
    public static void main(String[] args) {
        // TODO code application logic here
        /*The main method will : ask the user for a string
         * attempt to parse it
         * display the result of this attempt and all the steps followed (just like the example from the 
         * textbook - pages 182 - 185).
         * Report all syntax errors.
         * Verify that the following string is recognized: 
         * caaabccabb
         * Submit the output of your program as a text file h2-3.txt.*/
        // S3 C1 S1 B1 B2 S3 C3 B2 S2
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the input");
        String s = input.next();
        
        lex = new Lexer(s);
        
        if (!lex.valid){
            System.out.println("Invalid input, Exiting program");
        }
        else{
            s();
            System.out.println("output: " + output);
            System.out.println("Parse successful");
        }              
    }
    
    static void s(){
        //S -> aB | b | cC
        char c = lex.getChar();
        System.out.println("S called, c = " + c);
        if (c == 'a'){
            output = output + "S1";
            System.out.println("s1 added to input");
            b();
        }
        else if (c == 'b'){
            output = output.concat("S2");
            System.out.println("s2 added to input");
        }
        else if (c == 'c'){
            output = output.concat("S3");
            System.out.println("s3 added to input");
            c();
        }
        System.out.println("Exit S");
    }
    static void b(){
        //B -> aB | bS
        char c = lex.getChar();
        System.out.println("B called, c = " + c);
        if (c == 'a'){
            output = output + "B1";
            System.out.println("b1 added to input");
            b();
        }
        else if (c == 'b'){
            output = output + "B2";
            System.out.println("b2 added to input");
            s();
        }
         System.out.println("Exit B");
    }
    static void c(){
        //C -> aaS | b | caB
        char c = lex.getChar();
        System.out.println("C called, c = " + c);
        if (c == 'a'){
            output = output + "C1";
            System.out.println("c1 added to input");
            lex.getChar();
            s();
        }
        else if (c == 'b'){
            output = output + "C2";
            System.out.println("c2 added to input");
        }
        else if (c == 'c'){
            lex.getChar();
            output = output + "C3";
            System.out.println("c3 added to input");
            b();
        }
         System.out.println("Exit C");
    }
}
