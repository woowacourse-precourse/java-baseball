package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

	InputValidator inputValidator = new InputValidator();

	@Nested
	class validateAnsStringTest {

		@Test
		void 정상적인_문자열() {
			String ansString = "123";
			assertDoesNotThrow(() -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 길이가_3초과하는_입력_문자열() {
			String ansString = "6789";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 길이가_3미만인_입력_문자열1() {
			String ansString = "";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 길이가_3미만인_입력_문자열2() {
			String ansString = "44";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 숫자가_아닌_입력_문자열1() {
			String ansString = "가12";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 숫자가_아닌_입력_문자열2() {
			String ansString = "3A0";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 숫자가_아닌_입력_문자열3() {
			String ansString = "30+";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 동일한_숫자가_포함된_문자열1() {
			String ansString = "788";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 동일한_숫자가_포함된_문자열2() {
			String ansString = "303";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 동일한_숫자가_포함된_문자열3() {
			String ansString = "900";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}

		@Test
		void 맨_앞자리가_0인_문자열() {
			String ansString = "031";
			assertThrows(IllegalArgumentException.class, () -> inputValidator.validateAnsString(ansString));
		}
	}

}
