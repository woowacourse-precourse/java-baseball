package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ParserTest {
	@ParameterizedTest(name = "길이가 1이상인 문자열 ''''{0}''''을 char list 로 파싱 ==> {1}")
	@MethodSource("generateStringInputs")
	void parsingNonEmptyStringToCharListTest(String str, List<Character> expected) {
		// given : 길이가 1이상인 문자열(str)이 주어졌을 때

		// when : 문자열을 파싱
		List<Character> result = Parser.parseStringToCharList(str);

		// then : 결과 확인
		assertThat(result).isEqualTo(expected);
	}

	private static Stream<Arguments> generateStringInputs() {
		return Stream.of(
				Arguments.of("ubu", List.of('u', 'b', 'u')),
				Arguments.of("123", List.of('1', '2', '3')),
				Arguments.of("329", List.of('3', '2', '9')),
				Arguments.of("1", List.of('1'))
		);
	}

	@DisplayName("빈 문자열이 들어왔을 때 빈 Character type list 로 파싱 되는지 확인")
	@Test
	void parsingEmptyStringToCharListTest() {
		// given : 빈 문자열이 주어졌을 때
		final String emptyString = "";

		// when : 빈 문자열을 char list 로 parsing
		List<Character> result = Parser.parseStringToCharList(emptyString);

		// 에러 없이 정상적으로 파싱 되는지 확인
		final List<Character> expected = Collections.emptyList();
		assertThat(result).isEqualTo(expected);
	}

}