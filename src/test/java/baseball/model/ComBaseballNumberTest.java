package baseball.model;

import java.util.List;

import org.junit.jupiter.api.Test;

class ComBaseballNumberTest {
	@Test
	void 랜덤한_BaseballNumber_생성(){
		ComBaseballNumber comBaseballNumber = new ComBaseballNumber();
		List<Integer> numbers = comBaseballNumber.getNumbers();
		System.out.println("numbers = " + numbers);
	}
}