import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
	private Calculator calculator;
	
	@BeforeTest
	public void init() {
		calculator = new Calculator();
	}
	
    @Test
	public void emptyStringReturnZero() throws Exception {
//      Assertions.assertThat(Calculator.add("")EqualTo(0);
        assertEquals(calculator.add(""),0);
    }

    @Test
	public void singleValueIsReplied() throws Exception {
    	assertEquals(calculator.add("1"),1);
    }

    @Test
    void twoNumbersCommaDelimitedReturnSum() throws Exception {
    	assertEquals(calculator.add("1,2"),3);
    }

    @Test
    void twoNumbersNewLineDelimitedReturnsSum() throws Exception {
    	assertEquals(calculator.add("1\n2"),3);
    }
    @Test
    void threeNumbersDelimitedBothWaysReturnsSum() throws Exception {
    	assertEquals(calculator.add("1,2,3"),6);
    }

    @Test(expectedExceptions = Exception.class)
    void negativeInputReturnsException() throws Exception {
    	calculator.add("-1");
    }
    @Test
    void ignoreNumbersGreaterThan1000() throws Exception {
    	assertEquals(calculator.add("10,10,1001"),20);
    }
}