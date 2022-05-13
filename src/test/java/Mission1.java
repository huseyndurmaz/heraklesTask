import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mission1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("First enter the size of numbers; then enter random numbers and use some zeros");

        int size = input.nextInt();                         //get the size of List from Scanner input
        List<Integer> numbers = new ArrayList<>();          //create List numbers
            for (int i=0; i<size; i++) {                    //assign values from Scanner input
                numbers.add(input.nextInt());
            }

        int counter = 0;                                    //MAKE SURE that user entered Zero
        for (Integer number : numbers) {
            if(number==0){
                counter++;
            }
        }

        if(counter==0){                                     //when Zero is not entered, warn the user
            System.out.println("You did not enter Zero. Please try again.");
            return;
        }

        System.out.println("Numbers after moving zeros to the end = " + pushZerosToEnd(numbers));  //call the method
    }


    public static List<Integer> pushZerosToEnd(List <Integer> numbers){
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {                    //check each number
            if (number != 0) {                              //if number is not Zero, add number to List
                result.add(number);
            }
        }
        while (result.size() < numbers.size()) {            //complete rest of the List with Zeros at the end
                result.add(0);
        }
        return result;
    }
}