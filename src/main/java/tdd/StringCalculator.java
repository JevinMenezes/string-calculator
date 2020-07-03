package tdd;

public class StringCalculator 
{
    public int add(String numbers) {
        if(numbers != null && numbers == "") {
            return 0;
        }
        return -1;
    }
}
