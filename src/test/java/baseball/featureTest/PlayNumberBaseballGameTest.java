package baseball.featureTest;

import baseball.PlayNumberBaseballGame;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class PlayNumberBaseballGameTest {
    PlayNumberBaseballGame playNumberBaseballGame = new PlayNumberBaseballGame();

    @Test
    void arrayList_setRandomNumberOfComputer() {
        List<Integer> randNum = playNumberBaseballGame.setRandomNumberOfComputer();
        assertThat(randNum)
                .isNotEmpty()
                .hasSize(3);
        assertThat(randNum.get(0))
                .isNotEqualTo(randNum.get(1))
                .isNotEqualTo(randNum.get(2));
        assertThat(randNum.get(1))
                .isNotEqualTo(randNum.get(2));
    }

    @Test
    void string_compareNumbersBetweenComputerAndPlayer() {
        /*
        List<String> result = new ArrayList<>(Arrays.asList(
                "낫싱", "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                "2스트라이크", "1스트라이크", "3볼","2볼","1볼",
                "2볼 1스트라이크","1볼 1스트라이크"));
         */
        assertThat(playNumberBaseballGame.compareNumbersBetweenComputerAndPlayer(
                new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(4,5,9))))
                .isEqualTo("낫싱");

        assertThat(playNumberBaseballGame.compareNumbersBetweenComputerAndPlayer(
                new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(1,2,3))))
                .contains("3스트라이크");

        assertThat(playNumberBaseballGame.compareNumbersBetweenComputerAndPlayer(
                new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(1,2,4))))
                .isEqualTo("2스트라이크");

        assertThat(playNumberBaseballGame.compareNumbersBetweenComputerAndPlayer(
                new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(1,4,5))))
                .isEqualTo("1스트라이크");

        assertThat(playNumberBaseballGame.compareNumbersBetweenComputerAndPlayer(
                new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(3,1,2))))
                .isEqualTo("3볼");

        assertThat(playNumberBaseballGame.compareNumbersBetweenComputerAndPlayer(
                new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(4,3,1))))
                .isEqualTo("2볼");

        assertThat(playNumberBaseballGame.compareNumbersBetweenComputerAndPlayer(
                new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(4,1,5))))
                .isEqualTo("1볼");

        assertThat(playNumberBaseballGame.compareNumbersBetweenComputerAndPlayer(
                new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(1,3,2))))
                .isEqualTo("2볼 1스트라이크");

        assertThat(playNumberBaseballGame.compareNumbersBetweenComputerAndPlayer(
                new ArrayList<>(Arrays.asList(1,2,3)),
                new ArrayList<>(Arrays.asList(1,4,2))))
                .isEqualTo("1볼 1스트라이크");
    }
}
