package baseball.funtion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.InputValidation;

public class RandomNumberInputValidationTest {
	@Test
	@DisplayName("3자리 서로 다른 수 입력될 경우")
	void test1() {
		//given
		String input = "135";
		InputValidation inputValidation = new InputValidation();
		
		//when
		boolean validation = inputValidation.isValidRandomNumbers(input);
		
		//then
		assertThat(validation).isEqualTo(true);
	}
	
	
	@Test
	@DisplayName("3자리수 중 같은 수 입력될 경우")
	void test2() {
		//given
		String input = "335";
		InputValidation inputValidation = new InputValidation();
		
		//when
		boolean validation = inputValidation.isValidRandomNumbers(input);
		
		//then
		assertThat(validation).isEqualTo(false);
	}
	
	
	@Test
	@DisplayName("3자리가 아닌 수가 입력될 경우")
	void test3() {
		//given
		String input = "1234";
		InputValidation inputValidation = new InputValidation();
		
		//when
		boolean validation = inputValidation.isValidRandomNumbers(input);
		
		//then
		assertThat(validation).isEqualTo(false);
	}
	
	
	@Test
	@DisplayName("숫자가 아닌 문자가 입력될 경우")
	void test4() {
		//given
		String input = "lee";
		InputValidation inputValidation = new InputValidation();
		
		//when
		boolean validation = inputValidation.isValidRandomNumbers(input);
		
		//then
		assertThat(validation).isEqualTo(false);
	}
}
