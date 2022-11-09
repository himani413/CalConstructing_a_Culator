package v3.NumberRepository;

import java.io.IOException;

public interface NumberRepository {

    int[] read() throws IOException; //todo: change exception handling mechanism.
}
