package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void selectPlayMoreGame() {
    }

    @Test
    void playBaseBallGameOneCycle() {
    }

    @Test
    void printResult() {
    }

    @Test
    void checkMatchNumber() {
    }

    @Test
    void getStrikeCount() {
        List<Integer> randNum = Arrays.asList(1,2,3);
        List<Integer> userNum = Arrays.asList(1,2,3);
        int strikeCount=0;
        for(Integer number : userNum){
            strikeCount = Application.getStrikeCount(randNum, userNum, strikeCount, number);
        }
        assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    void getBallCount() {
        List<Integer> randNum = Arrays.asList(1,2,3);
        List<Integer> userNum = Arrays.asList(2,3,4);
        int ballCount=0;
        for(Integer number : userNum){
            ballCount = Application.getBallCount(randNum, userNum, ballCount, number);
        }
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    @DisplayName("입력한 값이 리스트로 반환되는지 확인")
    void getUserInput() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Integer> userInput = Application.getUserInput();

        assertThat(userInput).contains(1,2,3);

    }

    @Test
    @DisplayName("유저의 입력에 중복이 있는가 없는가, 숫자가 3자리인가 아닌가 테스트")
    void checkUserInput() {
        assertThatThrownBy(()->runException("112")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->runException("1234")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤한 숫자들 생성")
    void makeRandomNumbers() {
        ArrayList<Integer> computerNumber = new ArrayList<>();
        Application.makeRandomNumbers(computerNumber);
        assertThat(computerNumber.size()).isEqualTo(3);
        assertThat(computerNumber.stream().allMatch(v->v>=1&&v<=9)).isTrue();
    }

    @Test
    @DisplayName("리스트에 숫자 추가")
    void 리스트에숫자추가하기() {
        ArrayList<Integer> computerNumber = new ArrayList<>();
        Application.addRandomOneNumber(computerNumber,1);
        assertThat(computerNumber).contains(1);
    }
}
