package v3;

import v3.Input.CommandLineInput;
import v3.Input.Input;
import v3.NumberRepository.FileNumberRepository;
import v3.NumberRepository.NumberRepository;
import v3.Operations.AddOperation;
import v3.Operations.AvgOperator;
import v3.Operations.Operation;
import v3.Output.CommandLineOutput;
import v3.Output.Output;

import java.io.IOException;


public class Main {

    
        public static void main(String[] args) throws IOException{
                // --read the operator using command line arguments

                //CommandLineInput commandLineInput= new CommandLineInput(); violating dependency inversion principle.
                Input input = new CommandLineInput();
                String operator = input.getOperator(args);


                //FileNumberRepository numberRepository = new FileNumberRepository(); violating dependency inversion principle
                NumberRepository numberRepository = new FileNumberRepository();
                int[] intNumbers = numberRepository.read();

                // --perform the operation

                double result = 0;
                Operation operation = null;
                if(operator.equals("+")){

                    operation = new AddOperation();

                }else if (operator.equals("avg")){

                   operation = new AvgOperator();

                }
                result = operation.perform(intNumbers);


                // --show output to the user

                //CommandLineOutput commandLineOutput = new CommandLineOutput(); violating dependency inversion principle.
                Output output = new CommandLineOutput();
                output.show("Result: " + result);
        }
}





