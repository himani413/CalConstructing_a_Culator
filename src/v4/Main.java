package v4;

import v4.Input.CommandLineInput;
import v4.Input.Input;
import v4.NumberRepository.FileNumberRepository;
import v4.NumberRepository.NumberRepository;
import v4.Operations.AddOperation;
import v4.Operations.AvgOperator;
import v4.Operations.Operation;
import v4.Operations.OperationFactory;
import v4.Output.CommandLineOutput;
import v4.Output.Output;

import java.io.IOException;


public class Main {

    
        public static void main(String[] args) throws IOException{

                // --read the operator using command line arguments
                Input input = new CommandLineInput();
                String operator = input.getOperator(args);

                NumberRepository numberRepository = new FileNumberRepository();
                int[] intNumbers = numberRepository.read();

                // --perform the operation
/*              //violating the single responsibility principle and there is a decision-making which should move to a worker class.
                double result = 0;
                Operation operation = null;
                if(operator.equals("+")){

                    operation = new AddOperation();

                }else if (operator.equals("avg")){

                   operation = new AvgOperator();

                }
                result = operation.perform(intNumbers);

*/



                //using the factory design pattern to create an object
                OperationFactory operationFactory = new OperationFactory();
                Operation operation = operationFactory.getInstance(operator);

                // --perform the operation
                double result = operation.perform(intNumbers);

                // --show output to the user
                Output output = new CommandLineOutput();
                output.show("Result: " + result);
        }

        //ALL THE COORDINATION ARE HAPPENING IN THIS MAIN CLASS NOW
}





