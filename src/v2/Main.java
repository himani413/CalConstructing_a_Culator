package v2;

import v2.Operations.AddOperation;
import v2.Operations.AvgOperator;

import java.io.IOException;


public class Main {

          //violating dependency inversion principle.
    
        public static void main(String[] args) throws IOException{
                // --read the operator using command line arguments
                CommandLineInput commandLineInput = new CommandLineInput();
                String operator = commandLineInput.getOperator(args);

                FileNumberRepository numberRepository = new FileNumberRepository();
                int[] intNumbers = numberRepository.read();

                // --perform the operation
                double result = 0;
                if(operator.equals("+")){

                    AddOperation addOperation = new AddOperation();
                    result = addOperation.perform(intNumbers);

                }else if (operator.equals("avg")){

                    AvgOperator avgOperator = new AvgOperator();
                    result = avgOperator.perform(intNumbers);
                    result = result/ intNumbers.length;
                }

                // --show output to the user
            CommandLineOutput commandLineOutput = new CommandLineOutput();
                commandLineOutput.show("Result: " + result);
        }
}





