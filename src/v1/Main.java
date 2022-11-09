package v1;

import java.io.IOException;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;


public class Main {
                //single responsibility principle - violated
                //open-closed principle - violated

        public static void main(String[] args) throws IOException{
                // --read the operator using command line arguments
                String operator = args[0];
                System.out.println("operator is " + operator);


                // --read the numbers from the text file
                List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Himani Perera\\Software Engineering\\Year 2 - 1st Semester\\SENG 21222-software construction\\test\\src\\numbers.txt"));
                String firstLine = lines.get(0);

                //split first line by comma
                String[] numbers = firstLine.split(",");

                //convert numbers into integers
                int[] intNumbers = new int[numbers.length];
                for(int i = 0; i< numbers.length; i++){
                    intNumbers[i] = Integer.parseInt(numbers[i]);
                }

                // --perform the operation
            //multiple responsibilities.............
                double result = 0;
                if(operator.equals("+")){
                    //add all the numbers
                    for(int i = 0; i<intNumbers.length; i++){
                        result += intNumbers[i];
                    }
                }else if (operator.equals("avg")){
                    //calculate the average
                    for(int i = 0; i< numbers.length; i++){
                        result += intNumbers[i];
                    }
                    result = result/ intNumbers.length;
                }

                // --show output to the user
            System.out.println("Result: " + result);
        }
}





