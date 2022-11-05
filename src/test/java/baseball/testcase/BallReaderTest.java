package baseball.testcase;

import baseball.game.BallReader;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


public class BallReaderTest {
    BallReader ballReader = new BallReader();

    @DisplayName("BallReader가 제대로 결과값을 반환하는지 테스트")
    @RepeatedTest(5)
    void BALLREADER_결과값_테스트() {
        List<Integer> firstBall = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        List<Integer> secondBall = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        Map<String, Integer> result = ballReader.getResult(firstBall, secondBall);
        System.out.println("firstBall = " + firstBall);
        System.out.println("secondBall = " + secondBall);
        System.out.println(result);
        System.out.println();

        assertThat(ballReader.getResult(firstBall, secondBall)).isInstanceOf(Map.class);
    }

    @DisplayName("BallReader는 호환되지 않는 공을 입력한다면 예외를 발생시킨다.")
    @Test
    void BALLREADER_예외_테스트() {
        List<Integer> firstBall = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        List<Integer> errorBall = List.of(1, 2, 3, 4);

        assertThatThrownBy(() -> ballReader.getResult(firstBall, errorBall)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("BallReader가 3스트라이크를 일 때 게임이 끝났다 판단하는지 판독")
    @RepeatedTest(5)
    void BALLREADER_판독_결과가_참인_경우_테스트() {
        List<Integer> firstBall = Randoms.pickUniqueNumbersInRange(1,9,3);
        List<Integer> secondBall = new ArrayList<>(firstBall);

        Map<String, Integer> result = ballReader.getResult(firstBall, secondBall);
        System.out.println("result = " + result);
        System.out.println();

        assertThat(ballReader.isFinished(firstBall,secondBall)).isTrue();
    }

    @DisplayName("BallReader가 3스트라이크를 아닐 때 게임이 끝나지 않았다 판단하는지 판독")
    @RepeatedTest(5)
    void BALLREADER_판독_결과가_거짓인_경우_테스트() {
        List<Integer> firstBall = Randoms.pickUniqueNumbersInRange(1,9,3);
        List<Integer> secondBall = Randoms.pickUniqueNumbersInRange(1,9,3);

        while(ballReader.isFinished(firstBall,secondBall)){
            secondBall = Randoms.pickUniqueNumbersInRange(1,9,3);
        }

        Map<String, Integer> result = ballReader.getResult(firstBall, secondBall);
        System.out.println("firstBall = " + firstBall);
        System.out.println("secondBall = " + secondBall);
        System.out.println("result = " + result);
        System.out.println();

        assertThat(ballReader.isFinished(firstBall,secondBall)).isFalse();
    }
}
