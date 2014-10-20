package passengerqueue;
/*
 * Trinity Bass
 */

public class PassengerQueue {
    /**
     * Records activity of passengers at a security line through 5 gates.
     * There is a single line of initially 20 passengers.
     * 10 more passengers are added to the line at the beginning of each minute starting during the second minute.
     * 
     */
    public static void main(String[] args) {
        java.util.Queue<String> queue = new java.util.LinkedList<String>(); 
        int totalPassengers = 1;//next named passenger, also running total of passengers
        int m = 1;//counts minutes
        
        //loading 20 passengers to initial queue.
        queue = add(queue, totalPassengers, 20);
        totalPassengers += 20;
        
        while (m < 11){
            System.out.println("Minute " + m);
            System.out.println("Queue : " + queue);
            System.out.println("Activity :");
            queue = distribute(queue);
            System.out.println("Queue at end of minute " + m);
            System.out.println(queue);
            System.out.println("\n");
            
            //add 10 more passengers to the queue at end of minute
            queue = add(queue, totalPassengers, 10);
            
            //increment total number of passengers
            totalPassengers += 10;
            
            //increment minute
            m++;
        }  
    }
/**
 * adds the next 10 passengers to queue
 * @param queue
 * @param k, totalPassengers, number of passengers processed already
 * @param more, adds value of 'more' passengers to queue
 * @return 
 */
    public static java.util.Queue<String> add(java.util.Queue<String> queue, int k, int more){
    	String p = "Passenger";

    	for (int i = k; i < k + more; i++){
            queue.offer(p + " " + i);
          }
          return queue;
    }//end add
    /**
     * prints contents of gate arrays
     * @param g 
     */
    public static void printGate(String [] g){
    	for (String s: g){
            System.out.print(s + ", ");
        }
        System.out.print("\n");
    }//end printGate
    /**
     * distributes passengers to first available security gate
     * @param q
     * @return q
     */
    public static java.util.Queue<String> distribute(java.util.Queue<String> q){
        String [] gate1, gate2, gate3, gate4, gate5;
        gate1 = new String [1];
        gate2 = new String [2];
        gate3 = new String [2];
        gate4 = new String [3];
        gate5 = new String [3];
        
        //distributing passengers to gates
        for (int i = 0; i < 3; i++){
            //gates are filled from gate 1 to gate 5
            if (i == 0){
                gate1[i] = q.poll();
                gate2[i] = q.poll();
                gate3[i] = q.poll();
                gate4[i] = q.poll();
                gate5[i] = q.poll();
            }
            //gates 2 and 3 are filled their last time, before gates 4 and 5 are filled for thier last time.
            if (i == 2){
                gate2[i-1] = q.poll();//preventing stack overflow
                gate3[i-1] = q.poll();
                gate4[i] = q.poll();
                gate5[i] = q.poll();
            }
            //gates 4 and 5 process fastest, so are free and filled next
            if (i == 1){
                gate4[i] = q.poll();
                gate5[i] = q.poll();
            }                   
        }
        //print activity of each gate during past minute
        //Gate 1 only had one passenger, so a call is not needed.
        System.out.println("Gate 1 : " + gate1[0]);
        System.out.print("Gate 2 : ");
        printGate(gate2);
        System.out.print("Gate 3 : ");
        printGate(gate3);
        System.out.print("Gate 4 : ");
        printGate(gate4);
        System.out.print("Gate 5 : ");
        printGate(gate5);
        
        return q;
    }        
}