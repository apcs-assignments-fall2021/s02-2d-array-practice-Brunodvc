import java.util.ArrayList;
import java.util.HashMap;

public class MyMain {

    // Returns the number of odd numbers in mat
    public static int countOdds(int[][] mat) {
        // YOUR CODE HERE
        int count = 0;
        for(int row = 0; row< mat.length; row++){
            for(int col = 0; col<mat[0].length; col++){
                if(mat[row][col]%2!=0){
                    count++;
                }
            }
        }
        return count;
    }

    // Returns the largest value in mat
    public static int findLargest(int[][] mat) {
        // YOUR CODE HERE
        int biggest = Integer.MIN_VALUE;
        for(int row = 0; row< mat.length; row++){
            for(int col = 0; col<mat[0].length; col++){
                if(mat[row][col]>biggest){
                    biggest = mat[row][col];
                }
            }
        }
        return biggest;
    }

    // Write a method that "left-shifts" each row in a 2D array.
    // This means that for each row, all the numbers should be
    // shifted to the left by 1, with wraparound (the first value
    // should wrap around to the last entry in the row)
    public static int[][] leftShift(int[][] mat) {
        // YOUR CODE HERE
        // 1 2  3  4
        // 5 6  7  8
        // 9 10 11 12
        for(int row = 0; row<mat.length; row++){
            int temp = mat[row][0];
            for(int col = 0; col<mat[0].length-1;col++){


                mat[row][col] = mat[row][col+1];


            }
            mat[row][mat[row].length -1] = temp;
        }
        return mat;
    }

    // Creates a 2D array of size arraySize x arraySize
    // where each value is each to the sum of its row and col indexes
    public static int[][] arrayBuilder(int arraySize) {
        // YOUR CODE HERE
        int [][] mat = new int[arraySize][arraySize];
        for(int row = 0; row< mat.length; row++){
            for(int col = 0; col<mat[0].length; col++){
                mat[row][col] = row + col;
            }
        }
        return mat;
    }










    // Methods for the homework:

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) {
        double total = 0;
        for(int row = 0; row<mat.length; row++){
            for(int col = 0; col<mat[0].length; col++){
                total += mat[row][col];
            }
        }
        total/=(mat.length)*mat[0].length;
        return total;
    }

    // Returns the median of the 2D array mat
    // Remember that the array is sorted!
    public static double median(double[][] mat) {
        // YOUR CODE HERE
        double median = 0.0;
        ArrayList<Double> list = new ArrayList<Double>();
        for(int row = 0; row<mat.length; row++){
            for(int col = 0; col<mat[0].length; col++){
                list.add(mat[row][col]);
            }
            //if list is even
            // 1 2 3 4 5 6
            if(list.size()%2==0) {
                double mid1 = list.get((list.size()-1)/2);
                double mid2 = list.get((list.size()/2));
                median = (mid1 + mid2) / 2;
            }
            //if list is odd
            if(list.size()%2!=0) {

                median = list.get(list.size() / 2);
            }

        }
        return median;
    }


    // Returns the mode of the 2D array mat
    // Remember that the array is sorted!
    public static double mode(double[][] mat) {
        // YOUR CODE HERE
        //goes through the whole 2d array once
        HashMap <Double,Integer> freqofnums = new HashMap<>();
        int frequency = 0;
        double mode = 0.0;
        for(int row = 0; row<mat.length; row++){
            for(int col = 0; col<mat[0].length; col++){
                // in each iteration of the previous nested loop, I go through the whole 2d array
                // looking for a specific number, and counting how many times it shows up.
                // i then add the double and its frequency to a hashmap

                for(int Row = 0; Row< mat.length; Row++){
                    for(int Col = 0; Col<mat[0].length; Col ++){
                        if(mat[row][col] == mat[Row][Col]){
                            frequency ++;
                        }
                    }
                }
                freqofnums.put(mat[row][col], frequency);
                frequency = 0;
            }
        }
        //loop through the hashmap and return the double that is the most frequent
        int least = 0;
        for (double key : freqofnums.keySet()) {
            if(freqofnums.get(key)>least){
                mode = key;
                least = freqofnums.get(key);
            }
        }
        return mode;
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
    }
}
