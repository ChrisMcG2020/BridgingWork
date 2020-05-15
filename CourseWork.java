package Cousework;

/*Created by ChrisMcGlynn
11th Jan 2019
Bridging Coursework
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CourseWork {


    public static int[] readArrayFromFile(String filename) {
        /*
        Description: Reads an array from file using UUlib.
        Parameters:  filename of textfile.
        Returns: int array of numbers
        */
        int[] array = new int[1];

        try {

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String c = br.readLine();
            Integer size = Integer.parseInt(c);
            array = new int[size];
            System.out.println(array.length);

            for (int i = 0; i < size; i++) {

                c = br.readLine();
                array[i] = Integer.parseInt(c);
                System.out.println(array[i]);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return array;
    }

    public static int countPositiveValues(int[] array) {
        /*
        Description: Counts the positive integer values in an array
        Parameters:  int array to be counted
        Returns: int number of positive values
        */

        int positive = 0;//set number of positives to 0

        //for loop to run through each element
        for (int i = 0; i < array.length; i++) {
            //if loop to increment the positive count
            if (array[i] >= 0) {
                positive++;
            }//if
        }//for
        return positive;
    }

    public static int countNegativeValues(int[] array) {
        /*
        Description: Counts the negative integer values in an array
        Parameters:  int array to be counted
        Returns: int number of negative values
        */

        int negative = 0;//set number of negatives to 0

        //for loop to run through each element
        for (int i = 0; i < array.length; i++) {
            //if loop to increment if there are any negatives
            if (array[i] < 0) {
                negative++;
            }//if
        }//for
        return negative;
    }

    public static int countZeroValues(int[] array) {
        /*
        Description: Counts the zero integer values in an array
        Parameters:  int array to be counted
        Returns: int number of zero values
        */

        int noOfZeros = 0;//set the counter to 0

//loop through the array checking for 0 if present increment the noOfZeros counter
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                noOfZeros++;
            }//if
        }//for
        return noOfZeros;
    }


    public static double meanArrayValue(int[] array) {
        /*
        Description: Computes mean value from an array
        Parameters:  int array of values from which mean is computed
        Returns: double calculated mean value
        */

        double mean = 0, sumOf = 0;//initialise the two variables to 0
        //loop through the array
        for (int i = 0; i < array.length; i++) {
            sumOf = sumOf + array[i];//add up all elements
        }//for
        mean = sumOf / array.length;//formula for finding the mean

        return mean;

    }

    public static double medianArrayValue(int[] array) {
        /*
        Description: Computes median value from a sorted array
        Parameters:  int array of values from which median is computed
        Returns: double calculated median value
        Note: Array must be sorted!
         */
        Arrays.sort(array);//sorts the array numerically

        double median, sumOfMiddleElements;

        //formula if array is even
        if (array.length % 2 == 0) {
            sumOfMiddleElements = array[array.length / 2] + array[array.length / 2 - 1];

            median = sumOfMiddleElements / 2;

        } else {
            median = ((double) array.length / 2);//formula if array is not even


        }//if
        return median;
    }


    public static int modeArrayValue(int[] array) {
        /*
        Description: Computes the first mode value from a sorted array
        Parameters:  int array of values from which mode is computed
        Returns: int first mode value
        Note: Array must be sorted!
        */

        Arrays.sort(array);

        int mode = 0, max = 0;
        //for loop to loop array
        for (int i = 0; i < array.length; i++) {
            int noOfOccurences = 0;

            //create an inner loop to loop again and compare similar numbers
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) { //if similar number found the increment the amount of times it appears
                    noOfOccurences++;
                }//for
            }

            //if the current number appears more often than the number which previously
            // held the record for the most number of appearances then it becomes the mode

            if (noOfOccurences > max) {
                max = noOfOccurences;
                mode = array[i];
            }//if
        }//outer

        return mode;

    }

    public static int minArrayValue(int[] array) {
        /*
        Description: Computes minimum value from an int array
        Parameters:  int array of values from which to find minimum
        Returns: int minimum value
        */


        int minValue = array[0];//assign the min value to first number in the array
        //loop through array assigning min value as it loops
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }//if
        }//for
        return minValue;
    }

    public static int maxArrayValue(int[] array) {
        /*
        Description: Computes maximum value from an int array
        Parameters:  int array of values from which to find maximum
        Returns: int maximum value
        */


        int maxValue = array[0];//assign the max value  to the first number in the array
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }//if
        }//for
        return maxValue;
    }

    public static void swap(int[] array, int posA, int posB) {
        /*
        Description: Swaps two values in an int array
        Parameters:  int array of values and positions of elements to be swapped
        Returns: void
        */
        int tmp = array[posA];
        array[posA] = array[posB];
        array[posB] = tmp;
    }

    public static void bubbleSort(int[] array) {
        /*
        Description: Sorts a int array using bubblesort algoritm
        Parameters:  int array of values to be sorted
        Returns: void
        */
        int ncomps = 0, nswaps = 0; // declare and initialise counters
        for (int out = array.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                ncomps++; // increment number of comparisons
                if (array[in] > array[in + 1]) {
                    nswaps++;  // increment number of swaps
                    swap(array, in, in + 1);
                }//if
            }//inner for
        }//outer for
        System.out.println("Comps=" + ncomps + " Swaps=" + nswaps);
    }

    public static int binarySearch(int array[], int key) {
        /*
        Description: Performs binary search on an array for a specified value
        Parameters:  int array of values and int key which item to be searched
        Returns: int indicating first location of item, or -1 in case not found
        */

        // Task: Complete method code

        int bottom = 0, top = array.length - 1, middle, location = 0, comparisons = 0;//comparisons set to 0 to increment until loop has found key
        boolean found = false;


        for (int i = 0; i < array.length; i++) {
            do {
                middle = (top + bottom) / 2;
                if (array[middle] == key) {
                    found = true;
                    location = middle;
                    comparisons++;//this will increase until the key is found
                } else if (array[middle] < key) {
                    bottom = middle + 1;
                    comparisons++;
                } else {
                    top = middle - 1;
                    comparisons++;
                }
            }
            while (!(found) && (bottom <= top));
            if (found) {
                System.out.println("The Location of the key is " + location);
                break;
            }


        }
        System.out.println("\nThe number of comparisons is " + comparisons);

        return location;

    }

    public static void find2Smallest(int array[]) {
        int i, first, second;

        first = second = array.length;
        for (i = 0; i < array.length; i++) {
            if (array[i] < first) {
                second = first;
                first = array[i];
            } //
            else if (array[i] < second && array[i] != first)
                second = array[i];
        }//if
        System.out.println("The smallest element is " + first
                + " and the second smallest is " + second);

    }//method


    public static void factor(int[] array) {
        int factor;
        Scanner keyboard=new Scanner(System.in);
        int noOfMultiples = 0;

        System.out.println("Please enter a number: ");
        factor=keyboard.nextInt();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % factor == 0) {
                noOfMultiples++;
            }//if
        }//for
       System.out.println ("The  number of Multiples of "+factor+" is "+noOfMultiples);
    }//method

    public static void sumOf(int[] array) {

        Scanner keyboard = new Scanner(System.in);
        int sum, num1, num2;

        System.out.println("Please enter your first number location");
        num1 = keyboard.nextInt();
        System.out.println("Please enter your second number location");
        num2 = keyboard.nextInt();

            sum = array[num1] + array[num2];

            System.out.println(sum);

    }

    //method
    public static void reverse(int[] array) {


        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;

            System.out.println(Arrays.toString(array));

        }

    }
    public static void swapNumbers(int [] array) {


            int temp = array[3];
            array[3] = array[10];
            array[10] = temp;

            System.out.print(Arrays.toString(array));


    }
    /*int [] numbers = {53, 45, 30, 67, 23}
2 int search, index = 0;
3 boolean found = false;
4
5 System.out.print("Enter search number: ");
6 search = keyboard.nextInt();
7
8 while (!(found)) {
9 if (numbers[index] == search) {
10 found = true;
11 System.out.println (search + " has been found at location "
+ index);
12 }//if
13 index = index + 1;
14 }//*/

    public static void searchArray(int [] array) {
        Scanner keyboard = new Scanner(System.in);

        int search, index = 0;
        boolean found = false;
        System.out.println("Please enter a number to search: ");
        search = keyboard.nextInt();

        while (!(found)) {
            if (array[index] == search) {
                found = true;
                System.out.println("The number " + search + " has been found at location " + index);


                index = index + 1;
            } else System.out.println("Not Found");
            break;
        }
    }
 public static void replaceNumbers(int [] array) {
     Scanner keyboard = new Scanner(System.in);
     for (int i = 0; i < array.length; i++) {
         System.out.println("Please enter a number or -1 to exit");
         int userInput = keyboard.nextInt();
         if (userInput != -1) {
             array[i] = userInput;

         } else {
             System.out.println("You have chosen to exit!");

         }
     }

 }


    public static void main(String[] args) {


        // Task: Complete main method below
        // Read array from supplied text file (practice.txt) using method provided

        // Sort array using Bubble sort (code provided)

        // Compute the following stats from array obtained from text file
        // Total number of positive values
        // Total number of negative values
        // Total number of zero values
        // Minimum value
        // Maximum value
        // Mean, median and mode values
        // Search for key = 3555318 using Binary search

        int [] numbers=readArrayFromFile("practice");
        System.out.println();
        System.out.println("Bubble sort:");
        bubbleSort(numbers);
        System.out.println();
        System.out.println ("Key= 7833106");
        binarySearch(numbers, 7833106);
        System.out.println();
        System.out.println ("The number of positive values is "+countPositiveValues(numbers)+"\n");
        System.out.println("The number of negative values is "+countNegativeValues(numbers)+"\n");
        System.out.println ("The number of Zeroes is "+countZeroValues(numbers)+"\n");
        System.out.println("The minimum value found is "+minArrayValue(numbers)+"\n");
        System.out.println ("The maximum value in the array is "+ maxArrayValue(numbers)+"\n");
        System.out.println ("The mean of the array is "+meanArrayValue(numbers)+"\n");
        System.out.println ("The median value is "+medianArrayValue(numbers)+"\n");
        System.out.println ("The mode value is "+ modeArrayValue(numbers)+"\n");
        find2Smallest(numbers);
        System.out.println();
     factor (numbers);
        sumOf(numbers);
        searchArray(numbers);
        swapNumbers(numbers);
        searchArray(numbers);
        replaceNumbers(numbers);
        reverse(numbers);







    }
}






