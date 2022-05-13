import java.util.Arrays;
import java.util.Scanner;

public class MissionExtraWithArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("First enter the size of numbers; then enter random numbers and use some zeros");

        int size = input.nextInt();                 //get the size of array from Scanner input
        int[] numbers = new int[size];              //create Array numbers
            for (int i=0; i<size; i++) {            //assign values from Scanner input
                numbers[i] = input.nextInt();
            }

        int counter = 0;                                    //MAKE SURE that user entered Zero
        for (int number : numbers) {
            if(number==0){
                counter++;
            }
        }

        if(counter==0){                                     //when Zero is not entered, warn the user
            System.out.println("You did not enter Zero. Please try again.");
            return;
        }

        System.out.println("Numbers after moving zeros to the end = " + Arrays.toString(pushZerosToEnd(numbers))); //call the method
    }


    public static int[] pushZerosToEnd(int[] numbers){
        int counter=0;

        for (int i = 0; i<numbers.length; i++) {    //check each number
            if(numbers[i] !=0){                     //if number is not Zero, add number to Array
                numbers[counter++]=numbers[i];
            }
        }
        while(counter<numbers.length){              //complete rest of the Array with Zeros at the end
            numbers[counter++]=0;
        }
        return numbers;
    }
}