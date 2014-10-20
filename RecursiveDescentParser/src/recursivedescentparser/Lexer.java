/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivedescentparser;

/**
 *
 * @author Trinity Bass
 */
public class Lexer {  
    
    int current = 0;
    char character;
    String _s;
    boolean valid;
    

    Lexer(String s) {      
        _s = s;
        character = s.charAt(current);
        valid = validate();
    }

 private boolean validate(){
     String input = _s;
     boolean v = true;
     for (int i = 0; i <= _s.length() -1; i++){
         char c = input.charAt(i);
         
         if (c != 'a' &&
            c != 'b' &&
            c != 'c'){
             v = false;
            System.out.println("invalid input char '" + input.charAt(i) + "'");                              
          }
         if ( c == ' '){
                 System.out.println("Spaces are not allowed as input.");
            v = false;
         }
    }

        return v; 
 }
 
 public char getChar(){
     char oldChar = character;
     nextCharacter();
     return oldChar;
 }
 
 public char nextCharacter(){
      if (current + 1 == _s.length()){
        return character;
      }
    character = _s.charAt(current + 1);
    current++;
    return character;
 }
 
}