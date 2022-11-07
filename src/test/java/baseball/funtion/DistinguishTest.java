package baseball.funtion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Distinguisher;

public class DistinguishTest {

	@Test
	@DisplayName("3스트라이크")
	void test1() {
		//given
		List<Integer> randomNumber = Arrays.asList(1, 3, 5);
		String input = "135";
		
		Distinguisher distinguisher = new Distinguisher();
		
		//when
		String output = distinguisher.distinguish(randomNumber, input);
		
		//then
		assertThat(output).isEqualTo("3스트라이크");
	}
	
	@Test
	@DisplayName("3볼")
	void test2() {
		//given
		List<Integer> randomNumber = Arrays.asList(1, 3, 5);
		String input = "513";
		
		Distinguisher distinguisher = new Distinguisher();
		
		//when
		String output = distinguisher.distinguish(randomNumber, input);
		
		//then
		assertThat(output).isEqualTo("3볼");
	}
	
	@Test
	@DisplayName("2볼 1스트라이크")
	void test3() {
		//given
		List<Integer> randomNumber = Arrays.asList(1, 3, 5);
		String input = "153";
		
		Distinguisher distinguisher = new Distinguisher();
		
		//when
		String output = distinguisher.distinguish(randomNumber, input);
		
		//then
		assertThat(output).isEqualTo("2볼 1스트라이크");
	}
	
	@Test
	@DisplayName("2볼")
	void test4() {
		//given
		List<Integer> randomNumber = Arrays.asList(1, 3, 5);
		String input = "316";
		
		Distinguisher distinguisher = new Distinguisher();
		
		//when
		String output = distinguisher.distinguish(randomNumber, input);
		
		//then
		assertThat(output).isEqualTo("2볼");
	}
	
	@Test
	@DisplayName("1볼 1스트라이크")
	void test5() {
		//given
		List<Integer> randomNumber = Arrays.asList(1, 3, 5);
		String input = "163";
		
		Distinguisher distinguisher = new Distinguisher();
		
		//when
		String output = distinguisher.distinguish(randomNumber, input);
		
		//then
		assertThat(output).isEqualTo("1볼 1스트라이크");
	}
	
	@Test
	@DisplayName("1볼")
	void test6() {
		//given
		List<Integer> randomNumber = Arrays.asList(1, 3, 5);
		String input = "263";
		
		Distinguisher distinguisher = new Distinguisher();
		
		//when
		String output = distinguisher.distinguish(randomNumber, input);
		
		//then
		assertThat(output).isEqualTo("1볼");
	}
	
	@Test
	@DisplayName("2스트라이크")
	void test7() {
		//given
		List<Integer> randomNumber = Arrays.asList(1, 3, 5);
		String input = "136";
		
		Distinguisher distinguisher = new Distinguisher();
		
		//when
		String output = distinguisher.distinguish(randomNumber, input);
		
		//then
		assertThat(output).isEqualTo("2스트라이크");
	}
	
	@Test
	@DisplayName("1스트라이크")
	void test8() {
		//given
		List<Integer> randomNumber = Arrays.asList(1, 3, 5);
		String input = "475";
		
		Distinguisher distinguisher = new Distinguisher();
		
		//when
		String output = distinguisher.distinguish(randomNumber, input);
		
		//then
		assertThat(output).isEqualTo("1스트라이크");
	}
}
