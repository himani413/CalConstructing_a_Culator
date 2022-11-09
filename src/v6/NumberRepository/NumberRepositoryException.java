package v6.NumberRepository;

import java.io.IOException;

public class NumberRepositoryException  extends Exception{
    public NumberRepositoryException(String s, IOException exception) {

        super(s,exception);
    }

    //this class is for all the exceptions type which will generate in number repository package.
}
