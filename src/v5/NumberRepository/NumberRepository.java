package v5.NumberRepository;

public interface NumberRepository {

    int[] read() throws NumberRepositoryException; //a custom exception instead of (IOException, SQLDataException, SQLException;)
    //changing interface method signature is a bad practice. It should be rock solid.
}

//that's why we need custom exception types.