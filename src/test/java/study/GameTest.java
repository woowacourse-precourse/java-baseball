package study;

import baseball.Exception.InputException;
import baseball.service.Game;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void countBall_메소드로_볼카운트_확인() {
        String[] number = {"123", "456", "412", "302", "126"};
        String[] answer = {"123", "654", "321", "230", "456"};
        int[] result = new int[number.length];

        for (int i = 0; i < number.length; i++) {
            result[i] = Game.countBall(number[i], answer[i]);
        }

        assertThat(result).contains(0, 2, 3);
        assertThat(result).containsExactly(0, 2, 2, 3, 0);
    }

    @Test
    void countStrike_메소드로_스트라이크카운트_확인() {
        String[] number = {"123", "456", "412", "302", "126"};
        String[] answer = {"123", "654", "321", "230", "456"};
        int[] result = new int[number.length];

        for (int i = 0; i < number.length; i++) {
            result[i] = Game.countStrike(number[i], answer[i]);
        }

        assertThat(result).contains(0, 1, 3);
        assertThat(result).containsExactly(3, 1, 0, 0, 1);
    }
}
