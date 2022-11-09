package v6.NumberRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileNumberRepository implements NumberRepository {
    private  String filename = "C:\\Users\\Himani Perera\\Software Engineering\\Year 2 - 1st Semester\\SENG 21222-software construction\\test\\src\\numbers.txt";
    public int[] read() throws NumberRepositoryException {
        List<String> lines;
        try {
            // --read the numbers from the text file
             lines = Files.readAllLines(Paths.get(filename));//-->throws a checked exception

        }catch (IOException exception){

            throw new NumberRepositoryException("Failed to read the numbers file" +filename, exception);
        }

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
