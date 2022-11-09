package v3.Input;

import v3.Input.Input;

public class CommandLineInput implements Input { // single responsible class

    public String getOperator(String[] arg){ //todo: move args to constructor

        return arg[0];
    }

}
