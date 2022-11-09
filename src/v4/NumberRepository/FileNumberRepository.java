package v4.NumberRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileNumberRepository implements NumberRepository {

    public int[] read() throws IOException { //todo: change the exception handling mechanism

        // --read the numbers from the text file
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Himani Perera\\Software Engineering\\Year 2 - 1st Semester\\SENG 21222-software construction\\test\\src\\numbers.txt"));
        String firstLine = lines.get(0);

        //split first line by comma
        String[] numbers = firstLine.split(",");

        //convert numbers into integers
        int[] intNumbers = new int[numbers.length];
        for(int i = 0; i< numbers.length; i++){
            intNumbers[i] = Integer.parseInt(numbers[i]);
        }

        return  intNumbers;
    }
}
