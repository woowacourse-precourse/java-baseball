package baseball.util;

import static baseball.util.Converter.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ConverterTest {

	@Test
	void convertStringToIntegerList_메소드로_문자열을_정수_리스트로_변환() {
		//when, then
		assertThat(convertStringToIntegerList("746")).isInstanceOf(ArrayList.class);
	}
}