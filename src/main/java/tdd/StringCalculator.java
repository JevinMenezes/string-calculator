package tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator 
{
    public int add(String numbers) throws NumberFormatException{
        List<String> delimiter = Arrays.asList(","); //default delimiter
        String negativesNotAllowedMsg = "negatives not allowed : ";
        Boolean multipleNegatives = false;
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

                if(StringUtils.isNotBlank(numbersList[i]) && Integer.parseInt(numbersList[i]) < 0) {
                    if(multipleNegatives) {
                        negativesNotAllowedMsg = negativesNotAllowedMsg + "," + numbersList[i];
                    }
                    else{
                        negativesNotAllowedMsg += numbersList[i];
                        multipleNegatives = true;
                    }

                }
                    

                if (StringUtils.isNumeric(numbersList[i]))
                    result += Integer.parseInt(numbersList[i]);
            }
            if(negativesNotAllowedMsg.equalsIgnoreCase("negatives not allowed : ")) {
                return result;
            }
            else {
                throw new NumberFormatException(negativesNotAllowedMsg);
            }
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
