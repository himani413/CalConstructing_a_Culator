package v5;

import v5.Input.CommandLineInput;
import v5.Input.Input;
import v5.Input.InputException;
import v5.NumberRepository.FileNumberRepository;
import v5.NumberRepository.NumberRepository;
import v5.NumberRepository.NumberRepositoryException;
import v5.Operations.Operation;
import v5.Operations.OperationFactory;
import v5.Output.CommandLineOutput;
import v5.Output.Output;

// Main class is the coordinator of this application
public class Main {
    
        public static void main(String[] args) {

                // --read the operator using command line arguments
                Input input = new CommandLineInput();
                String operator = null;
                try {
                        operator = input.getOperator(args);
                } catch (InputException e) {
                        //exception.printStackTrace(); //bad practice!!!
                        //System.out.println(); //bad practice
                        //log the exception into a file using a library like log4j
                        //Logger.error("Exception occurred while reading the operator", exception);

                        return; // sometimes we should return, but sometimes it's not necessary.

                }

                NumberRepository numberRepository = new FileNumberRepository();
                int intNumbers[] = null;
                try {
                         intNumbers = numberRepository.read();
                }catch (NumberRepositoryException exception){//violation of abstraction principle

                        //exception.printStackTrace(); //bad practice!!!
                        //System.out.println(); //bad practice
                        //log the exception into a file using a library like log4j
                        //Logger.error("Exception occurred while reading the numbers", exception);

                        return; // sometimes we should return, but sometimes it's not necessary.
                }

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





