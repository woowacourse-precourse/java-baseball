package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static unit.BaseBallGame.makeRandomNumbers;
import static baseball.Application.*;
import static baseball.Balls.*;
import static baseball.BallsNumbers.*;

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
}
