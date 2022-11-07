package baseball.funtion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.InputValidation;

public class RestartInputValidationTest {

	@Test
	@DisplayName("입력값이 1일 경우")
	void test1() {
		//given
		String input = "1";
		
		InputValidation inputValidation = new InputValidation();
		
		//when
		boolean validation = inputValidation.isValidReStart(input);
		
		//then
		assertThat(validation).isEqualTo(true);
	}
	
	@Test
	@DisplayName("입력값이 2일 경우")
	void test2() {
		//given
		String input = "2";
		
		InputValidation inputValidation = new InputValidation();
		
		//when
		boolean validation = inputValidation.isValidReStart(input);
		
		//then
		assertThat(validation).isEqualTo(true);
	}
	
	@Test
	@DisplayName("입력값이 1과 2가 아닐 경우")
	void test3() {
		//given
		String input = "hi";
		
		InputValidation inputValidation = new InputValidation();
		
		//when
		boolean validation = inputValidation.isValidReStart(input);
		
		//then
		assertThat(validation).isEqualTo(false);
	}
}
