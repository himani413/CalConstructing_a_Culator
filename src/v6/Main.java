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


public class Main {
    
        public static void main(String[] args) {

                Input input = new CommandLineInput(args);
                NumberRepository numberRepository = new FileNumberRepository();
                OperationFactory operationFactory = new OperationFactory();
                Output output = new CommandLineOutput();

                Calculator calculator = new Calculator(input,numberRepository,operationFactory,output);
                calculator.Execute();
        }
}





