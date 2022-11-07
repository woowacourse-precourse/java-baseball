package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static baseball.Balls.*;

import java.util.ArrayList;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    
    @Test
	@DisplayName("randomNumbers가 서로 다른 3자리 수인지 테스트")
	void randomNumbersDulicationTest() {
		ArrayList<Integer> randomNumbers = makeRandomNumbers(); 
		assertThat(randomNumbers.size() == randomNumbers.stream().distinct().count()).isTrue();
		assertThat(randomNumbers.size() == 3).isTrue();
	}

    @Test
	@DisplayName("randomNumbers가 1~9 사이의 수인지 테스트")
	void randomNumbersRangeTest() {
		ArrayList<Integer> randomNumbers = makeRandomNumbers(); 
		for(int num : randomNumbers) {
			assertThat(num < 10 &&  num > 0).isTrue();
		}
	}
    
    @Test
	@DisplayName("userInputNumbers가 서로 다른 3자리 수인지 테스트")
	void userInputNumbersTest() {
		int input = 123;
		ArrayList<Integer> userInputNumbers = makeUserInputNumbers(input);
		assertThat(userInputNumbers.size() == userInputNumbers.stream().distinct().count()).isTrue();
		assertThat(userInputNumbers.size() == 3).isTrue();
		
		input = 113;
		userInputNumbers = makeUserInputNumbers(input);
		assertThat(userInputNumbers.size() == userInputNumbers.stream().distinct().count()).isFalse();
		assertThat(userInputNumbers.size() == 3).isTrue();
		
		input = 1023;
		userInputNumbers = makeUserInputNumbers(input);
		assertThat(userInputNumbers.size() == userInputNumbers.stream().distinct().count()).isTrue();
		assertThat(userInputNumbers.size() == 3).isFalse();
	}
    
    @Test	
	@DisplayName("두 수 비교하여 stike 테스트")
	void  strikeTest() {
		assertThat(Balls.isStrike(1, 1)).isTrue();
		assertThat(Balls.isStrike(1, 2)).isFalse();
	}
	
	@Test	
	@DisplayName("두 수 비교하여 ball 테스트")
	void  ballTest() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(7); 
		test.add(1); 
		test.add(3);
		assertThat(Balls.isBall(test, 1)).isTrue();
		assertThat(Balls.isBall(test, 2)).isFalse();
	}
}
