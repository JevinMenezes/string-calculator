package tdd;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator 
{
    public int add(String numbers) {
        if(numbers != null && numbers == "")
            return 0;

        if(StringUtils.isNotBlank(numbers)) {
            numbers = numbers.replace("\n", ",");
            String[] numbersList = numbers.split(",");
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
