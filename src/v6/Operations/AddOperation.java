package v6.Operations;

public class AddOperation implements Operation {

    public double perform(int[] numbers){
        double result = 0;
        for(int i = 0; i<numbers.length; i++){
            result += numbers[i];
        }

        return result;
    }
}
