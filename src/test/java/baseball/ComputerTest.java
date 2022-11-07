package baseball;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	void computer가_생성한_숫자가_유효한지(){
		ArrayList<Integer> targetNumber = new ArrayList<>();
		Computer computer = new Computer(targetNumber);
		computer.generateNumber();
		boolean isValidate = true;
		try {
			Validate.checkCorrectInput(makeListToString(computer.getTargetNumber()));
		}catch (IllegalArgumentException e){
			isValidate = false;
		}
		assertThat(isValidate).isEqualTo(true);
	}

	public static String makeListToString(ArrayList<Integer> numbers){
		String num = "";
		for (Integer number: numbers){
			num += String.valueOf(number);
		}
		return num;
	}
}
