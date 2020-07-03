package tdd;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator 
{
    public int add(String numbers) {
        if(numbers != null && numbers == "") {
            return 0;
        }
        if(StringUtils.isNotBlank(numbers)) {
            String[] numbersList = numbers.split(",");
            int result = 0;
            for(int i = 0; i < numbersList.length; i++) {
                result = result + Integer.parseInt(numbersList[i]);
            }
            return result;
        }
        return -1;
    }
}
