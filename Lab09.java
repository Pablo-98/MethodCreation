import java.util.Scanner;
import java.io.*;


public class Lab09{

    /**
     * this method will take an integer array, declare a sum variable at 0 and add every single array element to the sum variable. 
     * this method will return the sum variable at the end
     * @param a array of integers
     * @return sum variable
     */
public static int getSum(int[] a) {
int sum =0;

for(int i=0; i< a.length; i++) {
    sum += a[i];
}


return sum;
}

/**  this method will take an integer array, create a sum variable that adds all the elements of the array and divide that sum variable by the length of the array. In turn, giving us an average of all the numbers
 * 
 * @param a an array of integers
 * @return returns an average of all the numbers
 */

public static double getAverage (int[] a) {
    double average;
    int sum = 0;
    for(int i=0; i< a.length; i++) {
        sum += a[i];
    }

    average = sum / a.length;

    return average;

}

/** this method will take an array of integers and compare each of the values. This comparison will look for the greatest value and assign it to a variable called maxValue
 * 
 * @param a an array of integers
 * @return maxValue variable
 */
public static int getMax(int [] a) {
    int maxValue =a[1];

    for (int i =0; i <a.length; i++){
        if (a[i] > maxValue){
            maxValue = a[i];
        }
    }
    return maxValue;
}

/** This method will take an array of integers and compare each of the values to look for the one with the smallest value. The smallest value will be assigned to a variable called MinValue
 * 
 * @param a an array of integers
 * @return minValue variable 
 */
public static int getMin(int [] a) {
    int minValue =a[0];
    

    for (int i =0; i <a.length; i++){
        if (a[i] < minValue){
            minValue = a[i];
        }
    }
    return minValue;
}

/**  
 * This method will take an array of integers and for every value in the array we will process it in a standard deviation formula and return the final value 
 * @param a an array of integers
 * @return a variable holding the final standard deviation value
 */
public static double getStdDev( int[]a) {
     
    
    double sum = 0;
    double mean; 
    for (int i=0; i < a.length; i++){
        sum+= a[i];
    }
    mean = sum/ a.length;

    double sub;
    double pow;
    double accumulator =0; // this represents sigma.
    double frac;
    double stdev;

    for (int j =0; j<a.length; j++){
        double currentNum = a[j];

        sub = currentNum - mean;

        pow = Math.pow(sub, 2);

        accumulator += pow;
        
    }
    frac = accumulator / (a.length -1);

    stdev = Math.sqrt(frac);


return stdev;

}
 /**
  *  this method will create a new file and using an array of integer, will store the values from the array into the new file using the printwriter
  * @param filename file that will be created
  * @param a an array of integers
  */
public static void writeToFile(String filename,int[] a) throws IOException{
PrintWriter printer = new PrintWriter(filename);

for (int i =0; i< a.length; i++) {
    printer.println(a[i]);
}
printer.close();
} 






    public static void main(String[] args) throws IOException  {
        //declaration of scanner that will read throught numbers.txt 
        Scanner scnr = new Scanner(new File ("numbers.txt"));
        Scanner scnr2 = new Scanner(new File ("numbers.txt"));
       // Scanner input2 = new Scanner ("/Users/pablo/Desktop/development/java/lab09/numbers.txt");

        int line;
        int counter =0;
       while (scnr.hasNext()){
       line = scnr.nextInt();
        counter++;
       System.out.println(line);
     System.out.println("count:" + counter);
       }
       System.out.println(counter);
       scnr.close();
       System.out.println();

    

        int[] intArray = new int[counter];
        while (scnr2.hasNext()){
        for (int i =0; i< intArray.length; i++) {
            intArray[i] = scnr2.nextInt();
        }
    }

for( int j=0; j< intArray.length; j++) {
        System.out.println(intArray[j]);
    }
    System.out.println("sum:" + getSum(intArray));
    System.out.println("average:" + getAverage(intArray));
    System.out.println("max value: " + getMax(intArray));
    System.out.println("min value: " + getMin(intArray));
    System.out.println( "standard deviation: " +getStdDev(intArray));

    writeToFile("newFile.txt", intArray);


   

        }
    }

    