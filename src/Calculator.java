import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

public class Calculator {
	private final String delimiter = ",|\n";
	
    public int add(String string1) throws Exception{
    	String[] numbers = string1.split(delimiter);
    	
        if (isEmpty(string1)) {
            return 0;
        }
        if(string1.length()==1) {
        	return stringToInput(string1);
        }
        
        else {
        	return getSum(numbers);
        }
    }
    
    private int getSum(String[] numbers) throws Exception {
    	findDangerousInput(numbers);
    	int sum = 0;
    	for(String current:numbers) {
    		if(stringToInput(current) > 1000) {
    			continue;
    		}
    		sum += stringToInput(current);
    	}
    	return sum;
    }

    private void findDangerousInput(String[] numbers) throws Exception {
    	for(String current:numbers) {
    		if(stringToInput(current)<0) {
    			throw new Exception("Negative Input!");
    		}
    	}
    }
    private boolean isEmpty(String string) {
    	return string.isEmpty();
    }
    
    private int stringToInput(String string) {
    	return Integer.parseInt(string);
    }
}