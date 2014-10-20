/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bass_raggedarray;

import java.util.Scanner;

/**
 *
 * @author Trinity Bass
 */
class WeeklyExpenses {
    Scanner input = new Scanner(System.in);
    int lastDay = 7; // number of arrays in jagged array ( how many days)
    int [][]weekly;
    int day;
    int length;//number of inputs from user in perday
    int perday[];// = new int [30];//temp array holding user input, could ask user for # of inputs for each day..   
        
    public WeeklyExpenses() {
        weekly = new int [lastDay][];
        day = 0;
        
        while (day < lastDay){
            getDailyExpenses();
            
            if (length < 1){
                length = 1;
                perday = new int[1];
                perday[0] = 0;
            }
            weekly[day] = new int [length];
            System.arraycopy(perday, 0, weekly[day], 0, length);
            
            day++;
            if (day == lastDay){
                printArray();
            }
        }
    }
    
    private void printArray() {

        if (day < 8){
            int weeklyTotal = 0;
            for (int row = 0; row < day; row++){
                String dayOfWeek = getDayName (row);
                System.out.println(dayOfWeek + " total expenses : ");
                int sum = 0;
                
                for (int column = 0; column < weekly[row].length; column++){
                    sum += weekly[row][column];     
                }
                
                System.out.println("total = " + sum);
                System.out.println("average = " + sum / weekly[row].length);
                weeklyTotal += sum;
            }
            System.out.println("Total weekly spending : " + weeklyTotal);
        }  
    }

    private void getDailyExpenses() {
        
        System.out.println("Please enter the number of expenses being entered for day " + (day + 1) );
        length = input.nextInt();
        
        if (length > 0){
           perday = new int[length];
        
           for (int i = 0; i < length; i++){
               System.out.println("Please enter expense.");
               perday[i] = input.nextInt();
           }
        }
        System.out.println("End of daily expenses\n"); 
    }    

    private String getDayName(int i) {
        
        switch(i){
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Friday";
            default:
                return "error";
        }
    }
}