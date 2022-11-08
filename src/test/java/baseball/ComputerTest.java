package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

	@Test
	void getThreeRandomNumber() {
		Computer computer = new Computer(3);
		computer.getThreeRandomNumber();
		boolean status = computer.numberList.get(0) == computer.numberList.get(1) ||
				computer.numberList.get(1) == computer.numberList.get(2) ||
				computer.numberList.get(0) == computer.numberList.get(2);
		assertEquals(status, false);
	}
}