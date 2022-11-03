package baseball.funtion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.RandomNumber;

public class CreateRamdomNumbersTest {

	@Test
	@DisplayName("0~9까지 모두 다른 랜덤값 3개 받아오기")
	void test1() {
		//given
		int start = 0, end = 9, size = 3;
		RandomNumber randomNumberFunction = new RandomNumber();
		
		//when
		List<Integer> randomNumberList = randomNumberFunction.createRamdomNumbers(start, end, size);
		
		//then
		assertThat(randomNumberList.size()).isEqualTo(size);
		
		for(Integer randomNumber : randomNumberList) {
			assertThat(randomNumber).isGreaterThanOrEqualTo(start);
			assertThat(randomNumber).isLessThanOrEqualTo(end);
		}
		
		
		Set<Integer> randomNumberSet = new HashSet<>();
		for(Integer randomNumber : randomNumberList) {
			randomNumberSet.add(randomNumber);
		}
		
		assertThat(randomNumberSet.size()).isEqualTo(size);
	}
	
	
	@Test
	@DisplayName("시작 숫자가 끝 숫자보다 클 경우")
	void test2() {
		//given
		int start = 5, end = 0, size = 3;
		RandomNumber randomNumberFunction = new RandomNumber();
		
		//when&&then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
				() -> randomNumberFunction.createRamdomNumbers(start, end, size));
		
		assertThat(exception.getMessage())
		      .isEqualTo("startInclusive cannot be greater than endInclusive.");
	}
	
	
	@Test
	@DisplayName("사이즈가 음수일 경우")
	void test3() {
		//given
		int start = 0, end = 9, size = -3;
		RandomNumber randomNumberFunction = new RandomNumber();

		
		//when&&then
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
				() -> randomNumberFunction.createRamdomNumbers(start, end, size));
		
		assertThat(exception.getMessage())
		      .isEqualTo("count cannot be less than zero.");
	}
}
