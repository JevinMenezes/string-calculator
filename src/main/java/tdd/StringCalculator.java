package tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator 
{
    public int add(String numbers) {
        List<String> delimiter = Arrays.asList(","); //default delimiter
        if(numbers.startsWith("//")){
            String delimiters = numbers.split("\n")[0].replace("//","");
            delimiter = new ArrayList<String>(0);
            for(int c = 0; c < delimiters.length(); c++) {
                delimiter.add(Character.toString(delimiters.charAt(c)));
            }
            numbers = numbers.split("\n")[1];
        }
            

        if(numbers != null && numbers == "")
            return 0;

        if(StringUtils.isNotBlank(numbers)) {
            numbers = numbers.replace("\n", delimiter.get(0));
            String[] numbersList = numbers.split(delimiter.get(0));
            int result = 0;
            for(int i = 0; i < numbersList.length; i++) {
                if (StringUtils.isNumeric(numbersList[i]))
                    result += Integer.parseInt(numbersList[i]);
            }
            return result;
        }
        
        return -1;
    }

    /**
     * For unknown amount of numbers
     */
    public int add(Integer... numbers) {
        int result = 0;
        for(Integer number : numbers) {
            result += number;
        }
        return result;
    }

}
