package v6;

import v6.Input.CommandLineInput;
import v6.Input.Input;
import v6.Input.InputException;
import v6.NumberRepository.FileNumberRepository;
import v6.NumberRepository.NumberRepository;
import v6.NumberRepository.NumberRepositoryException;
import v6.Operations.Operation;
import v6.Operations.OperationFactory;
import v6.Output.CommandLineOutput;
import v6.Output.Output;

public class Calculator {


    private Input input;
    private NumberRepository numberRepository;
    private OperationFactory operationFactory;
    private Output output;

    //constructor level injection
    public Calculator(
            Input input,
            NumberRepository numberRepository,
            OperationFactory operationFactory,
            Output output
    ){
        this.input = input;
        this.numberRepository = numberRepository;
        this.operationFactory = operationFactory;
        this.output = output;
    }

    public void  Execute(){

        // --read the operator using command line arguments

        String operator;
        try {
            operator = input.getOperator();
        } catch (InputException e) {
            //exception.printStackTrace(); //bad practice!!!
            //System.out.println(); //bad practice
            //log the exception into a file using a library like log4j
            //Logger.error("Exception occurred while reading the operator", exception);

            return; // sometimes we should return, but sometimes it's not necessary.

        }


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

        Operation operation = operationFactory.getInstance(operator);

        // --perform the operation
        double result = operation.perform(intNumbers);

        // --show output to the user


        output.show("Result: " + result);
    }
}

    //Dependencies!!!
//What are the dependencies to the Calculator class?
    //Input/CommandLineInput
    //NumberRepository/SQLNumberRepository
    //OperationFactory
    //Output/CommandLineOutput