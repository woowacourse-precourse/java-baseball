package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

	@BeforeAll 
	static void initAll() {//클래스에 있는 모든 테스트 전에 실행

	}
	@BeforeEach
	void init() {//각각의 테스트 실행 전에 실행하고, 테서트 메서드는 반환값이 void이며 non-static한 메서드여야한다

	}

	@Test
	void a_few_simple_assertions() {//테스트 메소드임을 어노테이션으로 선언
		assertThat("스트라이크 볼  of the 낫싱").isNotNull()
		.startsWith("스트라이크")
		.contains("볼")
		.endsWith("낫싱");
	}

	@Test
	void split_메서드로_주어진_값을_구분() {
		String input = "1,2";
		String[] result = input.split(",");

		assertThat(result).contains("2", "1");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
		String input = "1";
		String[] result = input.split(",");

		assertThat(result).contains("1");
	}

	@RepeatedTest(3) //해당 테스트를 3번 반복한다
	void substring_메서드로_특정_구간_값을_반환() {
		String input = "(1,2)";
		String result = input.substring(1, 4);

		assertThat(result).isEqualTo("1,2");
	}

	@Test
	void charAt_메서드로_특정_위치의_문자_찾기() {
		String input = "abc";
		char charAtElement = input.charAt(0);
		assertThat(charAtElement).isEqualTo('a');
	}

	@Test
	void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
		String input = "abc";

		assertThatThrownBy(() -> input.charAt(5))
		.isInstanceOf(StringIndexOutOfBoundsException.class)
		.hasMessageContaining("String index out of range: 5");
	}


}
