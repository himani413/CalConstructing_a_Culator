package v5.Input;

public class CommandLineInput implements Input { // single responsible class

    public String getOperator(String[] arg) throws InputException{ //todo: move args to constructor

            if(arg == null || arg.length == 0){

                throw new InputException("There must be at least one command line argument.");
            }
        return arg[0];//--> unchecked exception
    }

}
