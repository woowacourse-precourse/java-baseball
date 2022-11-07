package baseball;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ResultComparisonTest {
	ResultComparison resultComparison = new ResultComparison();
	@Test
	void printTest() {
        assertTrue(resultComparison.print("123", "123"));
        assertFalse(resultComparison.print("123", "456"));
        assertFalse(resultComparison.print("123", "189"));
        assertFalse(resultComparison.print("123", "129"));
        assertFalse(resultComparison.print("123", "312"));
	}// mainTest
}// end class
