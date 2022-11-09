package v6.Input;

public class CommandLineInput implements Input {

    private  String[] args;

    public CommandLineInput( String[] args){
        this.args = args;
    }

    public String getOperator() throws InputException {

            if(args == null || args.length == 0){

                throw new InputException("There must be at least one command line argument.");
            }
        return args[0];//--> unchecked exception
    }

}
